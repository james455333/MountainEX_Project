package product.old;

import java.util.List;

public interface IProductService {
	
		//查詢所有	
		public List<ProductBean> getProducts();
	
		// 依name來刪除單筆記錄
		int deleteProduct(String name);
		
		// 依name來查詢單筆記錄
//		ProductBean getProduct(String name);

		// 新增一筆記錄
		int saveProduct(ProductBean bean);

		// 修改一筆資料
		public int updateProduct(ProductBean bean);

		// 取出所有的類型
		
		public List<ClassBean> getClassList();
		
}
