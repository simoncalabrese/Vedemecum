package frontend;

/**
 * Created by simon on 05/09/16.
 */

import ejb.utils.Enumerators;
import frontend.Dispatcher.ViewDispatcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class HomePageController {

    private ViewDispatcher dispatcher = ViewDispatcher.getDispatcher();

    @FXML
    private Label userText;

    @FXML
    void btnLogout(ActionEvent event) {
        dispatcher.dispatch(Enumerators.viewsPath.LOGIN.getPath());

    }

    @FXML
    void openCard(ActionEvent event) {

    }

    @FXML
    void openEmployee(ActionEvent event) {
        dispatcher.dispatch(Enumerators.viewsPath.EMPLOYEE.getPath());

    }

    @FXML
    void openRole(ActionEvent event) {
        dispatcher.dispatch(Enumerators.viewsPath.ROLE.getPath());
    }

    @FXML
    void openSpace(ActionEvent event) {
        dispatcher.dispatch(Enumerators.viewsPath.SPACE.getPath());

    }

    @FXML
    void openStrumentation(ActionEvent event) {

    }

}

