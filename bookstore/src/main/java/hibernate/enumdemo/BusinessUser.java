package hibernate.enumdemo;

import javax.persistence.*;

@Entity
@Table(name="business_user")
public class BusinessUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name="biz_user_type")
    private BusinessUserType bizUserType;

    public BusinessUser(){}

    public BusinessUser(String name, BusinessUserType bizUserType) {
        this.name = name;
        this.bizUserType = bizUserType;
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

    public BusinessUserType getBizUserType() {
        return bizUserType;
    }

    public void setBizUserType(BusinessUserType bizUserType) {
        this.bizUserType = bizUserType;
    }
}
