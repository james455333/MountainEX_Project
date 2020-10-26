package member.info.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sound.midi.Soundbank;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import member.info.dao.memberInfoDAO;
import member.info.dao.memberInfoJDBCDAO;
import member.login.model.MemberBean;
import oracle.net.aso.f;
import oracle.net.aso.m;
import util.HibernateUtil;


@WebServlet("/MemberInfoUpdateServlet")
public class MemberInfoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session s1 = factory.getCurrentSession();
		
		HttpSession s2 = request.getSession(false);
		String account = request.getParameter("userId");
		String groupId = request.getParameter("groupId");
		
//		MemberBean mb = new MemberBean();
		
		if(request.getParameter("update") != null) {
//			System.out.println("B");
			
			MemberBean mb = new MemberBean();
			memberInfoDAO infoDAO = new memberInfoJDBCDAO(s1);
			List<MemberBean> listMbInfo = infoDAO.listMbInfo();
			
			
			mb.setAccount(account);
			System.out.println("B");
			
//			mb.setMemberId(memberId);
//			System.out.println(memberId);

			String mb_password = request.getParameter("password");
			mb.setPassword(mb_password);
			System.out.println("C");
			
			String mb_name = request.getParameter("name");
			mb.setName(mb_name);
			System.out.println("D");
			
			String mb_address = request.getParameter("address");
			mb.setAddress(mb_address);
			System.out.println("E");

			String mb_email = request.getParameter("email");
			mb.setEmail(mb_email);
			System.out.println("F");
			
			String mb_tel = request.getParameter("tel");
			mb.setTel(mb_tel);
			System.out.println("G");
			
			String mb_exp = request.getParameter("exp");
			mb.setExp(mb_exp);
			System.out.println("H");
			
			mb.setGroupId(Integer.parseInt(groupId));
			System.out.println(groupId);
			
			 listMbInfo.add(mb);
			 infoDAO.updateData(mb);
			 System.out.println("I");
			 
			 //重新設定session中的MemberBean
			 s2.setAttribute("MemberBean", mb);
			 
			 response.sendRedirect(request.getContextPath() + "/member/info/memberInfo.jsp");

		}
			
	}
		

}
