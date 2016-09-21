
package frontend;

import api.dto.EmployeeDto;
import api.dto.SpaceDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class SpaceController {

    @FXML
    private TableView<SpaceDto> table;
    @FXML
    private TableColumn<SpaceDto, String> idCol;
    @FXML
    private TableColumn<SpaceDto, String> desCol;
    @FXML
    private TableColumn<SpaceDto, String> addressCol;
    @FXML
    private TableColumn<SpaceDto, String> roomCol;
    @FXML
    private TableColumn<SpaceDto, String> doorCol;
    @FXML
    private TableColumn<SpaceDto, String> windowCol;

    @FXML
    void btnAdd() {

    }

    @FXML
    void btnDel() {

    }

    @FXML
    void btnEdit() {

    }

    @FXML
    void btnHome() {

    }

    @FXML
    void initialize() {

        ObservableList<SpaceDto> lists = FXCollections.observableArrayList();


    }


}