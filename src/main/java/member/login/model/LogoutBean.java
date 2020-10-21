package member.login.model;

import javax.servlet.http.HttpSession;

//登出要做的事都寫在這裡
public class LogoutBean {
	
	HttpSession session;
	
	public HttpSession geSession() {
		return session;
	}
	
	public void setSession(HttpSession session) {
		this.session = session;
	}
	
	public Integer getLogout() {
		//logout
		session.invalidate();
		return 0;
	}

}
