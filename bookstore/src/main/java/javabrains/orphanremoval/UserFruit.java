package javabrains.orphanremoval;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "temp_userfruit")
public class UserFruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Fruit> fruits = new HashSet<>();

    public Set<Fruit> getFruits() {
        return fruits;
    }

    public void setFruits(Set<Fruit> fruits) {
        this.fruits = fruits;
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

    public void addFruit(Fruit fruit){
        fruits.add(fruit);
        fruit.setUser(this);
    }

    public void removeFruit(Fruit fruit){
        fruits.remove(fruit);
        fruit.setUser(null);
    }
}
