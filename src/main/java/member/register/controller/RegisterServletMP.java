package member.register.controller;

import java.io.IOException;
import java.sql.Blob;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import member.login.model.MemberBean;
import member.register.dao.memberDAO;
import member.register.dao.memberJDBCDAO;
import util.HibernateUtil;

@WebServlet("/member/register/RegisterServletMP")
public class RegisterServletMP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
	private static final String CHARSET_CODE = "UTF-8";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(CHARSET_CODE);
		response.setContentType(CONTENT_TYPE);
		
		//連線
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session s1 = factory.getCurrentSession();
		
		
		//接收submit
		if(request.getParameter("submit") != null) {
			
			MemberBean mb = new MemberBean();
			memberDAO dao = new memberJDBCDAO(s1);
			
			String mb_account = request.getParameter("account");
			mb.setAccount(mb_account);
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
			
			dao.insert(mb);
			System.out.println("9");
			
			s1.getTransaction().commit();
			response.sendRedirect("registersucc.jsp");
	
		} else if(request.getParameter("submitQ2") != null) {
			
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
			response.sendRedirect("registersucc.jsp");
			
		} else if(request.getParameter("submitQ1") != null) {
			
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
			response.sendRedirect("registersucc.jsp");
			
		}
		
	}

}
