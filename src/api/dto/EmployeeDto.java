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


    public String getIdDipedente() {
        return idDipedente.get();
    }

    public StringProperty idDipedenteProperty() {
        return idDipedente;
    }

    public void setIdDipedente(String idDipedente) {
        this.idDipedente.set(idDipedente);
    }

    public String getNomeDipendente() {
        return nomeDipendente.get();
    }

    public StringProperty nomeDipendenteProperty() {
        return nomeDipendente;
    }

    public void setNomeDipendente(String nomeDipendente) {
        this.nomeDipendente.set(nomeDipendente);
    }

    public String getCognomeDipendente() {
        return cognomeDipendente.get();
    }

    public StringProperty cognomeDipendenteProperty() {
        return cognomeDipendente;
    }

    public void setCognomeDipendente(String cognomeDipendente) {
        this.cognomeDipendente.set(cognomeDipendente);
    }

    public String getSessoDipendente() {
        return sessoDipendente.get();
    }

    public StringProperty sessoDipendenteProperty() {
        return sessoDipendente;
    }

    public void setSessoDipendente(String sessoDipendente) {
        this.sessoDipendente.set(sessoDipendente);
    }

    public String getDtNascita() {
        return dtNascita.get();
    }

    public StringProperty dtNascitaProperty() {
        return dtNascita;
    }

    public void setDtNascita(String dtNascita) {
        this.dtNascita.set(dtNascita);
    }

    public String getCodFiscale() {
        return codFiscale.get();
    }

    public StringProperty codFiscaleProperty() {
        return codFiscale;
    }

    public void setCodFiscale(String codFiscale) {
        this.codFiscale.set(codFiscale);
    }

    public String getTelephone() {
        return telephone.get();
    }

    public StringProperty telephoneProperty() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone.set(telephone);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getAddress() {
        return address.get();
    }

    public StringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getRole() {
        return role.get();
    }

    public StringProperty roleProperty() {
        return role;
    }

    public void setRole(String role) {
        this.role.set(role);
    }
}
