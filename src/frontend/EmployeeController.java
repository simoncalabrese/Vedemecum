package frontend;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import api.dto.EmployeeDto;
import api.dto.RoleDto;
import ejb.service.EmployeeService;
import ejb.service.RoleService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class EmployeeController {

    private EmployeeService employeeService = new EmployeeService();
    private RoleService roleService = new RoleService();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<EmployeeDto> table;

    @FXML
    private TableColumn<EmployeeDto, String> nameCol;

    @FXML
    private TableColumn<EmployeeDto, String> surnameCol;

    @FXML
    private TableColumn<EmployeeDto, String> sexCol;

    @FXML
    private TableColumn<EmployeeDto, String> dateCol;

    @FXML
    private TableColumn<EmployeeDto, String> cfCol;

    @FXML
    private TableColumn<EmployeeDto, String> telCol;

    @FXML
    private TableColumn<EmployeeDto, String> mailCol;

    @FXML
    private TableColumn<EmployeeDto, String> addrCol;

    @FXML
    private TableColumn<EmployeeDto, String> roleCol;

    @FXML
    private AnchorPane sudPane;

    @FXML
    private TextField nameTxt;

    @FXML
    private TextField surnameText;

    @FXML
    private ComboBox<String> sexChoice;

    @FXML
    private TextField cfText;

    @FXML
    private TextField telText;

    @FXML
    private TextField mailText;

    @FXML
    private TextField addressText;

    @FXML
    private ComboBox<String> roleChoice;

    @FXML
    private DatePicker date;

    @FXML
    void addEmployee(ActionEvent event) {
        sudPane.setVisible(true);
        ObservableList<String> choice = FXCollections.observableArrayList();
        choice.add("M");
        choice.add("F");
        sexChoice.setItems(choice);

        ObservableList<String> roleCod = FXCollections.observableArrayList();
        List<RoleDto> roles = roleService.getAllMansioni();
        roles.forEach(roleDto -> roleCod.add(roleDto.getCodRole().get()));
        roleChoice.setItems(roleCod);

    }

    @FXML
    void delEmployee(ActionEvent event) {

    }

    @FXML
    void editEmployee(ActionEvent event) {

    }

    @FXML
    void initialize() {
        sudPane.setVisible(false);

        nameCol.setCellValueFactory(employee -> employee.getValue().nomeDipendenteProperty());
        surnameCol.setCellValueFactory(employee -> employee.getValue().cognomeDipendenteProperty());
        sexCol.setCellValueFactory(employee -> employee.getValue().sessoDipendenteProperty());
        dateCol.setCellValueFactory(employee -> employee.getValue().dtNascitaProperty());
        cfCol.setCellValueFactory(employee -> employee.getValue().codFiscaleProperty());
        telCol.setCellValueFactory(employee -> employee.getValue().telephoneProperty());
        mailCol.setCellValueFactory(employee -> employee.getValue().emailProperty());
        addrCol.setCellValueFactory(employee -> employee.getValue().addressProperty());
        roleCol.setCellValueFactory(employee -> employee.getValue().roleProperty().getCodRole());
        ObservableList<EmployeeDto> lists = FXCollections.observableArrayList();
        List<EmployeeDto> roleDtos = employeeService.getAllEmployees();
        roleDtos.forEach(lists::add);
        table.setItems(lists);


    }
}