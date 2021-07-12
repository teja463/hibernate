package javabrains.resultsetmapping;

import javax.persistence.*;

@Entity(name = "MyActor")
@Table(name = "my_actor")
//@SqlResultSetMapping(name = "ActorMapping", entities = @EntityResult(
//        entityClass = Actor.class,
//        fields = {
//                @FieldResult(name = "id", column = "actorId"),
//                @FieldResult(name = "name", column = "name"),
//                @FieldResult(name = "remunaration", column = "salary"),
//        }
//))
@SqlResultSetMapping(
        name = "UserFruitMapping", classes = @ConstructorResult(
                targetClass = UserFruitMapping.class,
                columns = {
                        @ColumnResult(name="id", type = Integer.class),
                        @ColumnResult(name="name"),
                        @ColumnResult(name="fruit")
                }
))
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Double remunaration;

    public Actor(String name, Double remunaration) {
        this.name = name;
        this.remunaration = remunaration;
    }

    public Actor() {
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

    public Double getRemunaration() {
        return remunaration;
    }

    public void setRemunaration(Double remunaration) {
        this.remunaration = remunaration;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", remunaration=" + remunaration +
                '}';
    }
}
