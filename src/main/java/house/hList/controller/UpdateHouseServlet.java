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

@WebServlet("/house/hList/UpdateHouseServlet")
public class UpdateHouseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("33");
		
		String mou1 = request.getParameter("mou1");
		String nam1 = request.getParameter("nam1");
		Integer sea1 =Integer.parseInt(request.getParameter("sea1"));
		Integer cam1 =Integer.parseInt(request.getParameter("cam1"));
		String hig1 = request.getParameter("hig1");
		
		
		 MountainHouseDAO_JDBC DAO = new MountainHouseDAO_JDBC();
		 DAO.updateHouse(mou1 , nam1,sea1,cam1,hig1);
		
			
		
//		request.getRequestDispatcher("updatehouse.jsp").forward(request, response);
		 response.sendRedirect("updatehouse.jsp");
		
		}
	}


