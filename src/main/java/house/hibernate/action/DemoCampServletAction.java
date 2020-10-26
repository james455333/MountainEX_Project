package house.hibernate.action;

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

import house.hibernate.model.CampBean;
import house.hibernate.model.CampBeanDAO;
import util.HibernateUtil;



@WebServlet("/house/hibernate/action/DemoCampServletAction")
public class DemoCampServletAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		processAction(request,response);
		selectAll(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		selectAll(request,response);
//		processAction(request,response);
	}
	
	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		
		CampBeanDAO cDao = new CampBeanDAO(session);
		CampBean cBean = cDao.select(1);
		
		PrintWriter out = response.getWriter();
		
		out.write("Campid:" + cBean.getCampid() +"<br>");
		out.write("Campcity:" + cBean.getCity()  + "<br>");
		out.write("Camptown:" + cBean.getCamptown() + "<br>");
		out.write("Campname:" + cBean.getCampname() + "<br>");
		out.write("Campdesc:" + cBean.getCampdesc() + "<br>");
		
		out.close();
	}
	
	private void selectAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		String a = request.getParameter("see");
		CampBeanDAO cDao = new CampBeanDAO(session);
		System.out.println("44");
		try {
			
		List<CampBean> list = cDao.selectAll();
		
		
		PrintWriter out = response.getWriter();
		request.setAttribute("camp_all", out);
		
		
		request.getRequestDispatcher("camp.jsp").forward(request, response);

		out.close();
		} catch (Exception e) {
			
		}
		
	}
	
}
