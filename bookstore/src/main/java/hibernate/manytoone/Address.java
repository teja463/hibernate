package hibernate.manytoone;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="address_val")
    private String addressVal;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;

    public Address() {

    }

    public Address(String addressVal, User user){
        this.addressVal = addressVal;
        this.user = user;
    }
}
