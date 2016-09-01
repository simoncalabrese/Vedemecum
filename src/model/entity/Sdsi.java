package model.entity;

import javax.persistence.*;

/**
 * Created by simon on 01/09/16.
 */
@Entity
@Table(
        name = "SCD_DIP_STRUM_IMP"
)
public class Sdsi {
    @Id
    @Column(
            name = "ID",
            nullable = false
    )
    private Integer id;

    @ManyToOne
    @JoinColumn(
            name = "SCHEDA_FK",
            nullable = false
    )
    private Card card;

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

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
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

    public Space getSpace() {
        return space;
    }

    public void setSpace(Space space) {
        this.space = space;
    }
}
