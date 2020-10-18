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

@WebServlet("/house/hList/InsertCampServlet")
public class InsertCampServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("44");
		
		String cit = request.getParameter("cit");
		String cmpt = request.getParameter("cmpt");
		
		String cmpn = request.getParameter("cmpn");
		String cmpd = request.getParameter("cmpd");
		
		CampDAO_JDBC DAO = new CampDAO_JDBC();
		DAO.insertCamp(cit,cmpt,cmpn,cmpd);
			
			
		
		request.getRequestDispatcher("camp.jsp").forward(request, response);
			
		
		}
	}


