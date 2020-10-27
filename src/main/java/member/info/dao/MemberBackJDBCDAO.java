package member.info.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.query.Query;

import member.login.model.MemberBean;

public class MemberBackJDBCDAO implements MemberBackDAO {
	
	private Session session;
	
	public MemberBackJDBCDAO(Session session) {
		this.session = session;
	}

	@Override
	public List<MemberBean> selectAll() {
		Query<MemberBean> query = session.createQuery("From MemberBean", MemberBean.class);
		List<MemberBean> list = query.list();
		
		return list;
	}

	@Override
	public List<MemberBean> selectOne(String userId) {
		Query<MemberBean> query = session.createQuery("From MemberBean where account =?0", MemberBean.class);
		query.setParameter(0, userId);
		
		List<MemberBean> list = query.list();
		
		return list;
	}

	@Override
	public MemberBean updateData(int memberId, MemberBean mb) {
//		Query<MemberBean> query = session.createQuery("From MemberBean where memberId = ?0", MemberBean.class);
		
		MemberBean result = session.get(MemberBean.class, memberId);
		
		if(result != null) {
		
			result.setAccount(mb.getAccount());
			result.setName(mb.getName());
			result.setAddress(mb.getAddress());
			result.setEmail(mb.getEmail());
			result.setTel(mb.getTel());
			result.setExp(mb.getExp());
			result.setGroupId(mb.getGroupId());
			result.setTotalAmt(mb.getTotalAmt());
			result.setUnpaid_amount(mb.getUnpaid_amount());
//			result.setMemberImage(mb.getMemberImage());
		}
		
		return result;
	}

	

	

	

}
