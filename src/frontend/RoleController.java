package frontend;

import api.dto.RoleDto;
import ejb.service.RoleService;
import ejb.utils.Enumerators;
import frontend.Dispatcher.ViewDispatcher;
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

    private ViewDispatcher dispatcher = ViewDispatcher.getDispatcher();

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
    private RoleService roleService = new RoleService();

    @FXML
    void homeBtn(ActionEvent event) {
        dispatcher.dispatch(Enumerators.viewsPath.HOMEPAGE.getPath());
    }

    @FXML
    void initialize() {
        idCol.setCellValueFactory(role -> role.getValue().getIdRole());
        codCol.setCellValueFactory(role -> role.getValue().getCodRole());
        desCol.setCellValueFactory(role -> role.getValue().getDesRole());
        populateTable();

    }

    @FXML
    void populateTable() {
        ObservableList<RoleDto> lists = FXCollections.observableArrayList();
        List<RoleDto> roleDtos = roleService.getAllMansioni();
        roleDtos.forEach(lists::add);
        table.setItems(lists);
    }


}
