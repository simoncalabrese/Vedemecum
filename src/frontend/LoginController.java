package frontend;


import api.dto.UserDto;
import ejb.service.LoginService;
import ejb.utils.Enumerators;
import frontend.Dispatcher.ViewDispatcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.swing.text.View;


public class LoginController {

    @FXML
    private TextField userText;

    @FXML
    private PasswordField pswText;

    private LoginService loginService = new LoginService();


    @FXML
    void loginSub(ActionEvent event) {
        UserDto userDto = new UserDto();
        userDto.setUsername(!(userText.getText().equals(""))
                ? userText.getText().toUpperCase()
                : null);
        userDto.setPassword(!(pswText.getText().equals(""))
                ? pswText.getText().toUpperCase()
                : null);
        if(userDto.getUsername()!=null && userDto.getPassword()!=null) {
            if (loginService.loginService(userDto)) {
                ViewDispatcher.getDispatcher().dispatch(Enumerators.viewsPath.HOMEPAGE.getPath()); //Todo HomePage
            } else {
                ViewDispatcher.getDispatcher().alert(Enumerators.Alert.LOGINVALUES, null);
            }
        }else {
            ViewDispatcher.getDispatcher().alert(Enumerators.Alert.LOGINFIELDS, null);
        }
    }

    @FXML
    void signinSub(ActionEvent event) {
        UserDto userDto = new UserDto();
        userDto.setUsername(!(userText.getText().equals(""))
                ? userText.getText().toUpperCase()
                : null);
        userDto.setPassword(!(pswText.getText().equals(""))
                ? pswText.getText().toUpperCase()
                : null);
        if(userDto.getUsername()!=null && userDto.getPassword()!=null) {
            if (loginService.signinService(userDto)) {
                ViewDispatcher.getDispatcher().dispatch(Enumerators.viewsPath.HOMEPAGE.getPath()); //Todo HomePage
            } else {
                ViewDispatcher.getDispatcher().alert(Enumerators.Alert.SIGNINVALUES, null);
            }
        }else {
            ViewDispatcher.getDispatcher().alert(Enumerators.Alert.LOGINFIELDS, null);
        }
    }

    @FXML
    void initialize() {


    }
}
