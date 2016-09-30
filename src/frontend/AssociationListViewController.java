package frontend;

import api.dto.AssociationDto;
import ejb.service.AssociationEmployeeSpaceService;
import ejb.service.AssociationEmployeeStrumentationService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    private TableView<AssociationDto> tableEmpStrum;

    @FXML
    void btnDelete(ActionEvent event) {

    }


    @FXML
    void initialize() {


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
