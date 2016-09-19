package frontend;

import api.dto.RoleDto;
import ejb.service.RoleService;
import ejb.utils.Enumerators;
import ejb.utils.UtilValue;
import frontend.Dispatcher.ViewDispatcher;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

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
    private GridPane gridPane;


    @FXML
    private Label idLabel = null;

    @FXML
    private TextField codText;

    @FXML
    private TextField desText;

    private Integer command;

    @FXML
    void addBtn() {
        gridPane.setVisible(true);
        idLabel.setText("");
        codText.clear();
        desText.clear();
        command = 0;
    }


    @FXML
    void btnConfirm(ActionEvent event) {
        RoleDto dto = new RoleDto();
        dto.setIdRole(idLabel.getText().length() != 0
                ? Integer.valueOf(idLabel.getText())
                : null);
        dto.setCodRole(!(UtilValue.isNumeric(codText.getText(), Long::valueOf))
                ? codText.getText().toUpperCase()
                : null);
        dto.setDesRole(!(UtilValue.isNumeric(desText.getText(), Long::valueOf))
                ? desText.getText().toUpperCase()
                : null);
        whatway(dto, command);
    }

    private void whatway(RoleDto dto, Integer command) {
        if (command != null) {
            switch (command) {
                case 0:
                    if (roleService.insertMansione(dto)) {
                        populateTable();
                    } else {
                        dispatcher.alert(Enumerators.Alert.INSERT, "Ruoli");
                    }
                    break;
                case 1:
                    if (roleService.updateMansione(dto)) {
                        populateTable();
                    } else {
                        dispatcher.alert(Enumerators.Alert.UPDATE, "Ruoli");
                    }
                    break;
            }
        }
    }


    @FXML
    void delBrn() {
        RoleDto roleDto = table.getItems().get(table.getSelectionModel().getSelectedIndex());
        if (roleService.deleteMansione(Integer.valueOf(roleDto.getIdRole().getValue()))) {
            populateTable();
        } else {
            dispatcher.alert(Enumerators.Alert.DELETE, "Ruoli");
        }

    }

    @FXML
    void editBtn() {
        gridPane.setVisible(true);
        command = 1;
        RoleDto roleDto = table.getItems().get(table.getSelectionModel().getSelectedIndex());
        idLabel.setText(roleDto.getIdRole().getValue());
        codText.setText(roleDto.getCodRole().getValue());
        desText.setText(roleDto.getDesRole().getValue());
    }

    @FXML
    private RoleService roleService = new RoleService();

    @FXML
    void homeBtn() {
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
