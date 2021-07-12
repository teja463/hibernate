package javabrains.entitycollection;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class UserDetails {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    @ElementCollection
    private Set<Address> addresses = new HashSet<>();

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
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
}
