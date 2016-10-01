package frontend;

import api.dto.AssociationDto;
import api.utils.Enumerators;
import ejb.service.AssociationEmployeeSpaceService;
import ejb.service.AssociationEmployeeStrumentationService;
import frontend.Dispatcher.ViewDispatcher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.List;

public class AssociationListViewController {


    private AssociationEmployeeSpaceService employeeSpaceService =
            new AssociationEmployeeSpaceService();
    private AssociationEmployeeStrumentationService employeeStrumentationService =
            new AssociationEmployeeStrumentationService();
    private final ViewDispatcher dispatcher = ViewDispatcher.getDispatcher();


    @FXML
    private TableView<AssociationDto> tableEmpSpace;

    @FXML
    private TableColumn<AssociationDto, String> idAssEmpImp;

    @FXML
    private TableColumn<AssociationDto, String> idEmpImp;

    @FXML
    private TableColumn<AssociationDto, String> idImp;


    @FXML
    private TableView<AssociationDto> tableEmpStrum;

    @FXML
    private TableColumn<AssociationDto, String> idAssEmpStrum;

    @FXML
    private TableColumn<AssociationDto, String> idEmpStrum;

    @FXML
    private TableColumn<AssociationDto, String> idStrum;

    @FXML
    private TableColumn<AssociationDto, String> date;

    private AssociationDto empSpaceDto;
    private AssociationDto empStrumentationDto;

    @FXML
    void tableSpaceClick() {
        empStrumentationDto = null;
        tableEmpStrum.getSelectionModel().clearSelection();
        empSpaceDto = tableEmpSpace.getItems().get(tableEmpSpace.getSelectionModel().getSelectedIndex());

    }

    @FXML
    void tableStrumentationClick() {
        empSpaceDto = null;
        tableEmpSpace.getSelectionModel().clearSelection();
        empStrumentationDto = tableEmpStrum.getItems().get(tableEmpStrum.getSelectionModel().getSelectedIndex());

    }


    @FXML
    void btnDelete(ActionEvent event) {
        if (empStrumentationDto != null || empSpaceDto != null) {
            if (empSpaceDto != null) {
                successOrFail(employeeSpaceService
                        .deleteAssociation(Integer
                                .valueOf(empSpaceDto.getIdAssociation())));
            } else {
                successOrFail(employeeStrumentationService
                        .deleteAssociation(Integer
                                .valueOf(empStrumentationDto.getIdAssociation())));
            }

        } else {
            dispatcher.alert(Enumerators.Alert.SELECTIONROW, null);
        }

    }

    private void successOrFail(Boolean operation) {
        if (operation) {
            populateTable();
        } else {
            dispatcher.alert(Enumerators.Alert.DELETE, null);
        }
    }


    @FXML
    void initialize() {
        idAssEmpImp.setCellValueFactory(p -> p.getValue().idAssociationProperty());
        idAssEmpStrum.setCellValueFactory(p -> p.getValue().idAssociationProperty());
        idEmpImp.setCellValueFactory(p -> p.getValue().idEmployeeProperty());
        idEmpStrum.setCellValueFactory(p -> p.getValue().idEmployeeProperty());
        idImp.setCellValueFactory(p -> p.getValue().idSpaceStrumentationProperty());
        idStrum.setCellValueFactory(p -> p.getValue().idSpaceStrumentationProperty());
        date.setCellValueFactory(p -> p.getValue().dateAssignProperty());


        populateTable();
    }

    private void populateTable() {

        //Employee Space Associatio
        ObservableList<AssociationDto> listEmpSpace = FXCollections.observableArrayList();
        List<AssociationDto> empspace = employeeSpaceService.getAllAssociation();
        empspace.forEach(listEmpSpace::add);
        tableEmpSpace.setItems(listEmpSpace);
        //Employee Strumentation Association
        ObservableList<AssociationDto> listEmployees = FXCollections.observableArrayList();
        List<AssociationDto> empstrum
                = employeeStrumentationService.getAllAssociation();
        empstrum.forEach(listEmployees::add);
        tableEmpStrum.setItems(listEmployees);
    }
}
