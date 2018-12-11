package site.tejap.dto;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity(name="USER_DETAILS")
public class UserDetails {

	@Id
	@Column(name="USER_ID")
	@GeneratedValue
	private int userId; // @Id acts as primary key
	
	@Column(name="USER_NAME")
	private String userName; // Changes to column name from userName to USER_NAME in DB
	
	@Lob
	private String description; // To make it a CLOB or BLOG 
	
	@Transient
	private String gender; // TO ignore this field from saving it in DB. This field will not be included in the HBM to DDL mapping queries also
	
	@Temporal(TemporalType.DATE) 
	private Date dob; // To make the DB column type to Date instead of date and time
	
	@Embedded
	private Address homeAddress; // We can embed another object and these properties in this class will be columns in the same entity class
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="city", column = @Column(name="OFFICE_CITY")),
		@AttributeOverride(name="state", column = @Column(name="OFFICE_STATE"))
	})
	private Address officeAddress; // When you want to use the same Embedded object with different column names you can use AttributeOverrides
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Column(name="USER_NAME")
	public String getUserName() {
		return userName +" from getter";
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	
	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName + ", description=" + description + ", gender="
				+ gender + ", dob=" + dob + "]";
	}
	
}
