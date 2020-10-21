package mountain.actList.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import dB.DataS;
import mountain.design.dao.ActDAO;


@WebServlet("/mountain/design/DeleteActServlet")
public class DeleteActServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String postID = request.getParameter("delete_id");
		DataS dataS = new DataS();
		dataS.setUsername("hr");
		dataS.setUserPassword("hr");
		DataSource datasoure = dataS.getDatasoure();
		HttpSession session = request.getSession();
		try(
				Connection connection = datasoure.getConnection();
				) {
			try {
				int result = new ActDAO().deletePost(postID, connection);
				
				if (result == 1) {
					connection.commit();
					session.setAttribute("deleteConfirm", "刪除成功");
					String header = request.getHeader("referer");
					response.sendRedirect(header);
				}else {
					connection.rollback();
					session.setAttribute("deleteConfirm", "刪除失敗");
					String header = request.getHeader("referer");
					response.sendRedirect(header);
				}
				
			} catch (SQLException e) {
				connection.rollback();
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}

	

}
