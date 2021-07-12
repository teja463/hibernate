package hibernate.elementcollection;

import javax.persistence.*;

@Entity
@Table(name="friend")
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name",nullable = false,length = 45)
    private String name;

    @Column(name = "email", nullable = false, length = 100,unique = true)
    private String email;


}
