package site.tejap.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER_DETAILS5")
public class UserDetails5 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private int id;

	@Column(name = "USER_NAME")
	private String name;

	@OneToMany
	@JoinTable(name="USER_VEHICLE", joinColumns=@JoinColumn(name="USER_ID"), inverseJoinColumns=@JoinColumn(name="VEHICLE_ID"))
	private Set<Vehicle2> vehicles = new HashSet<>();

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

	public Set<Vehicle2> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Set<Vehicle2> vehicles) {
		this.vehicles = vehicles;
	}


}
