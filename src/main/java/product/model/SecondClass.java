package product.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "second_class")
public class SecondClass {

	private int id;
	private String name;
	private String firstClassId;
	private FirstClass firstClass;
	private Set<ItemBasic> itemBasics =new HashSet<ItemBasic>();
	
	@Id@Column(name = "id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Transient
	public String getFirstClassId() {
		return firstClassId;
	}
	public void setFirstClassId(String firstClassId) {
		this.firstClassId = firstClassId;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FIRST_CLASS_ID" ,referencedColumnName = "ID")
	public FirstClass getFirstClass() {
		return firstClass;
	}
	public void setFirstClass(FirstClass firstClass) {
		this.firstClass = firstClass;
	}
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "secondClass")
	public Set<ItemBasic> getItemBasics() {
		return itemBasics;
	}
	public void setItemBasics(Set<ItemBasic> itemBasics) {
		this.itemBasics = itemBasics;
	}
	
	
	
	
	
	
}
