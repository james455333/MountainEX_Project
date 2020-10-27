package mountain.mountainList.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import mountain.mountainList.model.MountainBean;
import mountain.mountainList.model.NationalPark;
import mountain.mountainList.model.RouteBasic;
import mountain.mountainList.model.RouteInfo;
import mountain.mountainList.service.NationalParkHibernateService;
import mountain.mountainList.service.RouteBasicHibernateService;
import mountain.mountainList.service.RouteInfoHibernateService;
import mountain.mountainList.service.impl.NationalParkService;
import mountain.mountainList.service.impl.RouteBasicService;
import mountain.mountainList.service.impl.RouteInfoService;
import util.HibernateUtil;

@WebServlet("/mountain/back/RouteDataServlet")
public class RouteDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		// Hibernate : Sessionfactory and Session
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		HttpSession httpSession = request.getSession();
		// 重置SessionScopeAttribute : errorMsg & mainBean
		httpSession.removeAttribute("errorMsg");
		httpSession.removeAttribute("mainBean");
		httpSession.removeAttribute("result");

		// 導覽列顯示用JavaBean
		NationalParkService npService = new NationalParkHibernateService(session);
		List<NationalPark> npBeans = npService.selectAll();
		RouteInfoService routeInfoService = new RouteInfoHibernateService(session);
		List<MountainBean> mountainBeans = null;
		try {
			mountainBeans = transRouteInfos(session, routeInfoService.selectAll());
		} catch (IOException | SQLException e1) {
			// 發生錯誤，request儲存進錯誤訊息
			String message = e1.getMessage();
			request.setAttribute("errorMsg", message);
			e1.printStackTrace();
		}
		;
		if (request.getAttribute("errorMsg") == null) {
			httpSession.setAttribute("mountainBean", mountainBeans);
			httpSession.setAttribute("npBean", npBeans);
		}
		// 主畫面顯示用JavaBeanList
		List<MountainBean> mainBeans = null;

		// 提取前端下達命令
		String order = request.getParameter("mOrder");
		if (order != null) {
			// 判斷前端命令
			if (order.equals("selectAll")) {
				// 轉換查詢結果為前端顯示的JavaBean
				try {
					mainBeans = transRouteInfos(session, routeInfoService.selectAll());
				} catch (IOException | SQLException e) {
					// 發生錯誤，request儲存進錯誤訊息
					String message = e.getMessage();
					httpSession.setAttribute("errorMsg", message);
				}
				// 若沒有發生錯誤，將結果儲存進session
				if (request.getAttribute("errorMsg") == null) {
					httpSession.setAttribute("mainBean", mainBeans);
				}

			} else if (order.equals("國家公園查詢")) {
				// 提出查詢目標ID
				String np = request.getParameter("nationalPark");
				int npID = Integer.parseInt(np);

				// 執行查詢並得到結果
				RouteBasicService rtBasicService = new RouteBasicHibernateService(session);
				List<RouteBasic> selectAllWithNPID = rtBasicService.selectAllWithNPID(npID);

				// 轉換結果為前端顯示的JavaBean
				try {
					mainBeans = transRouteBasic(session, selectAllWithNPID);
				} catch (IOException | SQLException e) {
					// 發生錯誤，request儲存進錯誤訊息
					String message = e.getMessage();
					httpSession.setAttribute("errorMsg", message);
				}
				// 若沒有發生錯誤，將結果儲存進session
				if (request.getAttribute("errorMsg") == null) {
					httpSession.setAttribute("mainBean", mainBeans);
				}
			} else if (order.equals("特定路線查詢")) {
				// 提出查詢目標ID
				String route = request.getParameter("route");
				int routeID = Integer.parseInt(route);
				// 轉換查詢結果為前端顯示的JavaBean
				try {
					mainBeans = transRouteInfo(session, routeInfoService.select(routeID));
				} catch (IOException | SQLException e) {
					// 發生錯誤，request儲存進錯誤訊息
					String message = e.getMessage();
					httpSession.setAttribute("errorMsg", message);
				}
				// 若沒有發生錯誤，將結果儲存進session
				if (request.getAttribute("errorMsg") == null) {
					httpSession.setAttribute("mainBean", mainBeans);
				}

			} else if (order.equals("確認新增")) {
				// 將Request送來的新增資訊設定進物件
				NationalPark nationalPark = new NationalPark();
				nationalPark.setName(request.getParameter("npName"));

				RouteInfo routeInfo = new RouteInfo();
				routeInfo.setName(request.getParameter("routeName"));

				// 圖片下載 尚未實作
				String test = "#";
				byte[] bytes = test.getBytes("UTF-8");
				Blob imgBlob = Hibernate.getLobCreator(session).createBlob(bytes);
//				try {
//					imgBlob = imgPathToBlob(session, request.getParameter("routeImg"));
//					;
//				} catch (IOException | SQLException e) {
//					String message = e.getMessage();
//					httpSession.setAttribute("errorMsg",message);
//					e.printStackTrace();
//				}
				routeInfo.setImgUrl(imgBlob);

				byte[] routeDespBytes = request.getParameter("routeDesp").getBytes("UTF-8");
				Blob routeDespBlob = Hibernate.getLobCreator(session).createBlob(routeDespBytes);
				routeInfo.setDescription(routeDespBlob);

				byte[] routeAdviceBytes = request.getParameter("routeAdvice").getBytes("UTF-8");
				Blob routeAdviceBlob = Hibernate.getLobCreator(session).createBlob(routeAdviceBytes);
				routeInfo.setAdvice(routeAdviceBlob);

				byte[] routeTraBytes = request.getParameter("routeTraffic").getBytes("UTF-8");
				Blob routeTraBlob = Hibernate.getLobCreator(session).createBlob(routeTraBytes);
				routeInfo.setTraffic(routeTraBlob);

				RouteBasic routeBasic = new RouteBasic();
				routeBasic.setRouteInfo(routeInfo);
				routeBasic.setNational_park(nationalPark);

				routeInfo.setRoute_basic(routeBasic);

				Set<RouteBasic> routeBasicSet = new HashSet<RouteBasic>();
				routeBasicSet.add(routeBasic);
				nationalPark.setRouteBasic(routeBasicSet);
				NationalPark check = npService.select(nationalPark.getName());
				if (check != null) {
					RouteBasicService rBService = new RouteBasicHibernateService(session);
					routeBasic.setNational_park(check);
					RouteBasic returnBean = rBService.insert(routeBasic);
					if (returnBean != null) {
						httpSession.setAttribute("result", "新增成功");
					} else {
						httpSession.setAttribute("result", "新增失敗");
					}
				} else {
					NationalPark returnBean = npService.insert(nationalPark);
					if (returnBean != null) {
						httpSession.setAttribute("result", "新增成功");
					} else {
						httpSession.setAttribute("result", "新增失敗");
					}
				}
				// 轉換查詢結果為前端顯示的JavaBean
				try {
					mainBeans = transRouteInfos(session, routeInfoService.selectAll());
				} catch (IOException | SQLException e) {
					// 發生錯誤，request儲存進錯誤訊息
					String message = e.getMessage();
					httpSession.setAttribute("errorMsg", message);
				}
				// 若沒有發生錯誤，將結果儲存進session
				if (request.getAttribute("errorMsg") == null) {
					httpSession.setAttribute("mainBean", mainBeans);
				}

			} else if (order.equals("刪除")) {
				// 得到要刪除的ID
				String deleteID = request.getParameter("searchInsert");
				if (deleteID.matches("[0-9]{4}")) {
					int deleteIDNum = Integer.parseInt(deleteID);
					RouteBasicService rBService = new RouteBasicHibernateService(session);
					boolean result = rBService.delete(deleteIDNum);
					if (result) {
						httpSession.setAttribute("result", "刪除成功");
					} else {
						httpSession.setAttribute("result", "刪除失敗，並無該筆資料");
					}

				} else {
					httpSession.setAttribute("result", "輸入格式錯誤，請重新輸入");
				}

				try {
					mainBeans = transRouteInfos(session, routeInfoService.selectAll());
				} catch (IOException | SQLException e) {
					// 發生錯誤，request儲存進錯誤訊息
					String message = e.getMessage();
					httpSession.setAttribute("errorMsg", message);
				}
				// 若沒有發生錯誤，將結果儲存進session
				if (request.getAttribute("errorMsg") == null) {
					httpSession.setAttribute("mainBean", mainBeans);
				}

			} else if (order.equals("修改")) {
				// 得到要刪除的ID
				String updateID = request.getParameter("searchInsert");
				if (updateID.matches("[0-9]{4}")) {
					int updateIDNum = Integer.parseInt(updateID);
					RouteInfo select = routeInfoService.select(updateIDNum);
					if (select != null) {
						try {
							mainBeans = transRouteInfo(session, select);
							System.out.println(mountainBeans.get(0).getName());
						} catch (IOException | SQLException e) {
							e.printStackTrace();
						}
						httpSession.setAttribute("mainBeanRTID", String.valueOf(updateIDNum));
						httpSession.setAttribute("mainBean", mainBeans);
						response.sendRedirect(request.getContextPath() + "/mountain/back/backMountainUpdate.jsp");
						return;
					} else {
						httpSession.setAttribute("result", "輸入錯誤，並無該筆資料");
					}
				} else {
					httpSession.setAttribute("result", "輸入格式錯誤，請重新輸入");

				}
				try {
					mainBeans = transRouteInfos(session, routeInfoService.selectAll());
				} catch (IOException | SQLException e) {
					// 發生錯誤，request儲存進錯誤訊息
					String message = e.getMessage();
					httpSession.setAttribute("errorMsg", message);
				}
				// 若沒有發生錯誤，將結果儲存進session
				if (request.getAttribute("errorMsg") == null) {
					
					
					httpSession.setAttribute("mainBean", mainBeans);
				}

			}else if (order.equals("確認修改")) {
				
				// 將Request送來的新增資訊設定進物件
				NationalPark nationalPark = new NationalPark();
				nationalPark.setName(request.getParameter("npName"));
				
				RouteInfo routeInfo = new RouteInfo();
				routeInfo.setName(request.getParameter("routeName"));
				// 圖片下載 尚未實作
				
				byte[] routeDespBytes = request.getParameter("routeDesp").getBytes("UTF-8");
				Blob routeDespBlob = Hibernate.getLobCreator(session).createBlob(routeDespBytes);
				routeInfo.setDescription(routeDespBlob);
				
				byte[] routeAdviceBytes = request.getParameter("routeAdvice").getBytes("UTF-8");
				Blob routeAdviceBlob = Hibernate.getLobCreator(session).createBlob(routeAdviceBytes);
				routeInfo.setAdvice(routeAdviceBlob);
				
				byte[] routeTraBytes = request.getParameter("routeTraffic").getBytes("UTF-8");
				Blob routeTraBlob = Hibernate.getLobCreator(session).createBlob(routeTraBytes);
				routeInfo.setTraffic(routeTraBlob);
				
				RouteBasic routeBasic = new RouteBasic();
				routeBasic.setRouteInfo(routeInfo);
				routeBasic.setNational_park(nationalPark);
				
				routeInfo.setRoute_basic(routeBasic);
				
				Set<RouteBasic> routeBasicSet = new HashSet<RouteBasic>();
				routeBasicSet.add(routeBasic);
				nationalPark.setRouteBasic(routeBasicSet);
				RouteBasicService rBService = new RouteBasicHibernateService(session);
				RouteInfo returnRIBeaN = routeInfoService.update(routeInfo);
				System.out.println("routeInfo : " + returnRIBeaN);
				RouteBasic returnRBBean = rBService.update(routeBasic);
				System.out.println("returnRBBean : " + returnRBBean);
				NationalPark returnNPBean = npService.update(nationalPark);
				System.out.println("returnNPBean : " + returnNPBean);
				if (returnRBBean != null && returnRIBeaN != null && returnNPBean != null) {
					httpSession.setAttribute("result", "新增成功");
				} else {
					httpSession.setAttribute("result", "修改失敗");
				}
				
				// 轉換查詢結果為前端顯示的JavaBean
				try {
					mainBeans = transRouteInfos(session, routeInfoService.selectAll());
				} catch (IOException | SQLException e) {
					// 發生錯誤，request儲存進錯誤訊息
					String message = e.getMessage();
					httpSession.setAttribute("errorMsg", message);
				}
				// 若沒有發生錯誤，將結果儲存進session
				if (request.getAttribute("errorMsg") == null) {
					httpSession.setAttribute("mainBean", mainBeans);
				}
			} 

		}
	

	// 前往backMountain.jsp
