package api.dto;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.entity.Role;

import java.util.Date;

/**
 * Created by simon on 05/09/16.
 */
public class EmployeeDto {

    private StringProperty idDipedente;

    private StringProperty nomeDipendente;

    private StringProperty cognomeDipendente;

    private StringProperty sessoDipendente;

    private StringProperty dtNascita;

    private StringProperty codFiscale;

    private StringProperty telephone;

    private StringProperty email;

    private StringProperty address;

    private StringProperty role;

    public StringProperty idDipedenteProperty() {
        return idDipedente;
    }

    public void setIdDipedente(String idDipedente) {
        this.idDipedente = new SimpleStringProperty(idDipedente);
    }

    public StringProperty nomeDipendenteProperty() {
        return nomeDipendente;
    }

    public void setNomeDipendente(String nomeDipendente) {
        this.nomeDipendente = new SimpleStringProperty(nomeDipendente);
    }

    public StringProperty cognomeDipendenteProperty() {
        return cognomeDipendente;
    }

    public void setCognomeDipendente(String cognomeDipendente) {
        this.cognomeDipendente = new SimpleStringProperty(cognomeDipendente);
    }

    public StringProperty sessoDipendenteProperty() {
        return sessoDipendente;
    }

    public void setSessoDipendente(String sessoDipendente) {
        this.sessoDipendente = new SimpleStringProperty(sessoDipendente);
    }

    public StringProperty dtNascitaProperty() {
        return dtNascita;
    }

    public void setDtNascita(String dtNascita) {
        this.dtNascita = new SimpleStringProperty(dtNascita);
    }

    public StringProperty codFiscaleProperty() {
        return codFiscale;
    }

    public void setCodFiscale(String codFiscale) {
        this.codFiscale = new SimpleStringProperty(codFiscale);
    }

    public StringProperty telephoneProperty() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = new SimpleStringProperty(telephone);
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email = new SimpleStringProperty(email);
    }

    public StringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address = new SimpleStringProperty(address);
    }

    public RoleDto roleProperty() {
        RoleDto dto = new RoleDto();
        dto.setCodRole(role.get());
        return dto;
    }

    public void setRole(Role role) {
        this.role = new SimpleStringProperty(role.getCodRole());
    }
}
