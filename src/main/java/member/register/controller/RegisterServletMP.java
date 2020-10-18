package member.register.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import member.login.model.MemberBean;
import member.register.dao.memberDAO;
import member.register.dao.memberJDBCDAO;

@WebServlet("/member/register/RegisterServletMP")
public class RegisterServletMP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
	private static final String CHARSET_CODE = "UTF-8";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(CHARSET_CODE);
		response.setContentType(CONTENT_TYPE);
		
		//連線
		DataSource ds = null;
		InitialContext ctxt = null;
		Connection connection = null;
		
		try {
			ctxt = new InitialContext();
			ds = (DataSource) ctxt.lookup("java:comp/env/jdbc/xe");
			connection = ds.getConnection();
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		//接收submit
		if(request.getParameter("submit") != null) {
			
			MemberBean mb = new MemberBean();
			memberDAO dao = new memberJDBCDAO();
			
			String mb_memberId = request.getParameter("memberId");
			mb.setMemberId(mb_memberId);
			System.out.println("1");
			
			String mb_password = request.getParameter("password");
			mb.setPassword(mb_password);
			System.out.println("2");
			
			String mb_name = request.getParameter("name");
			mb.setName(mb_name);
			System.out.println("3");
			
			String mb_address = request.getParameter("address");
			mb.setAddress(mb_address);
			System.out.println("4");
			
			String mb_email = request.getParameter("email");
			mb.setEmail(mb_email);
			System.out.println("5");
			
			String mb_tel = request.getParameter("tel");
			mb.setTel(mb_tel);
			System.out.println("6");
			
			String mb_exp = request.getParameter("exp");
			mb.setExp(mb_exp);
			System.out.println("7");
			
			
			String mb_groupId = request.getParameter("groupId");
			System.out.println(mb_groupId);
			mb.setGroupId(Integer.valueOf(mb_groupId));
			System.out.println("8");
			
			dao.insertData(mb);
			System.out.println("9");
			
			response.sendRedirect("registersucc.jsp");
	
		}
		
	}

}
