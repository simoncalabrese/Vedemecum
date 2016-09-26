package api.dto;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by simon on 05/09/16.
 */
public class AssociationDto {

    private StringProperty idAssociation;

    private StringProperty idSpaceStrumentation;

    private StringProperty idEmployee;

    private StringProperty dateAssign;

    public String getIdAssociation() {
        return idAssociation.get();
    }

    public StringProperty idAssociationProperty() {
        return idAssociation;
    }

    public void setIdAssociation(String idAssociation) {
        this.idAssociation = new SimpleStringProperty(idAssociation);
    }

    public String getIdSpaceStrumentation() {
        return idSpaceStrumentation.get();
    }

    public StringProperty idSpaceStrumentationProperty() {
        return idSpaceStrumentation;
    }

    public void setIdSpaceStrumentation(String idSpaceStrumentation) {
        this.idSpaceStrumentation = new SimpleStringProperty(idSpaceStrumentation);
    }

    public String getIdEmployee() {
        return idEmployee.get();
    }

    public StringProperty idEmployeeProperty() {
        return idEmployee;
    }

    public void setIdEmployee(String idEmployee) {
        this.idEmployee= new SimpleStringProperty(idEmployee);
    }

    public String getDateAssign() {
        return dateAssign.get();
    }

    public StringProperty dateAssignProperty() {
        return dateAssign;
    }

    public void setDateAssign(String dateAssign) {
        this.dateAssign= new SimpleStringProperty(dateAssign);
    }
}
