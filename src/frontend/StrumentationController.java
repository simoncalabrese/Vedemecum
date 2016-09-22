package frontend;

import api.dto.StrumentationDto;
import ejb.service.StrumentationService;
import ejb.utils.Enumerators;
import frontend.Dispatcher.ViewDispatcher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;

/**
 * Created by user on 22/09/16.
 */
public class StrumentationController {
    StrumentationService strumentationService = new StrumentationService();
    ViewDispatcher dispatcher = ViewDispatcher.getDispatcher();


    @FXML
    private TableView<StrumentationDto> table;

    @FXML
    private TableColumn<StrumentationDto, String> idCol;

    @FXML
    private TableColumn<StrumentationDto, String> desCol;

    @FXML
    private TableColumn<StrumentationDto, String> modelCol;

    @FXML
    private TableColumn<StrumentationDto, String> marcCol;

    @FXML
    private TableColumn<StrumentationDto, String> totCol;

    @FXML
    private TableColumn<StrumentationDto, String> dtCol;

    @FXML
    private Label idLabel;

    @FXML
    private TextField desText;

    @FXML
    private TextField modelText;

    @FXML
    private TextField marcText;

    @FXML
    private TextField totText;

    @FXML
    private DatePicker date;

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
        idCol.setCellValueFactory(strumentation -> strumentation.getValue().idStrumentazioneProperty());
        desCol.setCellValueFactory(strumentation -> strumentation.getValue().desStrumentazioneProperty());
        modelCol.setCellValueFactory(strumentation -> strumentation.getValue().modelloStrumentazioneProperty());
        marcCol.setCellValueFactory(strumentation -> strumentation.getValue().marcaStrumentazioneProperty());
        totCol.setCellValueFactory(strumentation -> strumentation.getValue().pezziProperty());
        dtCol.setCellValueFactory(strumentation -> strumentation.getValue().dtAcquistoProperty());
        populateTable();
    }

    private void populateTable() {
        ObservableList<StrumentationDto> lists = FXCollections.observableArrayList();
        List<StrumentationDto> strumentationDto = strumentationService.getAllStrumentation();
        strumentationDto.forEach(lists::add);
        table.setItems(lists);
    }
}
