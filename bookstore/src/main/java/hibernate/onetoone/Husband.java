package hibernate.onetoone;

import javax.persistence.*;

@Entity
@Table(name = "husband")
public class Husband {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wife_id")
    private Wife wife;

    public Husband(){}

    public Husband(String name, Wife wife) {
        this.name=name;
        this.wife = wife;
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
