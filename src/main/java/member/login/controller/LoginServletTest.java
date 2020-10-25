package member.login.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import member.login.model.MemberBean;
import util.HibernateUtil;


@WebServlet("/LoginServletTest")
public class LoginServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request, response);
	}
	
	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		HttpSession session2 = request.getSession();
		Map<String, String> errorMsgMap = new HashMap<String, String>();
		
		request.setAttribute("ErrorMsgKey", errorMsgMap);
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		MemberBean mb = new MemberBean();
		
		
		try {
			
			Query<MemberBean> query = session.createQuery("From Member where memberId =: userId and password =: password", MemberBean.class);
			query.setParameter("userId", userId);
			query.setParameter("password", password);
			
			mb = query.uniqueResult();
			
			
			if (mb != null) {
				session2.setAttribute("LoginOK", mb);
			}else {
				errorMsgMap.put("LoginError", "該帳號不存在或密碼錯誤");
			}
		} catch (RuntimeException e) {
			errorMsgMap.put("LoginError", e.getMessage());
		}
		
		if(errorMsgMap.isEmpty()) {
			session2.setAttribute("MemberBean", mb);
			response.sendRedirect("loginsucc.jsp");
			return;
		}else {
			response.sendRedirect("logintest.jsp");
			return;
		}
		
		
		
		
		
		
		
	}

}
