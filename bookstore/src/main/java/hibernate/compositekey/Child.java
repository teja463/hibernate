package hibernate.compositekey;

import javax.persistence.*;

@Entity
@Table(name="child")
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    private String name;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumns({
            @JoinColumn(name = "firstname_fk",referencedColumnName = "first_name"),
            @JoinColumn(name = "lastname_fk",referencedColumnName = "last_name")
    })
    private Parent parent;

    public Child(String name) {
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

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }
}
