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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
    private List<Employee> employees;


    @OneToMany(
            mappedBy = "card"
    )
    private List<Space> spaces;


    @OneToMany(
            mappedBy = "card"
    )
    private List<Strumentation> strumentations;

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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Space> getSpaces() {
        return spaces;
    }

    public void setSpaces(List<Space> spaces) {
        this.spaces = spaces;
    }

    public List<Strumentation> getStrumentations() {
        return strumentations;
    }

    public void setStrumentations(List<Strumentation> strumentations) {
        this.strumentations = strumentations;
    }
}
