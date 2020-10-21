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
import javax.servlet.http.HttpSession;

import mountain.design.dao.ActDAO;
import mountain.design.model.ActBean;



@WebFilter(
		dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE
		}
					, 
		urlPatterns = { 
				"/MountainDesignFilter", 
				"/mountain/design/*",
				"/mountain/actList/*"
		})
public class MountainActFilter implements Filter {

    
    public boolean postCheckFilter(Object actBean) {
        if (actBean !=null) {
			return true;
		}else {
			return false;
		}
    }
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Object actBean = session.getAttribute("actBean");
		
		
		if (postCheckFilter(actBean)) {
			chain.doFilter(request, response);
		}else {
			List<ActBean> actBeans = new ArrayList<ActBean>();
			ActDAO mountainDAO = new ActDAO();
			
			try {
				actBeans = mountainDAO.queryPost();
			} catch (SQLException e) {
				session.setAttribute("errorMsg", "發生錯誤" + " : " + e.getMessage());
				e.printStackTrace();
			}
			session.setAttribute("actBean", actBeans);
			chain.doFilter(request, response);
		}
		
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
