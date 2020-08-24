package www.maxinhai.com.diaryfx.controller;

import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

@FXMLController
public class RegisteredController implements Initializable {

    @FXML
    private javafx.scene.control.TextField usernameTextField;

    @FXML
    private javafx.scene.control.TextField passwordTextField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void registered(ActionEvent event) {
        System.out.println("注册方法调用...");
        String usernameText = usernameTextField.getText();
        String passwordText = passwordTextField.getText();
        System.out.println("账号: " + usernameText);
        System.out.println("密码: " + passwordText);
    }

}
