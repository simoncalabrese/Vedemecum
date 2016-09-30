package frontend;

import api.dto.AssociationDto;
import ejb.service.AssociationEmployeeSpaceService;
import ejb.service.AssociationEmployeeStrumentationService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.util.List;

public class AssociationListViewController {


    private AssociationEmployeeSpaceService employeeSpaceService =
            new AssociationEmployeeSpaceService();
    private AssociationEmployeeStrumentationService employeeStrumentationService =
            new AssociationEmployeeStrumentationService();


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


    @FXML
    void btnDelete(ActionEvent event) {

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
