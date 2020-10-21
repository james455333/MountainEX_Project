package member.info.dao;

import java.util.List;

import member.login.model.MemberBean;

public interface memberInfoDAO {
	
	public List<MemberBean> listMbInfo();
	
	public void updateData(MemberBean listUpdate);

}
