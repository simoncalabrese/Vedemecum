
package frontend;


import api.dto.SpaceDto;
import ejb.service.SpaceService;
import ejb.utils.Enumerators;
import frontend.Dispatcher.ViewDispatcher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.List;

public class SpaceController {
    SpaceService spaceService = new SpaceService();
    ViewDispatcher dispatcher = ViewDispatcher.getDispatcher();


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
        dispatcher.dispatch(Enumerators.viewsPath.HOMEPAGE.getPath());
    }

    @FXML
    void initialize() {
        idCol.setCellValueFactory(param -> param.getValue().idSpaceProperty());
        desCol.setCellValueFactory(param -> param.getValue().desSpaceProperty());
        addressCol.setCellValueFactory(param -> param.getValue().addressSpaceProperty());
        roomCol.setCellValueFactory(param -> param.getValue().amntRoomProperty());
        doorCol.setCellValueFactory(param -> param.getValue().amntDoorProperty());
        windowCol.setCellValueFactory(param -> param.getValue().amntWindowProperty());
        populateTable();

    }

    private void populateTable() {
        List<SpaceDto> spaceDto = spaceService.getAllSpace();
        ObservableList<SpaceDto> lists = FXCollections.observableArrayList();
        spaceDto.forEach(lists::add);
        table.setItems(lists);
    }


}