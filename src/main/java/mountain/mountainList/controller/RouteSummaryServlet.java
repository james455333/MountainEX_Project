package mountain.mountainList.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import mountain.mountainList.model.MountainBean;
import mountain.mountainList.model.RouteSummary;
import mountain.mountainList.service.RouteSummaryService;
import util.HibernateUtil;

/**
 * Servlet implementation class RouteSummaryServlet
 */
@WebServlet("/mountain/RouteSummaryServlet")
public class RouteSummaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		List<MountainBean> mBeans = createMountainBean(request, response);
		session.setAttribute("mountainBean", mBeans);
		
//		try(
//				PrintWriter writer = new PrintWriter("C:\\專題\\MountainEX_Project/Mountain_MS950.csv","MS950");
//				CSVPrinter print = CSVFormat.EXCEL.withHeader("name","description","advice","traffic","npName","img_url").print(writer);
//				) {
//			for (MountainBean mountainBean : mBeans) {
//				String name = mountainBean.getName();
//				String description = mountainBean.getDescription();
//				String advice = mountainBean.getAdvice();
//				String traffic = mountainBean.getTraffic();
//				String npName = mountainBean.getNpName();
//				String imgUrl = mountainBean.getImgUrl();
//				
//				print.printRecord(name,description,advice,traffic,npName,imgUrl);
//				
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
		response.sendRedirect(request.getContextPath() + "/mountain/mountainIndex.jsp");
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		List<MountainBean> mBeans = createMountainBean(request, response);
		session.setAttribute("mountainBean", mBeans);
		response.sendRedirect(request.getContextPath() + "/mountainIndex.jsp");
		return;
	}
	
	public static List<MountainBean> createMountainBean(HttpServletRequest request, HttpServletResponse response) {

		List<MountainBean> mBeanList = new ArrayList<MountainBean>();
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		
		RouteSummaryService routeSummaryService = new RouteSummaryService(session);
		List<RouteSummary> list = routeSummaryService.selectAll();
		for (RouteSummary routeSummary : list) {
			
			MountainBean mountainBean = new MountainBean();
			
			mountainBean.setName(routeSummary.getName());
			
			Blob despBlob = routeSummary.getDescription();
			String description = transformBlob(despBlob);
			mountainBean.setDescription(description);
			
			Blob imgBlob = routeSummary.getImgURL();
			String imgURL = transformBlob(imgBlob);
			mountainBean.setImgUrl(imgURL);
			
			Blob trafficBlob = routeSummary.getTraffic();
			String traffic = transformBlob(trafficBlob);
			mountainBean.setTraffic(traffic);
			
			Blob advBlob = routeSummary.getAdvice();
			String advice = transformBlob(advBlob);
			mountainBean.setAdvice(advice);
			
			mountainBean.setNpName(routeSummary.getNpName());
			
			mBeanList.add(mountainBean);
		}
					
		return mBeanList;
		
	}
	
public static String transformBlob(Blob blob) {
		
		if(blob != null) {
			try (
					InputStream is = blob.getBinaryStream();
					InputStreamReader isr = new InputStreamReader(is, "UTF-8");
					){
				char[] chars = new char[1024];
				int buffer ;
				StringBuffer result = new StringBuffer();
				
				while((buffer = isr.read(chars, 0, 1024)) != -1) {
					
					result.append(chars, 0, buffer);
				}
				return result.toString();
				
			} catch (SQLException e1) {
				e1.printStackTrace();
				return null;
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			} 
			
		}
		
		return null;
	}

}
