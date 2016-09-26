package model.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by simon on 01/09/16.
 */
@Entity
@Table(
        name = "DIPENDENTI_STRUMENTAZIONI"
)
public class  EmployeeStrumentation {

    @Id
    @Column(
            name = "ID_DIPENDENTI_STRUMENTAZIONI",
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
            name = "STRUMENTAZIONI_FK",
            nullable = false
    )
    private Strumentation strumentation;

    @Column(
            name = "DT_ASSEGNAZIONE",
            nullable = false
    )
    private LocalDate dtAssign;

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

    public Strumentation getStrumentation() {
        return strumentation;
    }

    public void setStrumentation(Strumentation strumentation) {
        this.strumentation = strumentation;
    }

    public LocalDate getDtAssign() {
        return dtAssign;
    }

    public void setDtAssign(LocalDate dtAssign) {
        this.dtAssign = dtAssign;
    }
}