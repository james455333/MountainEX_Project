package house.hibernate.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.sql.Update;

import house.hibernate.model.CampBean;
import house.hibernate.model.CampBeanDAO;
import house.hibernate.model.CampBeanService;
import house.hibernate.model.ICampBeanService;
import util.HibernateUtil;

@WebServlet("/house/back/DemoCampServletAction")
public class DemoCampServletAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

//		select(request,response);

//		String test = request.getParameter("selectall");
//		ICampBeanService icampBeanService = new CampBeanService(session);
//		if (test.equals("All")) {
//			
//		}else if(test.equals("insert")){
//			icampBeanService.select(campid);
//			if (icampBeanService==null) {
//				request.setAttribute("test", "SHOW");
//			}
//		}else if (test.equals("SHOW")) {
//			selectAll(request,response);
//			RequestDispatcher dispatcher = request.getRequestDispatcher("backCamp.jsp");
//			dispatcher.forward(request, response);
//		}
//		RequestDispatcher dispatcher = request.getRequestDispatcher("DemoCampServletAction?test=show");
//		dispatcher.forward(request, response);
//		return;

		RequestDispatcher dispatcher = request.getRequestDispatcher("backCamp.jsp");
		dispatcher.forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

//		String dosomething = request.getParameter("dosomething");
//		ICampBeanService icampBeanService = new CampBeanService(session);
		if (request.getParameter("selectAll") != null) {
			selectAll(request, response);
		} else if (request.getParameter("selectcity") != null) {
			selectCity(request, response);
		}else if (request.getParameter("selectcamptown")!=null) {
			selectCampTown(request, response);
		}else if (request.getParameter("selectcampname")!=null) {
			selectCampName(request,response);
		}else if (request.getParameter("insercamp")!=null) {
			inserCamp(request, response);
		}else if (request.getParameter("updatecamp")!=null) {
			updateCamp(request, response);
		}else if (request.getParameter("deletecamp")!=null) {
			deleteCamp(request, response);
		} {
			 
		}

		doGet(request, response);
	}

//	private void select(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		SessionFactory factory = HibernateUtil.getSessionFactory();
//		Session session = factory.getCurrentSession();
//			
//		CampBeanDAO cDao = new CampBeanDAO(session);
//		CampBean cBean = cDao.select(1);
//		
//		PrintWriter out = response.getWriter();
//		
//		out.write("Campid:" + cBean.getCampid() +"<br>");
//		out.write("Campcity:" + cBean.getCity()  + "<br>");
//		out.write("Camptown:" + cBean.getCamptown() + "<br>");
//		out.write("Campname:" + cBean.getCampname() + "<br>");
//		out.write("Campdesc:" + cBean.getCampdesc() + "<br>");
//		
//		
//	}

	private void selectAll(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		String selectall = request.getParameter("selectall");

		CampBeanDAO cDao = new CampBeanDAO(session);

		List<CampBean> list = cDao.selectAll();

		request.setAttribute("camp_all", list);

	}

	private void selectCity(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		CampBeanDAO cDao = new CampBeanDAO(session);

		String selectcity = request.getParameter("selectcity");

		List<CampBean> list = cDao.selectCity(selectcity);

		request.setAttribute("camp_city", list);

	}

	public void selectCampTown(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		CampBeanDAO cDao = new CampBeanDAO(session);
		
		String selectcamptown = request.getParameter("selectcamptown");
		
		List<CampBean> list = cDao.selectCampTown(selectcamptown);
		
		request.setAttribute("camp_camptown", list);
	
	}
	
	public void selectCampName(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		CampBeanDAO cDao = new CampBeanDAO(session);
		
		String selectcampname = request.getParameter("selectcampname");
		
		List<CampBean> list = cDao.selectCampName(selectcampname);
		
		request.setAttribute("camp_campname", list);
		
	}
	
	public void inserCamp(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		CampBeanService campservice = new CampBeanService(session);
		
		CampBeanDAO cDao = new CampBeanDAO(session);
		
		CampBean cBean = new CampBean();
		
//		int camp_id = Integer.parseInt(request.getParameter("insercamp_id"));
//		cBean.setCampid(camp_id);
		
		String city = request.getParameter("insercamp_city");
		cBean.setCity(city);
		System.out.println("1");
		String camptown = request.getParameter("insercamp_town");
		cBean.setCamptown(camptown);
		System.out.println("2");
		
		String campname = request.getParameter("insercamp_name");
		cBean.setCampname(campname);
		
		String campdesc = request.getParameter("insercamp_desc");
		cBean.setCampdesc(campdesc);
		
		campservice.insertCamp(cBean);
	}
	
	public void updateCamp(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		CampBeanService campservice = new CampBeanService(session);
		
		CampBeanDAO cDao = new CampBeanDAO(session);
		
		CampBean cBean = new CampBean();
		
		int updatecamp_id = Integer.parseInt(request.getParameter("updatacamp_id"));
		cBean.setCampid(updatecamp_id);
		String updatecamp_city = request.getParameter("updatecamp_city");
		cBean.setCity(updatecamp_city);
		String updatecamp_town = request.getParameter("updatecamp_town");
		cBean.setCamptown(updatecamp_town);
		String updatecamp_name = request.getParameter("updatecamp_name");
		cBean.setCampname(updatecamp_name);
		String updatecamp_desc = request.getParameter("updatecamp_desc");
		cBean.setCampdesc(updatecamp_desc);
		
		cDao.update(cBean);
		
	}
	
	public void deleteCamp(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		CampBeanDAO cDao = new CampBeanDAO(session);
		CampBean cBean = new CampBean();
		
		String str = request.getParameter("deletecampid");
		int delecampid = Integer.parseInt(str);
		
		cDao.deleteCamp(delecampid);

	}

}
