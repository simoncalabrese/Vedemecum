package frontend;


import api.dto.UserDto;
import ejb.service.LoginService;
import ejb.utils.Enumerators;
import frontend.Dispatcher.ViewDispatcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class LoginController {

    @FXML
    private TextField userText;

    @FXML
    private PasswordField pswText;

    private LoginService loginService = new LoginService();


    @FXML
    void loginSub(ActionEvent event) {
        UserDto userDto = new UserDto();
        userDto.setUsername(userText.getText().toUpperCase());
        userDto.setPassword(pswText.getText().toUpperCase());
        if(loginService.loginService(userDto)){
            ViewDispatcher.getDispatcher().dispatch(Enumerators.viewsPath.HOMEPAGE.getPath()); //Todo HomePage
        }else{
            //Todo show error Dialog
        }
    }

    @FXML
    void signinSub(ActionEvent event){
        UserDto userDto = new UserDto();
        userDto.setUsername(userText.getText());
        userDto.setPassword(pswText.getText());
        loginService.signinService(userDto);
    }

    @FXML
    void initialize() {


    }
}
