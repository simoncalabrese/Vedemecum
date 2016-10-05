package api.dto;

import javafx.beans.property.SimpleStringProperty;

import java.util.List;

/**
 * Created by simon on 04/10/16.
 */
public class SdsiDto {

    private SimpleStringProperty idCard;
    private List<Integer> idEmployees;
    private List<Integer> idSpaces;
    private List<Integer> idStrumentations;


    public String getIdCard() {
        return idCard.get();
    }

    public SimpleStringProperty idCardProperty() {
        return idCard;
    }

    public void setIdCard(Integer idCard) {
        this.idCard = new SimpleStringProperty(idCard.toString());
    }

    public List<Integer> getIdEmployees() {
        return idEmployees;
    }

    public void setIdEmployees(List<Integer> idEmployees) {
        this.idEmployees = idEmployees;
    }

    public List<Integer> getIdSpaces() {
        return idSpaces;
    }

    public void setIdSpaces(List<Integer> idSpaces) {
        this.idSpaces = idSpaces;
    }

    public List<Integer> getIdStrumentations() {
        return idStrumentations;
    }

    public void setIdStrumentations(List<Integer> idStrumentations) {
        this.idStrumentations = idStrumentations;
    }
}
