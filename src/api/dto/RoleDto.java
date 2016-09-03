package api.dto;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by simon on 31/08/16.
 */
public class RoleDto {

    private StringProperty idRole;

    private StringProperty codRole;

    private StringProperty desRole;

    public StringProperty getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = new SimpleStringProperty(idRole.toString());
    }

    public StringProperty getCodRole() {
        return codRole;
    }

    public void setCodRole(String codRole) {
        this.codRole = new SimpleStringProperty(codRole);
    }

    public StringProperty getDesRole() {
        return desRole;
    }

    public void setDesRole(String desRole) {
        this.desRole = new SimpleStringProperty(desRole);
    }
}
