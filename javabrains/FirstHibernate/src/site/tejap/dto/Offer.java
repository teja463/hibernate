package site.tejap.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="OFFER")
public class Offer {

	@Id
	@GeneratedValue
	@Column(name="OFFER_ID")
	private int id;
	
	@Column(name="OFFER_COMPANY")
	private String company;

	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Employee employee;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	
	
}
