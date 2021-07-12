package javabrains.one2one;

import javax.persistence.*;

@Entity
@Table(name = "o2o_wife")
public class Wife {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToOne(mappedBy = "wife", cascade = CascadeType.ALL)
    private Husband husband;

    public void addHusband(Husband husband){
        this.husband = husband;
        husband.setWife(this);
    }

    public Husband getHusband() {
        return husband;
    }

    public void setHusband(Husband husband) {
        this.husband = husband;
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
