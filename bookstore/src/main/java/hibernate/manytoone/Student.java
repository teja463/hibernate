package hibernate.manytoone;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "guide_id")
    private Guide guide;

    public Student() {
    }

    public Student(String name, Guide guide) {
        this.name = name;
        this.guide = guide;
    }
}
