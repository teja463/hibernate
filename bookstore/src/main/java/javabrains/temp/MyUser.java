package javabrains.temp;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="my_user")
public class MyUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<MyVehicle> vehicles = new HashSet<>();

    @ManyToOne
    @JoinColumn(name="app_user_id")
    private AppUser appUser;

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Set<MyVehicle> getMyVehicles() {
        return vehicles;
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

    public void addMyVehicle(MyVehicle car) {
        this.vehicles.add(car);
        car.setUser(this);
    }
}
