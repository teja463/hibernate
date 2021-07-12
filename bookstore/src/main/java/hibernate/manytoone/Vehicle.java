package hibernate.manytoone;

import javax.persistence.*;

@Entity
@Table(name="vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="vehicle_id")
    private Integer id;

    @Column(name="vehicle_name")
    private String name;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name="user_id")
    private User user;

    public Vehicle() {

    }

    public Vehicle(String name, User user) {
        this.name = name;
        this.user = user;
    }
}
