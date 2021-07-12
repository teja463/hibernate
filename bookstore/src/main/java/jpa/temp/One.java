package jpa.temp;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="jpa_one")
public class One {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="user_name")
    private String name;

    @Column(name="user_email")
    private String email;

    @OneToMany(mappedBy = "one", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private Set<Many> addresses = new HashSet<>();

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

    public Set<Many> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Many> addresses) {
        this.addresses = addresses;
    }

    public void addAddress(Many many){
        addresses.add(many);
        many.setOne(this);
    }
}
