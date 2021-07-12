package javabrains.resultsetmapping;

public class ActorDTO {
    private Integer id;

    private String name;

    private Double remunaration;


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
        return "ActorDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", remunaration=" + remunaration +
                '}';
    }
}
