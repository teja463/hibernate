package hibernate.onetoone;

import javax.persistence.*;

@Entity
@Table(name = "wife")
public class Wife {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wife_id")
    private Integer id;

    @Column(name="name")
    private String name;

    public Wife(){}

    public Wife(String name) {
        this.name = name;
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
