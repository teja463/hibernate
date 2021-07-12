package javabrains.changedetection;

import javabrains.one2many.Vehicle;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="change_user")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

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
