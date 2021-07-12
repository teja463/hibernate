package hibernate.embed;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Embedded
    private Address address;

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }
}
