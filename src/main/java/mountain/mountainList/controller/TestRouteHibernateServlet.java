package mountain.mountainList.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import mountain.mountainList.model.NationalPark;
import mountain.mountainList.model.RouteBasic;
import mountain.mountainList.model.RouteInfo;
import mountain.mountainList.service.RouteInfoHibernateService;
import mountain.mountainList.service.impl.RouteInfoService;
import util.HibernateUtil;

@WebServlet("/TestRouteHibernateServlet")
public class TestRouteHibernateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		RouteInfoService rIService = new RouteInfoHibernateService(session);
		List<RouteInfo> selectAll = rIService.selectAll();
		for (RouteInfo routeInfo : selectAll) {
			RouteBasic route_basic = routeInfo.getRoute_basic();
			out.write(routeInfo.getName()+"<br>");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
