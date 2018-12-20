package site.tejap.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE")
public class Employee {

	@Id
	@Column(name="EMP_ID")
	@GeneratedValue
	private int id;
	
	@Column(name="EMP_NAME")
	private String name;
	
	@OneToMany(mappedBy="employee")
//	@JoinTable(joinColumns=@JoinColumn(name="EMP_ID"), inverseJoinColumns=@JoinColumn(name="OFFER_ID"))
	private Collection<Offer> offers = new ArrayList<>();;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Collection<Offer> getOffers() {
		return offers;
	}


	public void setOffers(Collection<Offer> offers) {
		this.offers = offers;
	}


	
}
