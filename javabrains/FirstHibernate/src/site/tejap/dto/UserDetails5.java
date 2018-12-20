package site.tejap.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER_DETAILS5")
public class UserDetails5 {

	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private int id;

	@Column(name = "USER_NAME")
	private String name;

	@OneToMany(mappedBy="user")
	private Collection<Vehicle2> vehicles = new ArrayList<>();

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

	public Collection<Vehicle2> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Collection<Vehicle2> vehicles) {
		this.vehicles = vehicles;
	}


}
