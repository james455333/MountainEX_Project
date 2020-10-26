package member.login.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import member.login.model.MemberBean;
import member.register.dao.memberDAO;
import member.register.dao.memberJDBCDAO;
import util.HibernateUtil;




@WebServlet("/member/login/LoginServlet")
public class LoginServlet extends HttpServlet {
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
		String rm = request.getParameter("rememberMe");
//		String requestURI = (String) session.getAttribute("requestURI");
		
		//rememberMe
		Cookie cookieUser =  null;
		Cookie cookiePassword = null;
		Cookie cookieRememberMe = null;
		
		if(rm != null) {
			cookieUser = new Cookie("user", userId);
			cookieUser.setMaxAge(7 * 24 * 60 * 60); //自最後一次連線後起算七天
			cookieUser.setPath(request.getContextPath());
			
//			String encodePassword = GlobalService.encryptString(password);
			cookiePassword = new Cookie("password", password);
			cookiePassword.setMaxAge(7 * 24 * 60 * 60);
			cookiePassword.setPath(request.getContextPath());
			
			cookieRememberMe = new Cookie("rm", "true");
			cookieRememberMe.setMaxAge(7 * 24 * 60 * 60);
			cookieRememberMe.setPath(request.getContextPath());		
		} else {
	 		//如果user沒有對rememberMe打勾
	 		cookieUser = new Cookie("user", userId);
	 		cookieUser.setMaxAge(0);
	 		cookieUser.setPath(request.getContextPath());
	 		
	// 		String encodePassword = GlobalService.encryptString(password);
	 		cookiePassword = new Cookie("password", password);
	 		cookiePassword.setMaxAge(0);
	 		cookiePassword.setPath(request.getContextPath());
	 		
	 		cookieRememberMe = new Cookie("rm", "true");
	 		cookieRememberMe.setMaxAge(0);
	 		cookieRememberMe.setPath(request.getContextPath());
		}
		response.addCookie(cookieUser);
		response.addCookie(cookiePassword);
		response.addCookie(cookieRememberMe);
		
		MemberBean mb = new MemberBean();
		memberDAO dao = new memberJDBCDAO(s1);
		
		//確認user輸入的密碼
		try {
			System.out.println(userId);
			System.out.println(password);

			mb = dao.checkIdPassword(userId, password);
			System.out.println("7");
			
			if(mb != null) {
				s2.setAttribute("LoginOK", mb);
				System.out.println("1");
			}else {
				errorMsgMap.put("LoginError", "該帳號不存在或密碼錯誤");
				System.out.println("2");
			}
		} catch (RuntimeException e) {
			errorMsgMap.put("LoginError", e.getMessage());
			e.printStackTrace();
			System.out.println("3");
		}
		
		if(errorMsgMap.isEmpty()) {
			s2.setAttribute("MemberBean", mb);
			System.out.println(userId);
			response.sendRedirect("loginsucc.jsp");
//			response.sendRedirect("loginsucc.jsp");
			System.out.println("4");
//			dispatcher.forward(request, response);
			return;
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			System.out.println("5");
			rd.forward(request, response);
			return;
		}
	

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String email = request.getParameter("email");
//		String pwd = request.getParameter("pwd");
//		if ( !email.equals("j@jjj.mail") ) {
//			request.getRequestDispatcher("login.jsp").forward(request, response);;
//			return;
//		}
//		
//		MemberBean memberBean = new MemberBean();
//		
//		memberBean.setEmail(email);
//		memberBean.setPwd(pwd);
//		
//		request.getSession().setAttribute("memberBean", memberBean);
//		response.sendRedirect(request.getContextPath()+"/index.jsp");
//		MemberBean attribute = (MemberBean)request.getSession().getAttribute("memberBean");
//		System.out.println(attribute.getEmail());
//		
//		
//		return;
//	}
	}
}
