package product.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class ItemBasicDAO {

	private Session session;

	public ItemBasicDAO(Session session) {
		this.session =session;
	}

	//新增
	public ItemBasic insert(ItemBasic bean) {
		
		ItemBasic result = session.get(ItemBasic.class, bean.getName());
		
		if (result==null) {
			session.save(bean);
			return bean;
		}
		return null;
	}
	//查詢
	public ItemBasic select(String name) {
		return session.get(ItemBasic.class, name);
	}
	//
	public ItemBasic select(int id) {
		return session.get(ItemBasic.class, id);
	}
	//
	public List<ItemBasic> selectAll(){
		Query<ItemBasic> query = session.createQuery("From ItemBasic", ItemBasic.class);
		List<ItemBasic> list = query.list();
		return list;
	}
	//修改(商品名、庫存量)
	public ItemBasic update(int stock) {
		ItemBasic result = session.get(ItemBasic.class, stock);
		if (result!=null) {
			result.setStock(stock);
		}
		return result;
	}
	//刪除
	public boolean delete(String name) {
		ItemBasic result = session.get(ItemBasic.class, name);
		if (result!= null) {
			session.delete(result);
			return true;
		}
		return false;
	}
}
