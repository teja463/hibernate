package hibernate.manytoone;

import javax.persistence.*;

@Entity
@Table(name="guide")
public class Guide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    public Guide(){}

    public Guide(String name) {
        this.name = name;
    }
}
