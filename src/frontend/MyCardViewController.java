package frontend;

import api.dto.EmployeeDto;
import api.dto.SpaceDto;
import api.dto.StrumentationDto;
import ejb.service.CardService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class MyCardViewController {

    private CardService cardService = new CardService();

    @FXML
    private Label footerCard;

    @FXML
    private Label headerCard1;

    @FXML
    private ListView<EmployeeDto> employeeList;

    @FXML
    private ListView<StrumentationDto> strumentationList;

    @FXML
    private ListView<SpaceDto> spaceList;

    @FXML
    void initialize() {


    }
}
