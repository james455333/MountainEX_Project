package house.hibernate.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import house.hibernate.model.CampBean;
import house.hibernate.model.CampBeanDAO;
import house.hibernate.model.CampBeanService;
import house.hibernate.model.MountainHouseBean;
import house.hibernate.model.MountainHouseDAO;
import house.hibernate.model.MountainHouseService;
import util.HibernateUtil;


@WebServlet("/house/back/DemoMountainHouseServletAction")
public class DemoMountainHouseServletAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("backMountainHouse.jsp");
		dispatcher.forward(request, response);
//		response.sendRedirect("backMountainHouse.jsp");
		return;
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		if (request.getParameter("selectAll") != null) {
			selectAll(request, response);
		} else if (request.getParameter("selectMountainName") != null) {
			selectMountainName(request, response);
		}else if (request.getParameter("selectMountainHouseName")!=null) {
			selectMountainHouseName(request, response);
		}else if (request.getParameter("inserMountainHouse")!=null) {
			inserMountainHouse(request,response);
		}else if (request.getParameter("updateMountainHouse")!=null) {
			updateMountainHouse(request, response);
		}else if (request.getParameter("deleteMountainHouse")!=null) {
			deleteMountainHouse(request, response);
		} {
			
		}
		
		doGet(request, response);
	}
	
	private void selectAll(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		String selectall = request.getParameter("selectall");
		MountainHouseDAO mDao = new MountainHouseDAO(session);
		
		List<MountainHouseBean> list = mDao.selectAll();
		request.setAttribute("mountainhouse_all", list);
	
	}
	
	private void selectMountainName(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		MountainHouseDAO mDao = new MountainHouseDAO(session);
		String selectmountainname = request.getParameter("selectmountainname");
		System.out.println(selectmountainname);
		List<MountainHouseBean> list = mDao.selectmountainname(selectmountainname);
		request.setAttribute("mountainname", list);
			
	}
	
	public void selectMountainHouseName(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		MountainHouseDAO mDao = new MountainHouseDAO(session);
		
		String selectmountainhousename = request.getParameter("selectmountainhousename");
		List<MountainHouseBean> list = mDao.selectmountainhousename(selectmountainhousename);
		
		request.setAttribute("mounrainhousename", list);
		
	
	}
	
	public void inserMountainHouse(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		MountainHouseService mService = new MountainHouseService(session);
		MountainHouseDAO mDao = new MountainHouseDAO(session);
		MountainHouseBean mBean = new MountainHouseBean();
		
		String mountainname = request.getParameter("insermountainname");
		mBean.setMountainname(mountainname);
		String mountainhousename = request.getParameter("insermountainhousename");
		mBean.setMountainhousename(mountainhousename);
		int mountainhouseseat = Integer.parseInt(request.getParameter("mountainhouseseat"));
		mBean.setMountainhouseseat(mountainhouseseat);
		int campseat = Integer.parseInt(request.getParameter("campseat"));
		mBean.setCampseat(campseat);
		String hight = request.getParameter("hight");
		mBean.setHight(hight);
		
		mService.inserMountainHouse(mBean);

	
	}
	
	public void updateMountainHouse(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		MountainHouseService mService = new MountainHouseService(session);
		MountainHouseDAO mDao = new MountainHouseDAO(session);
		MountainHouseBean mBean = new MountainHouseBean();
		
		int mountainhouseid = Integer.parseInt(request.getParameter("mountainhouseid"));
		mBean.setMountainhouseid(mountainhouseid);
		String mountainname = request.getParameter("updatemountainname");
		mBean.setMountainname(mountainname);
		String mountainhousename = request.getParameter("updatemountainhousename");
		mBean.setMountainhousename(mountainhousename);
		int mountainhouseseat = Integer.parseInt(request.getParameter("updatemountainhouseseat"));
		mBean.setMountainhouseseat(mountainhouseseat);
		int campseat = Integer.parseInt(request.getParameter("updatecampseat"));
		mBean.setCampseat(campseat);
		String hight = request.getParameter("updatehight");
		mBean.setHight(hight);
	
		mDao.updatemountainhouse(mBean);
	}
	
	public void deleteMountainHouse(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		MountainHouseDAO mDao = new MountainHouseDAO(session);
		MountainHouseBean mBean = new MountainHouseBean();
		
		String str = request.getParameter("mountainhouseid");
		int mountainhouseid = Integer.parseInt(str);
		
		mDao.deletemountainhouse(mBean);
		
	
	}
}
