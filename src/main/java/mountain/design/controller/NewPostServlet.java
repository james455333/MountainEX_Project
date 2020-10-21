package mountain.design.controller;

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
import mountain.design.model.ActBean;

@WebServlet("/mountain/design/newPostServlet")
public class NewPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public NewPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		ActBean actBean = (ActBean) session.getAttribute("postBean");
		session.setAttribute("errorMsg", null);
		session.setAttribute("confirmInsert", null);
		int newPost = 0;
		DataS dataS = new DataS();
		dataS.setUsername("hr");
		dataS.setUserPassword("hr");
		DataSource datasoure = dataS.getDatasoure();
		try (Connection connection = datasoure.getConnection();){
			newPost = new ActDAO().newPost(actBean,connection);
			connection.commit();
//			newPost = new ActDAO().newPostToReg(actBean, connection);
			connection.commit();
		} catch (SQLException e) {
			session.setAttribute("errorMsg", "發生SQL錯誤請重新嘗試\n"+e.getMessage());
			e.printStackTrace();
		}
		if (newPost==1 && (session.getAttribute("errorMsg")==null) ) {
			session.removeAttribute("actBean");
			session.setAttribute("confirmInsert", "新增成功");
			response.sendRedirect(request.getContextPath()+"/mountain/design/mountainDesign.jsp");
			return;
		}else {
			session.removeAttribute("actBean");
			session.setAttribute("confirmInsert", "新增失敗");
			response.sendRedirect(request.getContextPath()+"/mountain/design/mountainDesign.jsp");
		}
		
		
	}

}
