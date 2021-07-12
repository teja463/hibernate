package jpa.temp;


import javax.persistence.*;

@Entity
@Table(name="jpa_many")
public class Many {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "address")
    private String address;

    @ManyToOne
    @JoinColumn(name="user_id")
    private One one;

    public One getOne() {
        return one;
    }

    public void setOne(One one) {
        this.one = one;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
