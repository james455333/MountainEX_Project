package mountain.actList.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mountain.design.dao.ActDAO;
import mountain.design.model.ActBean;


@WebServlet("/mountain/actList/ActDetailServlet")
public class ActDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String postID = request.getParameter("post_id");
		ActDAO actDAO = new ActDAO();
		List<ActBean> queryPosts;
		ActBean queryPost = null;
		try {
			queryPosts = actDAO.queryPost();
			for (ActBean actBean : queryPosts) {
				int postID2 = actBean.getPostID();
				Integer valueOfPostID = Integer.valueOf(postID);
				if (postID2 == valueOfPostID) {
					queryPost = actBean;
				}
			}
		} catch (SQLException e) {
			request.setAttribute("errorMsg", "發生錯誤" + " : " + e.getMessage());
			e.printStackTrace();
		}
		
		
		
		if (queryPost != null) {
			request.setAttribute("regAct", queryPost);
			request.getRequestDispatcher("activityDetail.jsp").forward(request, response);
			return;
		}else {
			request.setAttribute("errorMsg", "發生錯誤，請稍後再試");
			request.getRequestDispatcher("mountainActList.jsp").forward(request, response);
			return;
		}
		
	}

	

}
