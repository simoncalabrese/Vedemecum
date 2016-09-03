package frontend;

import api.dto.RoleDto;
import ejb.service.RoleService;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javax.ejb.EJB;
import java.util.List;

public class RoleController {

    @FXML
    private TableView<RoleDto> table;

    @FXML
    private TableColumn<RoleDto, String> idCol;

    @FXML
    private TableColumn<RoleDto, String> codCol;

    @FXML
    private TableColumn<RoleDto, String> desCol;

    @FXML
    private Button addBtn;

    @FXML
    private Button editBtn;

    @FXML
    private Button delBrn;

    @FXML
    private Button homeBtn;

    @FXML
    private RoleService roleService = new RoleService();

    @FXML
    void initialize() {
        idCol.setCellValueFactory(role -> role.getValue().getIdRole());
        codCol.setCellValueFactory(role -> role.getValue().getCodRole());
        desCol.setCellValueFactory(role -> role.getValue().getDesRole());

    }

    @FXML
    void populateTable(ActionEvent event){
        ObservableList<RoleDto> lists = FXCollections.observableArrayList();
        List<RoleDto> roleDtos = roleService.getAllMansioni();
        roleDtos.forEach(lists::add);
        table.setItems(lists);
    }


}
