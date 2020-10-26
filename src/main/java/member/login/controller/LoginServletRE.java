package member.login.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.SQLException;

import javax.management.MBeanAttributeInfo;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import member.login.model.MemberBean;
import member.register.dao.memberDAO;
import member.register.dao.memberJDBCDAO;
import oracle.net.aso.m;
import util.HibernateUtil;

@WebServlet("/LoginServletRE")
public class LoginServletRE extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session s1 = factory.getCurrentSession();
		
		
		MemberBean mb = new MemberBean();
		memberDAO dao = new memberJDBCDAO(s1);
		
		mb.setAccount("akane777");
		mb.setPassword("Do!ng123");
		mb.setName("赤根那奈");
		mb.setAddress("高雄市鼓山區蓮海路70號");
		mb.setEmail("akane@gmail.com");
		mb.setTel("0922-777-555");
		mb.setExp("一年");
		mb.setGroupId(100);
		mb.setTotalAmt(200);
		mb.setUnpaid_amount(300);
		Blob bb = null;
		mb.setMemberImage(bb);

//		mb = dao.insert(mb);
		
		Query<MemberBean> query = s1.createQuery("From MemberBean where account = ?0 and password = ?1", MemberBean.class);
		query.setParameter(0, mb.getAccount());
		query.setParameter(1, mb.getPassword());
		
		mb = query.uniqueResult();
		
		PrintWriter out = response.getWriter();
		out.write("name：" + mb.getAccount() + "<br/>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
		
		
	}

}
