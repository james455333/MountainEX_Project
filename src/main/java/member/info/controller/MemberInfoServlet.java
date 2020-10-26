package member.info.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MemberInfoServlet")
public class MemberInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		if(request.getParameter("update") != null) {
			System.out.println("A");
			response.sendRedirect(request.getContextPath() + "/member/info/memberInfoUpdate.jsp");
			return;
		}
		
		
		if(request.getParameter("logout") != null) {
			System.out.println("B");
			response.sendRedirect(request.getContextPath() + "/member/login/logout.jsp");
		}
	}

}
