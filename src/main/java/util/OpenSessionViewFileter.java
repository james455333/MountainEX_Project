package util;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

@WebFilter( servletNames = "OpenSessionViewFileter", urlPatterns = "/*" )
public class OpenSessionViewFileter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		System.out.println("Session Opened");
		
		try {
			
			session.beginTransaction();
			System.out.println("Transaction Begin");
			
			chain.doFilter(request, response);

			session.getTransaction().commit();
			System.out.println("Transaction Commit");
		
		} catch (Exception e) {
			
			session.getTransaction().rollback();
			System.out.println("Transaction Rollback");
			e.printStackTrace();
		
		} finally {
			
			System.out.println("Session Closed");
		
		}
		
		
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
