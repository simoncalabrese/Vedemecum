package frontend;

import api.dto.CardDto;
import ejb.service.CardService;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CardSelectDialogController {

    private CardService cardService = new CardService();

    @FXML
    private TableView<CardDto> tableCard;

    @FXML
    private TableColumn<CardDto, String> idCard;

    @FXML
    private TableColumn<CardDto, String> idEmpList;

    @FXML
    private TableColumn<CardDto, String> idSpaceList;

    @FXML
    private TableColumn<CardDto, String> idStrumList;

    @FXML
    void btnDetails(ActionEvent event) {

    }

    @FXML
    void initialize() {
        idCard.setCellValueFactory(elem -> elem.getValue().idCardProperty());
        idEmpList.setCellValueFactory(elem -> new SimpleStringProperty(
                elem.getValue()
                        .getEmployeeDtos()
                        .stream()
                        .filter(e -> e != null)
                        .map(Object::toString)
                        .reduce(String::concat).orElse(null)));
        idSpaceList.setCellValueFactory(elem -> new SimpleStringProperty(
                elem.getValue()
                        .getSpaceDtos()
                        .stream()
                        .filter(e -> e != null)
                        .map(Object::toString)
                        .reduce(String::concat).orElse(null)));
        idStrumList.setCellValueFactory(elem -> new SimpleStringProperty(
                elem.getValue()
                .getStrumentationDtos()
                .stream()
                .filter(e -> e!= null)
                .map(Object::toString)
                .reduce(String::concat).orElse(null)));
        populateTable();

    }

    private void populateTable() {
        ObservableList<CardDto> list = FXCollections.observableArrayList();
        cardService.getAllCards().forEach(list::add);
        tableCard.setItems(list);
    }
}