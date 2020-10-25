package product.model;

import java.sql.Blob;

public class ProductBean {
	private String  	name;
	private String  	type;
	private Integer  	price;
	private String    	imgUrl;	
	private String    	description;	
	private String  	secondClass;
	private Integer  	stock;
	private Integer  	firstClassid;
	private String  	firstClassname;
	
	
	
	public ProductBean(String name, String type, Integer price, String imgUrl, String description, String secondClass,
			Integer stock, Integer firstClassid, String firstClassname) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.imgUrl = imgUrl;
		this.description = description;
		this.secondClass = secondClass;
		this.stock = stock;
		this.firstClassid = firstClassid;
		this.firstClassname = firstClassname;
	}
	
	public ProductBean() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String blob) {
		this.description = blob;
	}
	public String getSecondClass() {
		return secondClass;
	}
	public void setSecondClass(String secondClass) {
		this.secondClass = secondClass;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Integer getFirstClassid() {
		return firstClassid;
	}
	public void setFirstClassid(Integer firstClassid) {
		this.firstClassid = firstClassid;
	}
	public String getFirstClassname() {
		return firstClassname;
	}
	public void setFirstClassname(String firstClassname) {
		this.firstClassname = firstClassname;
	}

}
