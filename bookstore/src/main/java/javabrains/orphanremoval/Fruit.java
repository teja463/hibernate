package javabrains.orphanremoval;

import javax.persistence.*;

@Entity
@Table(name = "temp_fruit")
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserFruit user;

    public UserFruit getUser() {
        return user;
    }

    public void setUser(UserFruit user) {
        this.user = user;
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
