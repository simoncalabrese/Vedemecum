package frontend;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import api.dto.EmployeeDto;
import api.dto.SpaceDto;
import api.dto.StrumentationDto;
import ejb.service.EmployeeService;
import ejb.service.SpaceService;
import ejb.service.StrumentationService;
import ejb.utils.Enumerators;
import ejb.utils.UtilValue;
import frontend.Dispatcher.ViewDispatcher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class AssociationController {

    private final EmployeeService employeeService = new EmployeeService();
    private final SpaceService spaceService = new SpaceService();
    private final StrumentationService strumentationService = new StrumentationService();
    private final ViewDispatcher dispatcher = ViewDispatcher.getDispatcher();
    private Integer command = null;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<EmployeeDto> tableEmployee;

    @FXML
    private TableColumn<EmployeeDto, String> idEmp;

    @FXML
    private TableColumn<EmployeeDto, String> surnameEmp;

    @FXML
    private TableColumn<EmployeeDto, String> nameEmp;

    @FXML
    private TableColumn<EmployeeDto, String> cfEmp;

    @FXML
    private TableView<StrumentationDto> tableStrumentation;

    @FXML
    private TableColumn<StrumentationDto, String> idStrum;

    @FXML
    private TableColumn<StrumentationDto, String> desStrum;

    @FXML
    private TableColumn<StrumentationDto, String> modelStrum;

    @FXML
    private TableColumn<StrumentationDto, String> totStrum;

    @FXML
    private TableView<SpaceDto> tableSpace;

    @FXML
    private TableColumn<SpaceDto, String> isSpace;

    @FXML
    private TableColumn<SpaceDto, String> desSpace;

    @FXML
    private TableColumn<SpaceDto, String> addressSpace;

    @FXML
    private RadioButton dipStrumButton;

    @FXML
    private RadioButton dipImpButton;

    @FXML
    private Label toEditetLabelOne;

    @FXML
    private Label toEditetLabelTwo;

    @FXML
    private Label cfLabelToEdit;

    @FXML
    private Label ToEditedValueOne;

    @FXML
    private Label ToEditedValueTwo;

    @FXML
    void btnAssoc() {
        if (command != null && UtilValue.isValidString(cfLabelToEdit.getText())) {
            switch (command) {
                case 1: //Todo
                    break;
                case 2:
                    break;//TODO
            }
        }

    }

    @FXML
    void btnHome() {
        dispatcher.dispatch(Enumerators.viewsPath.HOMEPAGE.getPath());
    }


    @FXML
    void dipImpButton() {
        ToEditedValueOne.setText("");
        ToEditedValueTwo.setText("");
        dipStrumButton.setSelected(false);
        tableSpace.setDisable(false);
        tableStrumentation.setDisable(true);

    }

    @FXML
    void dipStrumButton() {
        ToEditedValueOne.setText("");
        ToEditedValueTwo.setText("");
        dipImpButton.setSelected(false);
        tableStrumentation.setDisable(false);
        tableSpace.setDisable(true);

    }

    @FXML
    void initialize() {
        inizializeTable();

        //Populate table Dipendenti
        ObservableList<EmployeeDto> listEmployees = FXCollections.observableArrayList();
        List<EmployeeDto> roleDtos = employeeService.getAllEmployees();
        roleDtos.forEach(listEmployees::add);
        tableEmployee.setItems(listEmployees);
        //populate table Strumentazioni
        ObservableList<StrumentationDto> listsStrumentations = FXCollections.observableArrayList();
        List<StrumentationDto> strumentationDto = strumentationService.getAllStrumentation();
        strumentationDto.forEach(listsStrumentations::add);
        tableStrumentation.setItems(listsStrumentations);
        //populate table Space
        List<SpaceDto> spaceDto = spaceService.getAllSpace();
        ObservableList<SpaceDto> listsSpaces = FXCollections.observableArrayList();
        spaceDto.forEach(listsSpaces::add);
        tableSpace.setItems(listsSpaces);
    }

    private void inizializeTable() {
        idEmp.setCellValueFactory(param -> param.getValue().idDipedenteProperty());
        surnameEmp.setCellValueFactory(param -> param.getValue().cognomeDipendenteProperty());
        nameEmp.setCellValueFactory(param -> param.getValue().nomeDipendenteProperty());
        cfEmp.setCellValueFactory(param -> param.getValue().codFiscaleProperty());
        isSpace.setCellValueFactory(param -> param.getValue().idSpaceProperty());
        desSpace.setCellValueFactory(param -> param.getValue().desSpaceProperty());
        addressSpace.setCellValueFactory(param -> param.getValue().addressSpaceProperty());
        idStrum.setCellValueFactory(param -> param.getValue().idStrumentazioneProperty());
        desStrum.setCellValueFactory(param -> param.getValue().desStrumentazioneProperty());
        modelStrum.setCellValueFactory(param -> param.getValue().modelloStrumentazioneProperty());
        totStrum.setCellValueFactory(param -> param.getValue().pezziProperty());

    }

    @FXML
    void gridAssignEmployee() {

        if (tableEmployee.getSelectionModel().getSelectedIndex() >= 0) {
            EmployeeDto employeeDto = tableEmployee.getItems().get(tableEmployee.getSelectionModel().getSelectedIndex());
            cfLabelToEdit.setText(employeeDto.getCodFiscale());
            tableEmployee.getSelectionModel().clearSelection();

        } else {
            if (!cfLabelToEdit.getText().equals("")) {
                cfLabelToEdit.setText("");
            }
        }

    }

    @FXML
    void gridAssignImpStrum() {
        if (dipImpButton.isSelected()) {
            SpaceDto spaceDto = tableSpace.getItems().get(tableSpace.getSelectionModel().getSelectedIndex());
            ToEditedValueOne.setText(spaceDto.getIdSpace());
            ToEditedValueTwo.setText(spaceDto.getDesSpace());
            command = 1;
        } else if (dipStrumButton.isSelected()) {
            StrumentationDto strumentationDto = tableStrumentation.getItems().get(tableStrumentation.getSelectionModel().getSelectedIndex());
            ToEditedValueOne.setText(strumentationDto.getIdStrumentazione());
            ToEditedValueTwo.setText(strumentationDto.getDesStrumentazione());
            command = 2;
        }

    }

}
