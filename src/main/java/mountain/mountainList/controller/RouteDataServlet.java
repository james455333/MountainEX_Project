package mountain.mountainList.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

@WebServlet("/mountain/back/RouteDataServlet")
public class RouteDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//前端顯示用JavaBean
		NationalParkService npService = new NationalParkHibernateService(session);
		List<NationalPark> npBeans = npService.selectAll();
		
				
//		PrintWriter out = response.getWriter();
		String errorMsg = null;
//		request.setAttribute("errorMsg", errorMsg);
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		String order = request.getParameter("mOrder");
		
		List<MountainBean> mountainBeans = null;
		if (order != null) {
			if (order.equals("selectAll")) {
				
				RouteInfoService routeInfoService = new RouteInfoHibernateService(session);
				//轉換查詢結果為前端顯示的JavaBean
				try {
					mountainBeans = transRouteInfos(session, routeInfoService.selectAll());
				} catch (IOException | SQLException e) {
					//發生錯誤，request儲存進錯誤訊息
					String message = e.getMessage();
					request.setAttribute("errorMsg",message);
				}
				//若沒有發生錯誤，儲存進request
				if (request.getAttribute("errorMsg") == null) {
					request.setAttribute("mainBean", mountainBeans);
				}
				
			}else if (order.equals("國家公園查詢")) {
				
				String np = request.getParameter("nationalPark");
				int npID = Integer.parseInt(np);
				
				RouteBasicService rtBasicService = new RouteBasicHibernateService(session);
				List<RouteBasic> selectAllWithNPID = rtBasicService.selectAllWithNPID(npID);
				//轉換查詢結果為前端顯示的JavaBean
				try {
					mountainBeans = transRouteBasic(session,selectAllWithNPID);
				} catch (IOException | SQLException e) {
					//發生錯誤，request儲存進錯誤訊息
					String message = e.getMessage();
					request.setAttribute("errorMsg",message);
				}
				//若沒有發生錯誤，儲存進request
				if (request.getAttribute("errorMsg") == null) {
					request.setAttribute("mainBean", mountainBeans);
				}
			}else if (order.equals("特定路線查詢")) {
				String route = request.getParameter("route");
				int routeID = Integer.parseInt(route);
				
			}
		}
		//儲存進request
				request.setAttribute("mountainBean", mountainBeans);
				request.setAttribute("npBean", npBeans);
		
		//前往backMountain.jsp
		request.getRequestDispatcher("backMountain.jsp").forward(request, response);
		return;
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	private static String blobToString(Blob blob) throws IOException, SQLException {
		if (blob == null) {
			return "尚未有資料";
		}
		StringBuffer result = new StringBuffer();
		try (InputStream is = blob.getBinaryStream(); InputStreamReader isr = new InputStreamReader(is, "UTF-8");) {
			char[] chars = new char[1024];
			int buffer;
			while ((buffer = isr.read(chars)) != -1) {
				result.append(chars, 0, buffer);
			}
			return result.toString();
		}
	}
	
	private static List<MountainBean> transRouteInfos(Session session,List<RouteInfo> rIBean) throws IOException, SQLException{
		List<MountainBean> showList = new ArrayList<MountainBean>();

		for (RouteInfo routeInfo : rIBean) {
			MountainBean mountainBean = new MountainBean();
			mountainBean.setSeqno(routeInfo.getRbPK());
			mountainBean.setName(routeInfo.getName());
			
			Blob descpBlob = routeInfo.getDescription();
			String description = blobToString(descpBlob);
			mountainBean.setDescription(description);
			
			Blob adviceBlob = routeInfo.getAdvice();
			String advice = blobToString(adviceBlob);
			mountainBean.setAdvice(advice);
			
			Blob traBlob = routeInfo.getTraffic();
			String traffic = blobToString(traBlob);
			mountainBean.setTraffic(traffic);
			
			Blob imgUrlBlob = routeInfo.getImgUrl();
			String imgURL = blobToString(imgUrlBlob);
			imgURL = imgURL.substring(imgURL.lastIndexOf("/"), imgURL.length());
			mountainBean.setImgUrl(imgURL);
			
			RouteBasic routeBasic = routeInfo.getRoute_basic();
			NationalPark nationalPark = routeBasic.getNational_park();
			String nPName = nationalPark.getName();
			mountainBean.setNpName(nPName);
			
			showList.add(mountainBean);
		}
		return showList;
	}
	
	private static List<MountainBean> transRouteBasic(Session session, List<RouteBasic> selectAllWithNPID) throws IOException, SQLException {
		
		List<MountainBean> showList = new ArrayList<MountainBean>();
		List<RouteInfo> rIBeans = new ArrayList<RouteInfo>();
		for (RouteBasic routeBasic : selectAllWithNPID) {
			rIBeans.add(routeBasic.getRouteInfo());
		}
		for (RouteInfo routeInfo : rIBeans) {
			MountainBean mountainBean = new MountainBean();
			mountainBean.setSeqno(routeInfo.getRbPK());
			mountainBean.setName(routeInfo.getName());
			
			Blob descpBlob = routeInfo.getDescription();
			String description = blobToString(descpBlob);
			mountainBean.setDescription(description);
			
			Blob adviceBlob = routeInfo.getAdvice();
			String advice = blobToString(adviceBlob);
			mountainBean.setAdvice(advice);
			
			Blob traBlob = routeInfo.getTraffic();
			String traffic = blobToString(traBlob);
			mountainBean.setTraffic(traffic);
			
			Blob imgUrlBlob = routeInfo.getImgUrl();
			String imgURL = blobToString(imgUrlBlob);
			imgURL = imgURL.substring(imgURL.lastIndexOf("/"), imgURL.length());
			mountainBean.setImgUrl(imgURL);
			
			RouteBasic routeBasic = routeInfo.getRoute_basic();
			NationalPark nationalPark = routeBasic.getNational_park();
			String nPName = nationalPark.getName();
			mountainBean.setNpName(nPName);
			
			showList.add(mountainBean);
		}
		return showList;
		
	}

}
