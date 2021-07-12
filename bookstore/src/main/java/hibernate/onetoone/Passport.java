package hibernate.onetoone;

import javax.persistence.*;

@Entity
@Table(name="passport")
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="passport_id")
    private String passportId;

//    @OneToOne(mappedBy ="passport")
//    private Person person;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }

}