//		request.getRequestDispatcher("backMountain.jsp").forward(request, response);
	response.sendRedirect(request.getContextPath()+"/mountain/back/backMountain.jsp");return;

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private static String blobToString(Blob blob) throws IOException, SQLException {
		if (blob == null) {
			return "尚未有資料";
		}
		StringBuffer result = new StringBuffer();
		try (InputStream is = blob.getBinaryStream(); InputStreamReader isr = new InputStreamReader(is, "UTF-8");) {
			char[] chars = new char[1024];
			int buffer;
			while ((buffer = isr.read(chars)) != -1) {
				result.append(chars, 0, buffer);
			}
			return result.toString();
		}
	}

	private static Blob imgPathToBlob(Session session, String path) throws IOException, SQLException {
		String goalLoacation = "C:\\DataSource\\workspace\\MountainEX_Project\\src\\main\\webapp\\mountain\\images/";

		// 找出資料庫所有圖片路徑名稱;
		RouteInfoHibernateService routeInfoService = new RouteInfoHibernateService(session);
		List<RouteInfo> routeInfoList = routeInfoService.selectAll();
		// 取得下一個路徑名稱
		int max = 0;
		for (RouteInfo routeInfo : routeInfoList) {
			Blob imgUrl = routeInfo.getImgUrl();
			String pathName = blobToString(imgUrl);
			String routeMap = pathName.substring(pathName.lastIndexOf("RouteMap"), pathName.length());
			int routeNum = Integer.parseInt(routeMap.replaceAll("[\\D]", ""));
			if (routeNum > max) {
				max = routeNum;
			}
		}
		String newImgPath = goalLoacation.concat("RouteMap" + String.valueOf(max));

		// 下載圖片
		try (FileInputStream fis = new FileInputStream(path);
				FileOutputStream fos = new FileOutputStream(newImgPath);) {
			byte[] bytes = new byte[1024];
			int buffer;

			while ((buffer = fis.read(bytes, 0, 1024)) != -1) {
				fos.write(bytes, 0, buffer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 路徑名稱轉存為blob
		byte[] newImgBytes = newImgPath.getBytes("UTF-8");
		Blob newImgBlob = Hibernate.getLobCreator(session).createBlob(newImgBytes);

		return newImgBlob;
	}

	private ArrayList<MountainBean> transRouteInfo(Session session, RouteInfo routeInfo)
			throws IOException, SQLException {
		ArrayList<MountainBean> showList = new ArrayList<MountainBean>();

		MountainBean mountainBean = new MountainBean();
		mountainBean.setSeqno(routeInfo.getRbPK());
		mountainBean.setName(routeInfo.getName());

		Blob descpBlob = routeInfo.getDescription();
		String description = blobToString(descpBlob);
		mountainBean.setDescription(description);

		Blob adviceBlob = routeInfo.getAdvice();
		String advice = blobToString(adviceBlob);
		mountainBean.setAdvice(advice);

		Blob traBlob = routeInfo.getTraffic();
		String traffic = blobToString(traBlob);
		mountainBean.setTraffic(traffic);

		Blob imgUrlBlob = routeInfo.getImgUrl();
		String imgURL = blobToString(imgUrlBlob);
		if (imgURL.equals("#")) {
			mountainBean.setImgUrl(imgURL);
		} else {
			imgURL = imgURL.substring(imgURL.lastIndexOf("/"), imgURL.length());
			mountainBean.setImgUrl(imgURL);
		}

		RouteBasic routeBasic = routeInfo.getRoute_basic();
		NationalPark nationalPark = routeBasic.getNational_park();
		String nPName = nationalPark.getName();
		mountainBean.setNpName(nPName);

		showList.add(mountainBean);

		return showList;
	}

	private static ArrayList<MountainBean> transRouteInfos(Session session, List<RouteInfo> rIBean)
			throws IOException, SQLException {
		ArrayList<MountainBean> showList = new ArrayList<MountainBean>();

		for (RouteInfo routeInfo : rIBean) {
			MountainBean mountainBean = new MountainBean();
			mountainBean.setSeqno(routeInfo.getRbPK());
			mountainBean.setName(routeInfo.getName());

			Blob descpBlob = routeInfo.getDescription();
			String description = blobToString(descpBlob);
			mountainBean.setDescription(description);

			Blob adviceBlob = routeInfo.getAdvice();
			String advice = blobToString(adviceBlob);
			mountainBean.setAdvice(advice);

			Blob traBlob = routeInfo.getTraffic();
			String traffic = blobToString(traBlob);
			mountainBean.setTraffic(traffic);

			Blob imgUrlBlob = routeInfo.getImgUrl();
			String imgURL = blobToString(imgUrlBlob);
			if (imgURL.equals("#")) {
				mountainBean.setImgUrl(imgURL);
			} else {
				imgURL = imgURL.substring(imgURL.lastIndexOf("/"), imgURL.length());
				mountainBean.setImgUrl(imgURL);
			}

			RouteBasic routeBasic = routeInfo.getRoute_basic();
			NationalPark nationalPark = routeBasic.getNational_park();
			String nPName = nationalPark.getName();
			mountainBean.setNpName(nPName);

			showList.add(mountainBean);
		}
		return showList;
	}

	private static ArrayList<MountainBean> transRouteBasic(Session session, List<RouteBasic> selectAllWithNPID)
			throws IOException, SQLException {

		ArrayList<MountainBean> showList = new ArrayList<MountainBean>();
		List<RouteInfo> rIBeans = new ArrayList<RouteInfo>();
		for (RouteBasic routeBasic : selectAllWithNPID) {
			rIBeans.add(routeBasic.getRouteInfo());
		}
		for (RouteInfo routeInfo : rIBeans) {
			MountainBean mountainBean = new MountainBean();
			mountainBean.setSeqno(routeInfo.getRbPK());
			mountainBean.setName(routeInfo.getName());

			Blob descpBlob = routeInfo.getDescription();
			String description = blobToString(descpBlob);
			mountainBean.setDescription(description);

			Blob adviceBlob = routeInfo.getAdvice();
			String advice = blobToString(adviceBlob);
			mountainBean.setAdvice(advice);

			Blob traBlob = routeInfo.getTraffic();
			String traffic = blobToString(traBlob);
			mountainBean.setTraffic(traffic);

			Blob imgUrlBlob = routeInfo.getImgUrl();
			String imgURL = blobToString(imgUrlBlob);
			if (imgURL.equals("#")) {
				mountainBean.setImgUrl(imgURL);
			} else {
				imgURL = imgURL.substring(imgURL.lastIndexOf("/"), imgURL.length());
				mountainBean.setImgUrl(imgURL);
			}

			RouteBasic routeBasic = routeInfo.getRoute_basic();
			NationalPark nationalPark = routeBasic.getNational_park();
			String nPName = nationalPark.getName();
			mountainBean.setNpName(nPName);

			showList.add(mountainBean);
		}
		return showList;

	}

}
