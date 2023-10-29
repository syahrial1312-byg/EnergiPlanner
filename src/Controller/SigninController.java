package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SigninController {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button buttonLogin,buttonRegister;

    public void loginOnAction(){
        validationUser();

    }

    public void validationUser(){
        try {

        }catch (Exception Io){

        }
    }

    public void registerOnAction(){

    }

}
