package member.register.dao;

import member.login.model.MemberBean;

public interface memberDAO {
	
	public void insertData(MemberBean mb);

	public MemberBean checkIdPassword(String userId, String password);

}
