package house.hList.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import house.hList.dao.MountainHouseDAO_JDBC;
import house.hList.model.HouseBeen;

@WebServlet("/house/hList/InsertHouseServlet")
public class InsertHouseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("44");
		
		String mou = request.getParameter("mou");
		String nam = request.getParameter("nam");
		Integer sea =Integer.parseInt(request.getParameter("sea"));
		Integer cam =Integer.parseInt(request.getParameter("cam"));
		String hig = request.getParameter("hig");
		
		MountainHouseDAO_JDBC DAO = new MountainHouseDAO_JDBC();
		DAO.insertHouse(mou , nam,sea,cam,hig);
			
			
		
		request.getRequestDispatcher("house.jsp").forward(request, response);
			
		
		}
	}


