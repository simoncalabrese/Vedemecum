package frontend;

import java.util.List;

import api.dto.EmployeeDto;
import api.dto.SpaceDto;
import api.dto.StrumentationDto;
import api.utils.Enumerators;
import ejb.service.EmployeeService;
import ejb.service.SpaceService;
import ejb.service.StrumentationService;
import frontend.Dispatcher.ViewDispatcher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class CardController {


    private EmployeeService employeeService = new EmployeeService();
    private SpaceService spaceService = new SpaceService();
    StrumentationService strumentationService = new StrumentationService();
    private final ViewDispatcher dispatcher = ViewDispatcher.getDispatcher();

    List<EmployeeDto> employeeDto;
    List<StrumentationDto> strumentationDto;
    List<SpaceDto> spaceDto;


    public List<EmployeeDto> getEmployeeDto() {
        return employeeDto;
    }

    public List<StrumentationDto> getStrumentationDto() {
        return strumentationDto;
    }

    public List<SpaceDto> getSpaceDto() {
        return spaceDto;
    }

    @FXML
    private TextArea headerText;

    @FXML
    private TextArea footerText;

    @FXML
    private TableView<EmployeeDto> tableEmp;

    @FXML
    private TableColumn<EmployeeDto, String> idEmp;

    @FXML
    private TableColumn<EmployeeDto, String> surnameEmp;

    @FXML
    private TableColumn<EmployeeDto, String> nameEmp;

    @FXML
    private TableView<StrumentationDto> tableStrum;

    @FXML
    private TableColumn<StrumentationDto, String> idStrum;

    @FXML
    private TableColumn<StrumentationDto, String> prodStrum;

    @FXML
    private TableColumn<StrumentationDto, String> modelStrum;

    @FXML
    private TableView<SpaceDto> tableSpace;

    @FXML
    private TableColumn<SpaceDto, String> idSpace;

    @FXML
    private TableColumn<SpaceDto, String> desSpace;


    @FXML
    void btnHome() {
        dispatcher.dispatch(Enumerators.viewsPath.HOMEPAGE.getPath());

    }

    @FXML
    void btnInsert() {

    }

    @FXML
    void btnView() {

    }

    @FXML
    void btnShow() {
        strumentationDto = tableStrum.getSelectionModel().getSelectedItems();
        employeeDto = tableEmp.getSelectionModel().getSelectedItems();
        spaceDto = tableSpace.getSelectionModel().getSelectedItems();
        dispatcher.dialog(Enumerators.viewsPath.CARDDIALOGSELECTED.getPath());

    }


    @FXML
    void employeeAssign() {


    }


    @FXML
    void spaceAssign() {



    }

    @FXML
    void strumentationAssign() {



    }

    @FXML
    void initialize() {
        idEmp.setCellValueFactory(employee -> employee.getValue().idDipedenteProperty());
        nameEmp.setCellValueFactory(employee -> employee.getValue().nomeDipendenteProperty());
        surnameEmp.setCellValueFactory(employee -> employee.getValue().cognomeDipendenteProperty());
        idStrum.setCellValueFactory(strumentation -> strumentation.getValue().idStrumentazioneProperty());
        modelStrum.setCellValueFactory(strumentation -> strumentation.getValue().modelloStrumentazioneProperty());
        prodStrum.setCellValueFactory(strumentation -> strumentation.getValue().marcaStrumentazioneProperty());
        idSpace.setCellValueFactory(param -> param.getValue().idSpaceProperty());
        desSpace.setCellValueFactory(param -> param.getValue().desSpaceProperty());
        tableSpace.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tableStrum.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tableEmp.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        populateTables();
    }

    private void populateTables() {
        ObservableList<EmployeeDto> emp = FXCollections.observableArrayList();
        List<EmployeeDto> roleDtos = employeeService.getAllEmployees();
        roleDtos.forEach(emp::add);
        tableEmp.setItems(emp);

        ObservableList<StrumentationDto> strum = FXCollections.observableArrayList();
        List<StrumentationDto> strumentationDto = strumentationService.getAllStrumentation();
        strumentationDto.forEach(strum::add);
        tableStrum.setItems(strum);

        List<SpaceDto> spaceDto = spaceService.getAllSpace();
        ObservableList<SpaceDto> space = FXCollections.observableArrayList();
        spaceDto.forEach(space::add);
        tableSpace.setItems(space);
    }
}
