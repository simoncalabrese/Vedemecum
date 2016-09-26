package frontend;

/**
 * Created by simon on 05/09/16.
 */

import api.utils.Enumerators;
import frontend.Dispatcher.ViewDispatcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class HomePageController {

    private ViewDispatcher dispatcher = ViewDispatcher.getDispatcher();

    @FXML
    private Label userText;

    @FXML
    void btnLogout() {
        dispatcher.dispatch(Enumerators.viewsPath.LOGIN.getPath());

    }

    @FXML
    void openCard() {

    }

    @FXML
    void openAssociation() {
        dispatcher.dispatch(Enumerators.viewsPath.ASSOCIATION.getPath());
    }

    @FXML
    void openEmployee() {
        dispatcher.dispatch(Enumerators.viewsPath.EMPLOYEE.getPath());

    }

    @FXML
    void openRole() {
        dispatcher.dispatch(Enumerators.viewsPath.ROLE.getPath());
    }

    @FXML
    void openSpace() {
        dispatcher.dispatch(Enumerators.viewsPath.SPACE.getPath());

    }

    @FXML
    void openStrumentation(ActionEvent event) {
        dispatcher.dispatch(Enumerators.viewsPath.STRUMENTATION.getPath());
    }

}

