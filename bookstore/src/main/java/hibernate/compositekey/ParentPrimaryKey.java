package hibernate.compositekey;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ParentPrimaryKey implements Serializable {

    @Column(name = "first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    public ParentPrimaryKey(){}

    public ParentPrimaryKey(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParentPrimaryKey that = (ParentPrimaryKey) o;
        return firstName.equals(that.firstName) &&
                lastName.equals(that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
