package javabrains.jpql;

import javax.persistence.*;

@Entity(name = "JPQLUser")
@Table(name = "change_user")
@NamedQuery(name = "UserDetails.byId", query = "select u from JPQLUser u where id = :id")
@NamedNativeQuery(name = "UserDetails.byName", query = "select * from change_user where name = :name", resultClass = UserDetails.class)
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;

    public UserDetails(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserDetails() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
