package hibernate.onetomany;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="custom_view")
public class CustomView {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="view_name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="view_id")
    private Set<CustomViewColumns> columns = new HashSet<>();

    public CustomView(){}

    public CustomView(String name){
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

    public Set<CustomViewColumns> getColumns() {
        return columns;
    }

    public void setColumns(Set<CustomViewColumns> columns) {
        this.columns = columns;
    }
}
