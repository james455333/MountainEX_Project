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

}
