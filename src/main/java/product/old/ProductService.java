package product.old;

import java.util.List;

import product.dao.impl.ProductDao_Jdbc;


public class ProductService implements IProductService {
    
    ProductDao_Jdbc dao;
    
	public ProductService() {
		this.dao = new ProductDao_Jdbc();
	}

	@Override
	public List<ProductBean> getProducts() {
		// TODO Auto-generated method stub
		return dao.getProducts();
	}

	@Override
	public List<ClassBean> getClassList() {
		// TODO Auto-generated method stub
		return dao.getClassList();
	}

	@Override
	public int deleteProduct(String name) {
		return dao.deleteProduct(name);
	}

	@Override
	public int saveProduct(ProductBean bean) {
		// TODO Auto-generated method stub
		return dao.saveProduct(bean);
	}

	@Override
	public int updateProduct(ProductBean bean) {
		// TODO Auto-generated method stub
		return dao.updateProduct(bean);
	}

}