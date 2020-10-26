package mountain.mountainList.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import mountain.mountainList.model.MountainBean;
import mountain.mountainList.model.NationalPark;
import mountain.mountainList.model.RouteBasic;
import mountain.mountainList.model.RouteInfo;
import mountain.mountainList.service.NationalParkHibernateService;
import mountain.mountainList.service.RouteBasicHibernateService;
import mountain.mountainList.service.RouteInfoHibernateService;
import mountain.mountainList.service.impl.NationalParkService;
import mountain.mountainList.service.impl.RouteBasicService;
import mountain.mountainList.service.impl.RouteInfoService;
import util.HibernateUtil;

@WebServlet("/mountain/RouteDataServlet")
public class RouteDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		List<String> errorMsg = new ArrayList<String>();
//		request.setAttribute("errorMsg", errorMsg);
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		String order = request.getParameter("mOrder");
		if(order!=null) {
			if(order.equals("selectAll")) {
				RouteInfoService rIService = new RouteInfoHibernateService(session);
				List<RouteInfo> rIBean = rIService.selectAll();
				List<MountainBean> showList = new ArrayList<MountainBean>();
				
				for (RouteInfo routeInfo : rIBean) {
					session = factory.getCurrentSession();
					MountainBean mountainBean = new MountainBean();
					mountainBean.setSeqno(routeInfo.getRbPK());
					mountainBean.setName(routeInfo.getName());
					Blob descpBlob = routeInfo.getDescription();
					String description = blobToString(descpBlob, request,response);
					mountainBean.setDescription(description);
					Blob adviceBlob = routeInfo.getAdvice();
					String advice = blobToString(adviceBlob, request, response);
					mountainBean.setAdvice(advice);
					Blob traBlob = routeInfo.getTraffic();
					String traffic = blobToString(traBlob, request, response);
					mountainBean.setTraffic(traffic);
					Blob imgUrlBlob = routeInfo.getImgUrl();
					String imgURL = blobToString(imgUrlBlob, request, response);
					mountainBean.setImgUrl(imgURL);
					RouteBasic routeBasic = routeInfo.getRoute_basic();
					NationalPark nationalPark = routeBasic.getNational_park();
					String nPName = nationalPark.getName();
					mountainBean.setNpName(nPName);
					showList.add(mountainBean);
					out.write(routeInfo.getName()+"<br>");
					out.write(description + "<br>");
				}
//				request.setAttribute("mountainBean", showList);
//				request.getRequestDispatcher("/mountain/back/backMountain.jsp").forward(request, response);
//				return;
						
						
					
				}
		}else {
			
			errorMsg.add("指令錯誤，請重新輸入");
			request.setAttribute("errorMsg", errorMsg);
			request.getRequestDispatcher("/mountain/back/backMountain.jsp").forward(request, response);
			return;
		}
		

	

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public String blobToString(Blob blob,HttpServletRequest request,HttpServletResponse response) throws IOException {
		if(blob==null) {
			return "尚無資料";
		}
		StringBuffer result = new StringBuffer();
		try(
				InputStream is = blob.getBinaryStream(); 
				InputStreamReader isr = new InputStreamReader(is, "UTF-8");
				) {
			char[] chars = new char[1024];
			int buffer;
			while ((buffer = isr.read(chars)) != -1) {
				result.append(chars, 0, buffer);
			}
			return result.toString();
		} catch (SQLException e) {
			request.setAttribute("errorMsg", "SQL錯誤發生 : " + e.getSQLState() + " : "+ e.getErrorCode() + " : " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e1) {
			request.setAttribute("errorMsg", "IO錯誤發生 : " + " : " + e1.getMessage());
			e1.printStackTrace();
		} catch(Exception ex){
			ex.printStackTrace();
		}
		return result.toString();
	}

}
