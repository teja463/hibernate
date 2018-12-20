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
@Table(name="VEHICLE3")
public class Vehicle3 {

	@Id
	@GeneratedValue
	@Column(name="VEHICLE_ID")
	private int id;
	
	@Column(name="VEHICLE_NAME")
	private String name;
	
	@ManyToMany
	private Collection<UserDetails6> users = new ArrayList<>();

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

	public Collection<UserDetails6> getUsers() {
		return users;
	}

	public void setUsers(Collection<UserDetails6> users) {
		this.users = users;
	}
	
	
	
	
}
