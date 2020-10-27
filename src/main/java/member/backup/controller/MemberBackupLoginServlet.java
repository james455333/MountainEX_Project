package member.backup.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import util.HibernateUtil;


@WebServlet("/member/backup/MemberBackupLoginServlet")
public class MemberBackupLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session s1 = factory.getCurrentSession();
		
		HttpSession s2 = request.getSession();
		Map<String, String> errorMsgMap = new HashMap<String, String>();
		
		request.setAttribute("ErrorMsgKey", errorMsgMap);
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String iD = "EEIT124";
		String pwd = "test!123";
		
		if(request.getParameter("submitLogin") != null) {
			System.out.println(userId);
			System.out.println(password);
			if(userId.equals(iD) && password.equals(pwd)) {
				response.sendRedirect(request.getContextPath() + "/member/backup/Memberback.jsp");	
				System.out.println("1");
			} else {
				errorMsgMap.put("LoginError", "該帳號不存在或密碼錯誤");
				RequestDispatcher rd = request.getRequestDispatcher("loginBack.jsp");
				System.out.println("5");
				rd.forward(request, response);
				return;
			}			
		} else {
			errorMsgMap.put("LoginError", "請輸入帳號密碼");
			RequestDispatcher rd = request.getRequestDispatcher("loginBack.jsp");
			System.out.println("6");
			rd.forward(request, response);
			return;
		}
		
		
		
	}

}
