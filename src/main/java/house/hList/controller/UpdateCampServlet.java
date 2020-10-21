package house.hList.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import house.hList.dao.CampDAO_JDBC;
import house.hList.dao.MountainHouseDAO_JDBC;
import house.hList.model.HouseBeen;

@WebServlet("/house/hList/UpdateCampServlet")
public class UpdateCampServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("33");
		
		String cit1 = request.getParameter("cit1");
		String cmpt1 = request.getParameter("cmpt1");
		String cmpn1 = request.getParameter("cmpn1");
		String cmpd1 = request.getParameter("cmpd1");
		
		
		 CampDAO_JDBC DAO= new CampDAO_JDBC();
		 DAO.updateCamp(cit1, cmpt1, cmpn1, cmpd1);
		
			
		
//		request.getRequestDispatcher("updatehouse.jsp").forward(request, response);
		 response.sendRedirect("updatecamp.jsp");
		
		}
	}


