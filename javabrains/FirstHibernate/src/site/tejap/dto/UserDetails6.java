package site.tejap.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="USER_DETAILS6")
public class UserDetails6 {

	@Id
	@GeneratedValue
	@Column(name="USER_ID")
	private int id;
	
	@Column(name="USER_NAME")
	private String name;
	
	@ManyToMany(mappedBy="users")
	private Collection<Vehicle3> vehicles = new ArrayList<>();

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

	public Collection<Vehicle3> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Collection<Vehicle3> vehicles) {
		this.vehicles = vehicles;
	}
	
	
}
