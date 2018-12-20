package site.tejap.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="VEHICLE2")
public class Vehicle2 {
	
	@Id
	@GeneratedValue
	private int vehicleId;
	
	private String vehicleName;

	@ManyToOne
	private UserDetails5 user;
	
	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public UserDetails5 getUser() {
		return user;
	}

	public void setUser(UserDetails5 user) {
		this.user = user;
	}
	
}
