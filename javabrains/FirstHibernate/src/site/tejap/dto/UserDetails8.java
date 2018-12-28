package site.tejap.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="UserDetails.byId",query="from UserDetails8 where id = :id and name = :name")
@NamedNativeQuery(name="UserDetila.byName",query="SELECT * FROM UserDetails8 WHERE name= :name",resultClass=UserDetails8.class)
public class UserDetails8 {

	@Id
	@GeneratedValue
	private int id;
	
	private String name;

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

	
}
