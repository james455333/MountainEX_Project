package member.info.dao;

import java.util.List;

import member.login.model.MemberBean;

public interface MemberBackDAO {
	
	public List<MemberBean> selectAll();
	
	public List<MemberBean> selectOne(String userId);
	
	public MemberBean updateData(int memberId, MemberBean mb);

}
