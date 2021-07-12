package hibernate.manytoone;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    public User(){}

    public User(String name){
        this.name = name;
    }
}
