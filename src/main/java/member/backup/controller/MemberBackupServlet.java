package member.backup.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import member.info.dao.MemberBackDAO;
import member.info.dao.MemberBackJDBCDAO;
import member.login.model.MemberBean;
import util.HibernateUtil;


@WebServlet("/member/backup/MemberBackupServlet")
public class MemberBackupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session s1 = factory.getCurrentSession();
		
		HttpSession s2 = request.getSession();
		
		MemberBackDAO dao = new MemberBackJDBCDAO(s1);
		
		if(request.getParameter("selectAll") != null) {
			System.out.println("1");
			List<MemberBean> mbList = dao.selectAll();
			
			s2.setAttribute("mbList", mbList);
			System.out.println("2");
			response.sendRedirect("memberBack.jsp");
		}
	}

}
