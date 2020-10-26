package product.model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "item_info")
public class ItemInfo {
	private int itemBasicSeqno;
	private String type;
	private int price;
	private Blob imgUrl;
	private Blob description;
	private ItemBasic itemBasic;
	
	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name="property", value = "itemBasic"))
	@Id @Column(name = "ITEM_BASIC_SEQNO")
	@GeneratedValue(generator = "generator")
	public int getItemBasicSeqno() {
		return itemBasicSeqno;
	}
	public void setItemBasicSeqno(int itemBasicSeqno) {
		this.itemBasicSeqno = itemBasicSeqno;
	}
	@Column(name = "TYPE")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Column(name = "PRICE")
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Column(name = "IMG_URL")
	public Blob getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(Blob imgUrl) {
		this.imgUrl = imgUrl;
	}
	@Column(name = "DESCRIPTION")
	public Blob getDescription() {
		return description;
	}
	public void setDescription(Blob description) {
		this.description = description;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public ItemBasic getItemBasic() {
		return itemBasic;
	}
	public void setItemBasic(ItemBasic itemBasic) {
		this.itemBasic = itemBasic;
	}
	
	
	
	
}
