package hibernate.onetomany;

import javax.persistence.*;

@Entity
@Table(name="custom_view_columns")
public class CustomViewColumns {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="column_name")
    private String columnName;

    @Column(name="view_id")
    private Integer viewId;

    public Integer getViewId() {
        return viewId;
    }

    public void setViewId(Integer viewId) {
        this.viewId = viewId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public CustomViewColumns(){}

    public CustomViewColumns(String columnName) {
        this.columnName = columnName;
    }
}
