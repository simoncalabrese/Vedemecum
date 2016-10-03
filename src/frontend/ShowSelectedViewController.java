package frontend;

import api.dto.EmployeeDto;
import api.dto.SpaceDto;
import api.dto.StrumentationDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.List;


public class ShowSelectedViewController{

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
    private TableColumn<SpaceDto,String> desSpace;


    private List<EmployeeDto> empDto;
    private List<StrumentationDto> strumDto;
    private List<SpaceDto> spDto;

    public List<EmployeeDto> getEmpDto() {
        return empDto;
    }

    public void setEmpDto(List<EmployeeDto> empDto) {
        this.empDto = empDto;
    }

    public List<StrumentationDto> getStrumDto() {
        return strumDto;
    }

    public void setStrumDto(List<StrumentationDto> strumDto) {
        this.strumDto = strumDto;
    }

    public List<SpaceDto> getSpDto() {
        return spDto;
    }

    public void setSpDto(List<SpaceDto> spDto) {
        this.spDto = spDto;
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
        populateTable();

    }

    private void populateTable() {

        ObservableList<EmployeeDto> emp = FXCollections.observableArrayList();
        getEmpDto().forEach(emp::add);
        tableEmp.setItems(emp);

        ObservableList<StrumentationDto> strum = FXCollections.observableArrayList();
        getStrumDto().forEach(strum::add);
        tableStrum.setItems(strum);

        ObservableList<SpaceDto> space = FXCollections.observableArrayList();
        getSpDto().forEach(space::add);
        tableSpace.setItems(space);
    }
}

