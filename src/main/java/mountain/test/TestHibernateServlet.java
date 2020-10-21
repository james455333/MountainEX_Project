package mountain.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import mountain.mountainList.model.RouteSummary;
import mountain.mountainList.service.RouteSummaryService;
import util.HibernateUtil;

@WebServlet("/TestHibernateServlet")
public class TestHibernateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		access(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		access(request, response);
	}
	
	
	public static void access(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			
			RouteSummaryService routeSummaryService = new RouteSummaryService(session);
			List<RouteSummary> selectAll = routeSummaryService.selectAll();
			for (RouteSummary routeSummary : selectAll) {
				out.write("Route_name : " + routeSummary.getName() +"<br>");
				Blob imgBlob = routeSummary.getImgURL();
				out.write("imgURL : " + transformBlob(imgBlob) +"<br>");
				Blob despBlob = routeSummary.getDescription();
				out.write("description : " + transformBlob(despBlob) +"<br>");
			}
			
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		
		
	}
	
	public static String transformBlob(Blob blob) {
		
		if(blob != null) {
			try (
					InputStream is = blob.getBinaryStream();
					InputStreamReader isr = new InputStreamReader(is, "UTF-8");
					){
				char[] chars = new char[1024];
				int buffer ;
				StringBuffer result = new StringBuffer();
				
				while((buffer = isr.read(chars, 0, 1024)) != -1) {
					
					result.append(chars, 0, buffer);
				}
				return result.toString();
				
			} catch (SQLException e1) {
				e1.printStackTrace();
				return null;
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			} 
			
		}
		
		return null;
	}

}
