package model.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by simon on 01/09/16.
 */
@Entity
@Table(
        name = "ANAG_STRUMENTAZIONI"
)
public class Strumentation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            name = "ID_STRUMENTAZIONE",
            nullable = false
    )
    private Integer idStrumentazione;

    @Column(
            name = "DES_STRUMENTAZIONE"
    )
    private String desStrumentazione;

    @Column(
            name = "MODELLO_STRUMENTAZIONE",
            nullable = false
    )
    private String modelloStrumentazione;

    @Column(
            name = "MARCA_STRUMENTAZIONE",
            nullable = false
    )
    private String marcaStrumentazione;

    @Column(
            name = "AMNT_PEZZI",
            nullable = false
    )
    private Integer pezzi;


    @Column(
            name = "DT_ACQUISTO"
    )
    private LocalDate dtAcquisto;

    @OneToMany(
            targetEntity=EmployeeStrumentation.class,
            mappedBy = "strumentation"
    )
    private List<EmployeeStrumentation> employeeStrumentations;

    @OneToMany(
            mappedBy = "strumentation"
    )
    private List<Sdsi> sdsis;

    public Integer getIdStrumentazione() {
        return idStrumentazione;
    }

    public void setIdStrumentazione(Integer idStrumentazione) {
        this.idStrumentazione = idStrumentazione;
    }

    public String getDesStrumentazione() {
        return desStrumentazione;
    }

    public void setDesStrumentazione(String desStrumentazione) {
        this.desStrumentazione = desStrumentazione;
    }

    public String getModelloStrumentazione() {
        return modelloStrumentazione;
    }

    public void setModelloStrumentazione(String modelloStrumentazione) {
        this.modelloStrumentazione = modelloStrumentazione;
    }

    public String getMarcaStrumentazione() {
        return marcaStrumentazione;
    }

    public void setMarcaStrumentazione(String marcaStrumentazione) {
        this.marcaStrumentazione = marcaStrumentazione;
    }

    public Integer getPezzi() {
        return pezzi;
    }

    public void setPezzi(Integer pezzi) {
        this.pezzi = pezzi;
    }

    public LocalDate getDtAcquisto() {
        return dtAcquisto;
    }

    public void setDtAcquisto(LocalDate dtAcquisto) {
        this.dtAcquisto = dtAcquisto;
    }

    public List<EmployeeStrumentation> getEmployeeStrumentations() {
        return employeeStrumentations;
    }

    public void setEmployeeStrumentations(List<EmployeeStrumentation> employeeStrumentations) {
        this.employeeStrumentations = employeeStrumentations;
    }

    public List<Sdsi> getSdsis() {
        return sdsis;
    }

    public void setSdsis(List<Sdsi> sdsis) {
        this.sdsis = sdsis;
    }
}
