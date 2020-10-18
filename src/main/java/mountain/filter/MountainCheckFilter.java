package mountain.filter;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mountain.mountainList.dao.MountainDAO;
import mountain.mountainList.model.MountainBean;

/**
 * Servlet Filter implementation class MountainCheckFilter
 */
@WebFilter(
		dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE
		}
					, 
		urlPatterns = { 
				"/MountainCheckFilter", 
				"/mountain/*"
		})
public class MountainCheckFilter implements Filter {

    
    public boolean mountainCheckFilter(Object mountainBean) {
        if (mountainBean !=null) {
			return true;
		}else {
			return false;
		}
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Object mountainBean = session.getAttribute("mountainBean");
		
		
		
		if (mountainCheckFilter(mountainBean)) {
			chain.doFilter(request, response);
		}else {
			List<MountainBean> mBeanList = new ArrayList<MountainBean>(); 
			MountainDAO mountainDAO = new MountainDAO();
			
			try {
				mBeanList= mountainDAO.routeSummary();
				
				
				
			} catch (SQLException e) {
				session.setAttribute("errorMsg", "出現錯誤 : \n"+e.getErrorCode()+":"+e.getMessage()+"\n請聯絡管理員");
				resp.sendRedirect(req.getContextPath()+"/index.jsp");
				return;
			}
			session.setAttribute("mountainBean", mBeanList);
			chain.doFilter(request, response);
			
		}
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
