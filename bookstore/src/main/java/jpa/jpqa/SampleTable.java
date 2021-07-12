package jpa.jpqa;

import javax.persistence.*;

@Entity
@Table(name="sample_table")
public class SampleTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String empId;

    private String email;

    private String address;

    public SampleTable(){

    }

    public SampleTable(String name, String empId, String email, String address) {
        this.name = name;
        this.empId = empId;
        this.email = email;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmpId() {
        return empId;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "SampleTable{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", empId='" + empId + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
