package frontend;


import api.dto.UserDto;
import ejb.service.LoginService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import sun.rmi.runtime.Log;

public class LoginController {

    @FXML
    private TextArea userText;

    @FXML
    private TextArea pswText;

    private LoginService loginService = new LoginService();


    @FXML
    void loginSub(ActionEvent event) {
        UserDto userDto = new UserDto();
        userDto.setUsername(userText.getText());
        userDto.setPassword(pswText.getText());
        if(loginService.loginService(userDto)){
            //Todo show HomePage
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
