package model.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by simon on 01/09/16.
 */
@Entity
@Table(
        name = "SCD_SCHEDA"
)
public class Card {

    @Id
    @Column(
            name = "ID_SCHEDA",
            nullable = false
    )
    private Integer idScheda;

    @Column(
            name = "HEADER_TXT"
    )
    private String header;

    @Column(
            name = "BOTTOM_TXT"
    )
    private String bottom;

    @OneToMany(
            mappedBy = "card"
    )
    private List<Sdsi> schedaDipStrumImp;

    public Integer getIdScheda() {
        return idScheda;
    }

    public void setIdScheda(Integer idScheda) {
        this.idScheda = idScheda;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getBottom() {
        return bottom;
    }

    public void setBottom(String bottom) {
        this.bottom = bottom;
    }

    public List<Sdsi> getSchedaDipStrumImp() {
        return schedaDipStrumImp;
    }

    public void setSchedaDipStrumImp(List<Sdsi> schedaDipStrumImp) {
        this.schedaDipStrumImp = schedaDipStrumImp;
    }
}
