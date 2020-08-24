package www.maxinhai.com.diaryfx.controller;

import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@FXMLController
public class LoginController implements Initializable {

    @FXML
    private javafx.scene.control.TextField usernameTextField;

    @FXML
    private javafx.scene.control.TextField passwordTextField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void login(ActionEvent actionEvent) throws IOException {
        System.out.println("登陆方法调用...");
        String usernameText = usernameTextField.getText();
        String passwordText = passwordTextField.getText();
        System.out.println("账号: " + usernameText);
        System.out.println("密码: " + passwordText);

        if(usernameText.equals("admin") && passwordText.equals("admin")) {
            BorderPane page = FXMLLoader.load(getClass().getResource("/fxml/dataList.fxml"));
            ((Button)actionEvent.getSource()).getScene().setRoot(page);
        }
    }

    @FXML
    public void toRegistered(ActionEvent actionEvent) throws IOException {
        BorderPane page = FXMLLoader.load(getClass().getResource("/fxml/registered.fxml"));
        ((Button)actionEvent.getSource()).getScene().setRoot(page);
    }

}
