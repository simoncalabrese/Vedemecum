package frontend;

import api.dto.AssociationDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class AssociationListViewController {



    @FXML
    private TableView<AssociationDto> tableEmpSpace;

    @FXML
    private TableView<AssociationDto> tableEmpStrum;

    @FXML
    void btnDelete(ActionEvent event) {

    }

    @FXML
    void initialize() {

    }
}
