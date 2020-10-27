package member.backup.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

import member.info.dao.MemberBackDAO;
import member.info.dao.MemberBackJDBCDAO;
import member.login.model.MemberBean;
import member.register.dao.memberDAO;
import member.register.dao.memberJDBCDAO;
import util.HibernateUtil;


@WebServlet("/member/backup/MemberBackupServlet")
public class MemberBackupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		RequestDispatcher rd = request.getRequestDispatcher("Memberback.jsp");
//		rd.forward(request, response);
////		return;
//	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		
		if(request.getParameter("selectAll") != null) {
			actionAll(request, response);
		} else if(request.getParameter("selectOne") != null) {
			actionOne(request, response);
		} else if(request.getParameter("updateA") != null) {
			actionUpdateA(request, response);
		} else if(request.getParameter("updateS") != null) {
			actionUpdateS(request, response);
		} else if(request.getParameter("submitQ1") != null) {
			actionDateInsertQ1(request, response);
		} else if(request.getParameter("submitQ2") != null) {
			actionDateInsertQ2(request, response);
		} 
		
//		doGet(request, response);
	}
	

	


	private void actionDateInsertQ1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session s1 = factory.getCurrentSession();
		
		HttpSession s2 = request.getSession();
		
		MemberBean mb = new MemberBean();
		memberDAO dao = new memberJDBCDAO(s1);
		
		mb.setAccount("makoto222");
		mb.setPassword("Do!ng123");
		mb.setName("丹禮真");
		mb.setAddress("台北市中正區中山南路21-1號");
		mb.setEmail("makoto@gmail.com");
		mb.setTel("0922-121-555");
		mb.setExp("9個月");
		mb.setGroupId(100);
		
		dao.insert(mb);
		
		s1.getTransaction().commit();
		response.sendRedirect("Memberback.jsp");
	}
	
	
	private void actionDateInsertQ2(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session s1 = factory.getCurrentSession();
		
		HttpSession s2 = request.getSession();
		
		MemberBean mb = new MemberBean();
		memberDAO dao = new memberJDBCDAO(s1);
		
		mb.setAccount("misaki777");
		mb.setPassword("Do!ng123");
		mb.setName("石凜音");
		mb.setAddress("高雄市鼓山區蓮海路70號");
		mb.setEmail("misaki@gmail.com");
		mb.setTel("0922-777-999");
		mb.setExp("八年");
		mb.setGroupId(200);
		
		dao.insert(mb);
		
		s1.getTransaction().commit();
		response.sendRedirect("Memberback.jsp");
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
		response.sendRedirect("MemberbackSelectOne.jsp");
	}
	
	
	private void actionUpdateA(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("I");
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session s1 = factory.getCurrentSession();
		
		HttpSession s2 = request.getSession();
		MemberBean mb = new MemberBean();
		MemberBackDAO dao = new MemberBackJDBCDAO(s1);
		
		
		int memberId = Integer.parseInt(request.getParameter("memberIdA"));
		System.out.println(memberId);
		mb.setMemberId(memberId);
		
		String account = request.getParameter("accountA");
		mb.setAccount(account);
		
		String password = request.getParameter("passwordA");
		mb.setPassword(password);
		
		String name = request.getParameter("nameA");
		mb.setName(name);
		
		String address = request.getParameter("addressA");
		mb.setAddress(address);
		
		String email = request.getParameter("emailA");
		mb.setEmail(email);
		
		String tel = request.getParameter("telA");
		mb.setTel(tel);
		
		String exp = request.getParameter("expA");
		mb.setExp(exp);
		
		String groupId = request.getParameter("groupIdA");
		mb.setGroupId(Integer.parseInt(groupId));
		
		String totalAmt = request.getParameter("totalAmtA");
		mb.setTotalAmt(Double.parseDouble(totalAmt));
		
		String unpaid_amount = request.getParameter("unpaid_amountA");
		mb.setUnpaid_amount(Double.parseDouble(unpaid_amount));
		
//		Blob memberImage = request.getParameter("memberImageA");
		
		dao.updateData(memberId, mb);
		List<MemberBean> mbList = dao.selectAll();
		
		s2.setAttribute("mbList", mbList);
		System.out.println("II");
		response.sendRedirect("Memberback.jsp");

	}
	
	
	private void actionUpdateS(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		System.out.println("a");
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session s1 = factory.getCurrentSession();
		
		HttpSession s2 = request.getSession();
		MemberBean mb = new MemberBean();
		MemberBackDAO dao = new MemberBackJDBCDAO(s1);
		
		
		int memberId = Integer.parseInt(request.getParameter("memberIdS"));
		System.out.println(memberId);
		mb.setMemberId(memberId);
		
		String account = request.getParameter("accountS");
		mb.setAccount(account);
		
		String password = request.getParameter("passwordS");
		mb.setPassword(password);
		
		String name = request.getParameter("nameS");
		mb.setName(name);
		
		String address = request.getParameter("addressS");
		mb.setAddress(address);
		
		String email = request.getParameter("emailS");
		mb.setEmail(email);
		
		String tel = request.getParameter("telS");
		mb.setTel(tel);
		
		String exp = request.getParameter("expS");
		mb.setExp(exp);
		
		String groupId = request.getParameter("groupIdS");
		mb.setGroupId(Integer.parseInt(groupId));
		
		String totalAmt = request.getParameter("totalAmtS");
		mb.setTotalAmt(Double.parseDouble(totalAmt));
		
		String unpaid_amount = request.getParameter("unpaid_amountS");
		mb.setUnpaid_amount(Double.parseDouble(unpaid_amount));
		
//		Blob memberImage = request.getParameter("memberImageS");
		
		dao.updateData(memberId, mb);
		List<MemberBean> oneList = dao.selectOne(account);
		
		s2.setAttribute("oneList", oneList);
		System.out.println("b");
		response.sendRedirect("MemberbackSelectOne.jsp");
		
	}

}
