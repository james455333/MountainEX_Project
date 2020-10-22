package member.register.dao;

import org.hibernate.Session;


import member.login.model.MemberBean;

public class MemberDataDAO implements MemberRegisterService {
	
	private Session session;

	public MemberDataDAO(Session session) {
		this.session = session;	
	}

	@Override
	public MemberBean insertData(MemberBean mb) {
		MemberBean result = session.get(MemberBean.class, mb.getMemberId());
		
		if(result == null) {
			session.save(mb);
			return mb;
		}		
		return null;
	}

	

	

	

	

	
}
