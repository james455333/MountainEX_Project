package member.register.dao;


import org.hibernate.Session;
import org.hibernate.query.Query;

import member.login.model.MemberBean;

public class memberJDBCDAO implements memberDAO{
	
	private Session session;
	
	public memberJDBCDAO(Session session) {
		this.session = session;
	}

	
	@Override
	public MemberBean insert(MemberBean mb) {
		MemberBean result = session.get(MemberBean.class, mb.getMemberId());
		if(result == null) {
			session.save(mb);
			return mb;
		}
		return null;
	}


	//檢查登入密碼
	@Override
	public MemberBean checkIdPassword(String userId, String password) {
		Query<MemberBean> query = session.createQuery("From MemberBean where account = ?0 and password = ?1", MemberBean.class);
		query.setParameter(0, userId);
		query.setParameter(1, password);
		
		MemberBean qBean = query.uniqueResult();
		
		if(qBean != null) {
			return qBean;
		}
		return null;
	}


	
	
	
	
	
	
		
		
//		MemberBean mb = null;
//		try (
//			Connection connection = ds.getConnection();
//			PreparedStatement pstmt = connection.prepareStatement("select * from member where memberId = ? and password = ?")
//		){
//			
//			pstmt.setString(1, userId);
//			pstmt.setString(2, password);
//			
//			try(ResultSet rs = pstmt.executeQuery();){
//				if(rs.next()) {
//					mb = new MemberBean();
//					mb.setMemberId(rs.getString("memberId"));
//					mb.setPassword(rs.getString("password"));
//					mb.setName(rs.getString("name"));
//					mb.setAddress(rs.getString("address"));
//					mb.setEmail(rs.getString("email"));
//					mb.setTel(rs.getString("tel"));
//					mb.setExp(rs.getString("exp"));
//					mb.setGroupId(rs.getInt("groupId"));
//					mb.setTotalAmt(rs.getDouble("totalamt"));
//					mb.setUnpaid_amount(rs.getDouble("unpaid_amount"));
//					mb.setMemberImage(rs.getBlob("memberImage"));
//				}
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new RuntimeException("memberJDBCDAO類別 #checkIdPassword()發生SQL例外：" + e.getMessage());
//		}
//		return mb;
	



	
	
	
	
	

	
	


}
