package frontend;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import api.dto.EmployeeDto;
import api.dto.RoleDto;
import ejb.service.EmployeeService;
import ejb.service.RoleService;
import ejb.utils.Enumerators;
import ejb.utils.UtilDate;
import frontend.Dispatcher.ViewDispatcher;
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
    ViewDispatcher dispatcher = ViewDispatcher.getDispatcher();

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
        EmployeeDto dto = new EmployeeDto();
        dto.setNomeDipendente(nameTxt.getText().equals("") ? "" : nameTxt.getText().toUpperCase());
        dto.setCognomeDipendente(surnameText.getText().equals("") ? "" : surnameText.getText().toUpperCase());
        dto.setSessoDipendente(sexChoice.getValue().toUpperCase());
        dto.setDtNascita(UtilDate.toString(date.getValue()).toUpperCase());
        dto.setCodFiscale(cfText.getText().equals("") ? "" : cfText.getText().toUpperCase());
        dto.setTelephone(telText.getText().equals("") ? "" : telText.getText().toUpperCase());
        dto.setEmail(mailText.getText().equals("") ? "" : mailText.getText().toUpperCase());
        dto.setAddress(addressText.getText().equals("") ? "" : addressText.getText().toUpperCase());
        dto.setRole(roleChoice.getValue().toUpperCase());

        if (employeeService.insertEmployee(dto)) {
            populateTable();
        } else {
            dispatcher.alert(Enumerators.Alert.INSERT, "Dipendenti");
        }

    }

    @FXML
    void delEmployee(ActionEvent event) {
        if (table.getSelectionModel().getSelectedIndex() >= 0) {
            if (employeeService.deleteEmployee(
                    table.getItems()
                            .get(table.getSelectionModel().getSelectedIndex())
                            .getCodFiscale())) {
                populateTable();
            } else {
                dispatcher.alert(Enumerators.Alert.DELETE,"Dipendenti");
            }
        }

    }

    @FXML
    void editEmployee(ActionEvent event) {
        EmployeeDto dto = new EmployeeDto();
        if (table.getSelectionModel().getSelectedIndex() >= 0) {
            String oldCf = table.getItems().get(table.getSelectionModel().getSelectedIndex()).getCodFiscale();
            dto.setNomeDipendente(nameTxt.getText().equals("") ? "" : nameTxt.getText().toUpperCase());
            dto.setCognomeDipendente(surnameText.getText().equals("") ? "" : surnameText.getText().toUpperCase());
            dto.setSessoDipendente(sexChoice.getValue().toUpperCase());
            dto.setDtNascita(UtilDate.toString(date.getValue()).toUpperCase());
            dto.setCodFiscale(cfText.getText().equals("") ? "" : cfText.getText().toUpperCase());
            dto.setTelephone(telText.getText().equals("") ? "" : telText.getText().toUpperCase());
            dto.setEmail(mailText.getText().equals("") ? "" : mailText.getText().toUpperCase());
            dto.setAddress(addressText.getText().equals("") ? "" : addressText.getText().toUpperCase());
            dto.setRole(roleChoice.getValue().toUpperCase());
            if (employeeService.updateEmployee(dto, oldCf)) {
                populateTable();
            } else {
                dispatcher.alert(Enumerators.Alert.UPDATE, "Dipendenti");
            }
        } else {
            dispatcher.alert(Enumerators.Alert.SELECTIONROW, null);
        }
    }

    @FXML
    void populateText() {
        if (table.getSelectionModel().getSelectedIndex() >= 0) {
            EmployeeDto employeeDto = table.getItems().get(table.getSelectionModel().getSelectedIndex());
            nameTxt.setText(employeeDto.getNomeDipendente());
            surnameText.setText(employeeDto.getCognomeDipendente());
            sexChoice.setValue(employeeDto.getSessoDipendente());
            date.setValue(UtilDate.toDate(employeeDto.getDtNascita()));
            cfText.setText(employeeDto.getCodFiscale());
            telText.setText(employeeDto.getTelephone());
            mailText.setText(employeeDto.getEmail());
            addressText.setText(employeeDto.getAddress());
            roleChoice.setValue(employeeDto.getRole());
        } else {
            dispatcher.alert(Enumerators.Alert.SELECTIONROW, null);
        }
    }


    @FXML
    void HomePage(ActionEvent event) {
        dispatcher.dispatch(Enumerators.viewsPath.HOMEPAGE.getPath());
    }

    @FXML
    void initialize() {
        nameCol.setCellValueFactory(employee -> employee.getValue().nomeDipendenteProperty());
        surnameCol.setCellValueFactory(employee -> employee.getValue().cognomeDipendenteProperty());
        sexCol.setCellValueFactory(employee -> employee.getValue().sessoDipendenteProperty());
        dateCol.setCellValueFactory(employee -> employee.getValue().dtNascitaProperty());
        cfCol.setCellValueFactory(employee -> employee.getValue().codFiscaleProperty());
        telCol.setCellValueFactory(employee -> employee.getValue().telephoneProperty());
        mailCol.setCellValueFactory(employee -> employee.getValue().emailProperty());
        addrCol.setCellValueFactory(employee -> employee.getValue().addressProperty());
        roleCol.setCellValueFactory(employee -> employee.getValue().roleProperty());
        populateTable();
        ObservableList<String> choice = FXCollections.observableArrayList();
        choice.add("M");
        choice.add("F");
        sexChoice.setItems(choice);

        ObservableList<String> roleCod = FXCollections.observableArrayList();
        List<RoleDto> roles = roleService.getAllMansioni();
        roles.forEach(roleDto -> roleCod.add(roleDto.getCodRole().get()));
        roleChoice.setItems(roleCod);


    }

    private void populateTable() {
        ObservableList<EmployeeDto> lists = FXCollections.observableArrayList();
        List<EmployeeDto> roleDtos = employeeService.getAllEmployees();
        roleDtos.forEach(lists::add);
        table.setItems(lists);
    }
}