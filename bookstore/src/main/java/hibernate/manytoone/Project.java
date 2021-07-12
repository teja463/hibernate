package hibernate.manytoone;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="project")
public class Project {

    @Id
    @Column(name="project_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="project_name")
    private String name;

    @OneToMany(mappedBy = "project")
    private List<Employee> employees;

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

    public Project(){

    }

    public Project(String name){
        this.name = name;
    }
}
