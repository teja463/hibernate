package jpa.criteria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "agents")
public class Agent {

    @Column(name = "AGENT_CODE")
    @Id
    private String agentCode;

    @Column(name = "AGENT_NAME")
    private String agentName;

    @Column(name = "working_area")
    private String workingArea;

    @Column(name="commission")
    private Double commission;

    @Column(name="phone_no")
    private String phoneNo;

    @Column(name="country")
    private String country;

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getWorkingArea() {
        return workingArea;
    }

    public void setWorkingArea(String workingArea) {
        this.workingArea = workingArea;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "agentCode='" + agentCode + '\'' +
                ", agentName='" + agentName + '\'' +
                ", workingArea='" + workingArea + '\'' +
                ", commission=" + commission +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }
}
