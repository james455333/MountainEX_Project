package product.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "item_basic")
public class ItemBasic {
	
	private int seqno;
	private String name;
	private int stock;
	private int secondClassId;
	private int firstClassId;
	private FirstClass firstClass;
	private SecondClass secondClass;
	
	private ItemInfo itemInfo;
	
	@Id @Column(name = "SEQNO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getSeqno() {
		return seqno;
	}
	public void setSeqno(int seqno) {
		this.seqno = seqno;
	}
	@Column(name = "NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "STOCK")
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Transient
	public int getSecondClassId() {
		return secondClassId;
	}
	public void setSecondClassId(int secondClassId) {
		this.secondClassId = secondClassId;
	}
	@Transient
	public int getFirstClassId() {
		return firstClassId;
	}
	public void setFirstClassId(int firstClassId) {
		this.firstClassId = firstClassId;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SECOND_CLASS_ID" ,referencedColumnName = "ID")
	public SecondClass getSecondClass() {
		return secondClass;
	}
	public void setSecondClass(SecondClass secondClass) {
		this.secondClass = secondClass;
	}
	
	@OneToOne(fetch = FetchType.LAZY,mappedBy = "itemBasic", cascade = CascadeType.ALL)
	public ItemInfo getItemInfo() {
		return itemInfo;
	}
	public void setItemInfo(ItemInfo itemInfo) {
		this.itemInfo = itemInfo;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FIRST_CLASS_ID" ,referencedColumnName = "ID")
	public FirstClass getFirstClass() {
		return firstClass;
	}
	public void setFirstClass(FirstClass firstClass) {
		this.firstClass = firstClass;
	}

}
