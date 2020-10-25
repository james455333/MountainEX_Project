package product.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "first_class")
public class FirstClass {
	
	private int id;
	private String name;
	private Set<SecondClass> secondClasses = new HashSet<SecondClass>();
	
	@Id@Column(name = "ID")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "firstClass")
	public Set<SecondClass> getSecondClasses() {
		return secondClasses;
	}
	public void setSecondClasses(Set<SecondClass> secondClasses) {
		this.secondClasses = secondClasses;
	}
	
	

}
