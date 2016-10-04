package frontend;

import api.dto.EmployeeDto;
import api.dto.SpaceDto;
import api.dto.StrumentationDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.ArrayList;
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


    private static List<EmployeeDto> empDto = new ArrayList<>();
    private static List<StrumentationDto> strumDto = new ArrayList<>();
    private static List<SpaceDto> spDto = new ArrayList<>();

    static List<EmployeeDto> getEmpDto() {
        return empDto;
    }

    public static void setEmpDto(List<EmployeeDto> dto) {
        empDto = dto;
    }

    static List<StrumentationDto> getStrumDto() {
        return strumDto;
    }

    public static void setStrumDto(List<StrumentationDto> dto) {
        strumDto = dto;
    }

    static List<SpaceDto> getSpDto() {
        return spDto;
    }

    public static void setSpDto(List<SpaceDto> dto) {
        spDto = dto;
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
        empDto.stream()
                .filter(elem -> elem!=null)
                .forEach(emp::add);
        tableEmp.setItems(emp);

        ObservableList<StrumentationDto> strum = FXCollections.observableArrayList();
        strumDto.stream()
                .filter(elem -> elem!=null)
                .forEach(strum::add);
        tableStrum.setItems(strum);

        ObservableList<SpaceDto> space = FXCollections.observableArrayList();
        spDto.stream()
                .filter(elem -> elem!=null)
                .forEach(space::add);
        tableSpace.setItems(space);
    }
}

