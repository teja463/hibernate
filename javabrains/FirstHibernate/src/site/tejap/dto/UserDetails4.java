package site.tejap.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="USER_DETAILS4")
public class UserDetails4 {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private int id;
	
	@Column(name="USER_NAME")
	private String name;
	
	@OneToOne
	@JoinColumn(name="VEHICLE_ID")
	private Vehicle vehicle;

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

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	
}
