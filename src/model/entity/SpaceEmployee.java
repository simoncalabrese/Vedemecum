package model.entity;

import javax.persistence.*;

/**
 * Created by simon on 01/09/16.
 */
@Entity
@Table(
        name = "OCCUPAZIONE_IMPIANTI"
)
public class SpaceEmployee {

    @Id
    @Column(
            name = "ID_OCC_IMP",
            nullable = false
    )
    private Integer id;

    @ManyToOne
    @JoinColumn(
            name = "DIPENDENTI_FK",
            nullable = false
    )
    private Employee employee;

    @ManyToOne
    @JoinColumn(
            name = "IMPIANTI_FK",
            nullable = false
    )
    private Space space;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Space getSpace() {
        return space;
    }

    public void setSpace(Space space) {
        this.space = space;
    }
}
