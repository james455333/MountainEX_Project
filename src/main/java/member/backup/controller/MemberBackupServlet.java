package member.backup.controller;

import java.io.IOException;
import java.sql.Blob;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.tool.schema.extract.spi.ExtractionContext.DatabaseObjectAccess;

import member.info.dao.MemberBackDAO;
import member.info.dao.MemberBackJDBCDAO;
import member.info.dao.memberInfoDAO;
import member.login.model.MemberBean;
import util.HibernateUtil;


@WebServlet("/member/backup/MemberBackupServlet")
public class MemberBackupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		
		
		if(request.getParameter("selectAll") != null) {
			actionAll(request, response);
		} else if(request.getParameter("selectOne") != null) {
			actionOne(request, response);
		} else if(request.getParameter("update") != null) {
			actionUpdate(request, response);
		}
		
//		request.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html; charset=UTF-8");
//		
//		SessionFactory factory = HibernateUtil.getSessionFactory();
//		Session s1 = factory.getCurrentSession();
//		
//		HttpSession s2 = request.getSession();
//		
//		MemberBackDAO dao = new MemberBackJDBCDAO(s1);
//		
//		if(request.getParameter("selectAll") != null) {
//			System.out.println("1");
//			List<MemberBean> mbList = dao.selectAll();
//			
//			s2.setAttribute("mbList", mbList);
//			System.out.println("2");
//			response.sendRedirect("Memberback.jsp");
//		}
	}
	
	
	private void actionAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("1");
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session s1 = factory.getCurrentSession();
		
		HttpSession s2 = request.getSession();
		
		MemberBackDAO dao = new MemberBackJDBCDAO(s1);
		
		List<MemberBean> mbList = dao.selectAll();
		
		s2.setAttribute("mbList", mbList);
		System.out.println("2");
		response.sendRedirect("Memberback.jsp");
	}
	
	
	private void actionOne(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("A");
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session s1 = factory.getCurrentSession();
		
		HttpSession s2 = request.getSession();
		String userId = request.getParameter("userId");
		
		MemberBackDAO dao = new MemberBackJDBCDAO(s1);
		
		List<MemberBean> oneList = dao.selectOne(userId);
		
		s2.setAttribute("oneList", oneList);
		System.out.println("B");
		response.sendRedirect("Memberback.jsp");
	}
	
	
	private void actionUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("I");
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session s1 = factory.getCurrentSession();
		
		HttpSession s2 = request.getSession();
		MemberBean mb = new MemberBean();
		MemberBackDAO dao = new MemberBackJDBCDAO(s1);
		
		int memberId = (Integer.parseInt(request.getParameter("memberId")));
		mb.setMemberId(memberId);
		
		String account = request.getParameter("account");
		mb.setAccount(account);
		
		String password = request.getParameter("password");
		mb.setPassword(password);
		
		String name = request.getParameter("name");
		mb.setName(name);
		
		String address = request.getParameter("address");
		mb.setAddress(address);
		
		String email = request.getParameter("email");
		mb.setEmail(email);
		
		String tel = request.getParameter("tel");
		mb.setTel(tel);
		
		String exp = request.getParameter("exp");
		mb.setExp(exp);
		
		int groupId = (Integer.parseInt(request.getParameter("groupId")));
		mb.setGroupId(groupId);
		
		double totalAmt = (Integer.parseInt(request.getParameter("totalAmt")));
		mb.setTotalAmt(totalAmt);
		
		double unpaid_amount = (Integer.parseInt(request.getParameter("unpaid_amount")));
		mb.setUnpaid_amount(unpaid_amount);
		
//		Blob memberImage = request.getParameter("memberImage");
		
		dao.updateData(memberId, mb);
		
		s2.setAttribute("info", mb);
		System.out.println("II");
		response.sendRedirect("Memberback.jsp");

	}

}
