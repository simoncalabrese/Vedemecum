package model.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by simon on 01/09/16.
 */
@Entity
@Table(
        name = "MANSIONI"
)
public class Role {
    @Id
    @Column(
            name = "ID_MANSIONE",
            nullable = false

    )
    private Integer idRole;

    @Column(
            name = "COD_MANSIONE",
            nullable = false

    )
    private String codRole;

    @Column(
            name = "DES_MANSIONE",
            nullable = false

    )
    private String desRole;

    @OneToMany(
            mappedBy = "role"
    )
    private List<Employee> employees;

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public String getCodRole() {
        return codRole;
    }

    public void setCodRole(String codRole) {
        this.codRole = codRole;
    }

    public String getDesRole() {
        return desRole;
    }

    public void setDesRole(String desRole) {
        this.desRole = desRole;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
