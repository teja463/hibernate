package hibernate.compositekey;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="parent")
public class Parent {

    @EmbeddedId
    private ParentPrimaryKey parentPrimaryKey;

    @OneToMany(mappedBy = "parent",cascade = {CascadeType.ALL})
    private Set<Child> children = new HashSet<>();

    public  Parent(){}

    public Parent(ParentPrimaryKey parentPrimaryKey){
        this.parentPrimaryKey = parentPrimaryKey;
    }
    public ParentPrimaryKey getParentPrimaryKey() {
        return parentPrimaryKey;
    }

    public void setParentPrimaryKey(ParentPrimaryKey parentPrimaryKey) {
        this.parentPrimaryKey = parentPrimaryKey;
    }

    public void addChild(Child child){
        children.add(child);
        child.setParent(this);
    }
}
