package javabrains.resultsetmapping;

public class UserFruitMapping {

    private Integer id;

    private String name;

    private String fruit;

    public UserFruitMapping(){}

    public UserFruitMapping(Integer id, String name, String fruit) {
        this.id = id;
        this.name = name;
        this.fruit = fruit;
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

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    @Override
    public String toString() {
        return "UserFruitMapping{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fruit='" + fruit + '\'' +
                '}';
    }
}
