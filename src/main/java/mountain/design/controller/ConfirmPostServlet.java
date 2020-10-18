package mountain.design.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.login.model.MemberBean;
import mountain.design.model.ActBean;

@WebServlet("/mountain/design/confirmPostServlet")
public class ConfirmPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ConfirmPostServlet() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//從reqeust中抓取Form所提供的值來設定一個位在session名為"postBean"的ActBean
		HttpSession session = request.getSession();
		ActBean actBean = new ActBean();
		
		//1
		actBean.setMemberID(request.getParameter("gInfo_email"));
		//2
		actBean.setNpName(request.getParameter("np_name"));
		String peak_name = null;
		switch (request.getParameter("np_name")) {
		case "玉山國家公園":
			peak_name = "peak_yu_name";
			break;
		case "太魯閣國家公園":
			peak_name = "peak_ta_name";
			break;
		case "雪霸國家公園" :
			peak_name = "peak_sh_name";
			break;
		
		}
		
		
		//3
		actBean.setPeakName(request.getParameter(peak_name));
		//4
		actBean.setActName(request.getParameter("act_name"));
		//5
		String act_pay = request.getParameter("act_pay");
		Integer pay = Integer.valueOf(act_pay);
		actBean.setActPay(pay);
		//6 7
		String seD = request.getParameter("from_end_date");
		String sD = seD.substring(0,10);
		String eD = seD.substring(13);
		actBean.setStartDate(sD);
		actBean.setEndDate(eD);
		//8
		String totalD = request.getParameter("total_day");
		actBean.setTotalDay(totalD);
		//9
		String cofrimD = request.getParameter("confirm_date");
		actBean.setRegEndDate(cofrimD);
		//10
		String regTop = request.getParameter("total_parti");
		Integer regTopNum = Integer.valueOf(regTop);
		actBean.setRegTopNum(regTopNum);
		//11
		if (request.getParameter("act_package")!=null) {
			actBean.setActOther(request.getParameter("act_package"));
		}else {
			actBean.setActOther(null);
		}
		//12
		MemberBean memberBean = (MemberBean)session.getAttribute("LoginOK");
		System.out.println(memberBean);
		actBean.setMemberID(memberBean.getMemberId());
		//13
		actBean.setMemberEXP(request.getParameter("gInfo_exp"));
		//14
		actBean.setMemberName(request.getParameter("gInfo_name"));
		//15
		if(request.getParameter("gInfo_neakName")!=null) {
			actBean.setNeakName(request.getParameter("gInfo_neakName"));
		}else {
			actBean.setNeakName(null);
		}
		actBean.setEmail(memberBean.getEmail());
		
		
		
		
		session.setAttribute("postBean", actBean);
		
		//導向確認網頁
		response.sendRedirect("mountainDesignConfirm.jsp");
		return;
	}

}
