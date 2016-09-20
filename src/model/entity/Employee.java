package model.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by simon on 01/09/16.
 */
@Entity
@Table(
        name = "ANAG_DIPENDENTI"
)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            name = "ID_DIPENDENTI",
            nullable = false

    )
    private Integer idDipedente;

    @Column(
            name = "NOME_DIPENDENTI",
            nullable = false

    )
    private String nomeDipendente;

    @Column(
            name = "COGNOME_DIPENDENTI",
            nullable = false

    )
    private String cognomeDipendente;

    @Column(
            name = "SESSO_DIPENDENTI"

    )
    private String sessoDipendente;

    @Column(
            name = "DT_NASCITA"
    )
    private LocalDate dtNascita;

    @Column(
            name = "CODICE_FISCALE",
            nullable = false,
            unique = true
    )
    private String codFiscale;

    @Column(
            name = "IND_TELEFONO"
    )
    private String telephone;

    @Column(
            name = "IND_EMAIL"
    )
    private String email;

    @Column(
            name = "IND_RESIDENZA",
            nullable = false
    )
    private String address;


    @ManyToOne
    @JoinColumn(
            name = "MANSIONI_FK"
    )
    private Role role;

    @OneToMany(
            mappedBy = "employee"
    )
    private List<EmployeeStrumentation> employeeStrumentations;

    @OneToMany(
            mappedBy = "employee"
    )
    private List<Sdsi> sdsis;

    @OneToMany(
            mappedBy = "employee"
    )
    private List<SpaceEmployee> spaceEmployees;

    public Integer getIdDipedente() {
        return idDipedente;
    }

    public void setIdDipedente(Integer idDipedente) {
        this.idDipedente = idDipedente;
    }

    public String getNomeDipendente() {
        return nomeDipendente;
    }

    public void setNomeDipendente(String nomeDipendente) {
        this.nomeDipendente = nomeDipendente;
    }

    public String getCognomeDipendente() {
        return cognomeDipendente;
    }

    public void setCognomeDipendente(String cognomeDipendente) {
        this.cognomeDipendente = cognomeDipendente;
    }

    public String getSessoDipendente() {
        return sessoDipendente;
    }

    public void setSessoDipendente(String sessoDipendente) {
        this.sessoDipendente = sessoDipendente;
    }

    public LocalDate getDtNascita() {
        return dtNascita;
    }

    public void setDtNascita(LocalDate dtNascita) {
        this.dtNascita = dtNascita;
    }

    public String getCodFiscale() {
        return codFiscale;
    }

    public void setCodFiscale(String codFiscale) {
        this.codFiscale = codFiscale;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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

    public List<SpaceEmployee> getSpaceEmployees() {
        return spaceEmployees;
    }

    public void setSpaceEmployees(List<SpaceEmployee> spaceEmployees) {
        this.spaceEmployees = spaceEmployees;
    }
}
