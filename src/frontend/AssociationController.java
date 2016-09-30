package frontend;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import api.dto.EmployeeDto;
import api.dto.SpaceDto;
import api.dto.AssociationDto;
import api.dto.StrumentationDto;
import api.utils.UtilDate;
import ejb.service.*;
import api.utils.Enumerators;
import api.utils.UtilValue;
import frontend.Dispatcher.ViewDispatcher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AssociationController {

    private final EmployeeService employeeService = new EmployeeService();
    private final SpaceService spaceService = new SpaceService();
    private final StrumentationService strumentationService = new StrumentationService();
    private final ViewDispatcher dispatcher = ViewDispatcher.getDispatcher();
    private final AssociationEmployeeSpaceService employeeSpaceService = new AssociationEmployeeSpaceService();
    private final AssociationEmployeeStrumentationService employeeStrumentationService = new AssociationEmployeeStrumentationService();

    private Integer command = -1;
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
    private Label idLabel;

    @FXML
    private Label ToEditedValueOne;

    @FXML
    private Label ToEditedValueTwo;

    @FXML
    private Label dateLabel;

    @FXML
    private DatePicker dateAssign;

    @FXML
    void btnAssoc() {
        if (command != -1
                && UtilValue.isNumeric(idLabel.getText(), Integer::valueOf)
                && UtilValue.isNumeric(ToEditedValueOne.getText(), Integer::valueOf)) {
            AssociationDto dto = new AssociationDto();
            dto.setIdAssociation(null); //because the key is "autoincrement"
            dto.setIdEmployee(idLabel.getText());
            dto.setIdSpaceStrumentation(ToEditedValueOne.getText());
            insertForSelection(dto, command);
        } else {
            dispatcher.alert(Enumerators.Alert.VALUES, "Dipendente o \n"
                    + (command.equals(1) ? "Impianti" : "Strumentazioni"));
        }

    }

    private void insertForSelection(AssociationDto dto, Integer command) {
        switch (command) {
            case 1:
                if (employeeSpaceService.insertAssociation(dto)) {
                    dispatcher.alert(Enumerators.Alert.SUCCESS, " Occupazione Impianti.");
                } else {
                    dispatcher.alert(Enumerators.Alert.INSERT, "Associazione");
                }
                break;
            case 2:
                dto.setDateAssign(UtilDate.toString(dateAssign.getValue()));
                if (UtilValue.isValidString(dto.getDateAssign()) && employeeStrumentationService.insertAssociation(dto)) {
                    dispatcher.alert(Enumerators.Alert.SUCCESS, " Assegnazione strumentazioni.");
                } else {
                    dispatcher.alert(Enumerators.Alert.INSERT, "Associazione");
                }
                break;
        }
    }

    @FXML
    void btnViewAll(){

    }

    @FXML
    void btnHome() {
        dispatcher.dispatch(Enumerators.viewsPath.HOMEPAGE.getPath());
    }


    @FXML
    void dipImpButton() {
        tableSpace.setDisable(false);

        ToEditedValueOne.setText("");
        ToEditedValueTwo.setText("");
        dateLabel.setVisible(false);
        dateAssign.setVisible(false);
        dipStrumButton.setSelected(false);
        tableSpace.setDisable(false);
        tableStrumentation.setDisable(true);

    }

    @FXML
    void dipStrumButton() {
        tableStrumentation.setDisable(false);

        ToEditedValueOne.setText("");
        ToEditedValueTwo.setText("");
        dateLabel.setVisible(true);
        dateAssign.setVisible(true);
        dipImpButton.setSelected(false);
        tableStrumentation.setDisable(false);
        tableSpace.setDisable(true);

    }

    @FXML
    void initialize() {
        inizializeTable();

        //Populate table Dipendenti
        ObservableList<EmployeeDto> listEmployees = FXCollections.observableArrayList();
        List<EmployeeDto> dto = employeeService.getAllEmployees();
        dto.forEach(listEmployees::add);
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

        dateAssign.setVisible(false);
        dateLabel.setVisible(false);
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
        tableStrumentation.setDisable(true);
        tableSpace.setDisable(true);

    }

    @FXML
    void gridAssignEmployee() {

        if (tableEmployee.getSelectionModel().getSelectedIndex() >= 0) {
            EmployeeDto employeeDto = tableEmployee.getItems().get(tableEmployee.getSelectionModel().getSelectedIndex());
            idLabel.setText(employeeDto.getIdDipedente());
            cfLabelToEdit.setText(employeeDto.getCodFiscale());
            tableEmployee.getSelectionModel().clearSelection();

        } else {
            if (!cfLabelToEdit.getText().equals("")) {
                idLabel.setText("");
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
            tableSpace.getSelectionModel().clearSelection();
            command = 1;
        } else if (dipStrumButton.isSelected()) {
            StrumentationDto strumentationDto = tableStrumentation.getItems().get(tableStrumentation.getSelectionModel().getSelectedIndex());
            ToEditedValueOne.setText(strumentationDto.getIdStrumentazione());
            ToEditedValueTwo.setText(strumentationDto.getDesStrumentazione());
            tableStrumentation.getSelectionModel().clearSelection();
            command = 2;
        }

    }

}
