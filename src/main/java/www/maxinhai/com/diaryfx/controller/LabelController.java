package www.maxinhai.com.diaryfx.controller;

import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import www.maxinhai.com.diaryfx.util.CacheUtils;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@FXMLController
public class LabelController implements Initializable {

    @FXML
    private MenuItem addDiary;

    @FXML
    private MenuItem addLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    /**
     * 功能描述: 跳转到写日记界面
     * @Return: void
     * @Author: 15735400536
     * @Date: 2020/8/28 15:26
     */
    @FXML
    public void toWriteDiary() throws IOException {
        BorderPane page = FXMLLoader.load(getClass().getResource("/fxml/writeDiary.fxml"));
        Stage stage = CacheUtils.getStage();
        stage.getScene().setRoot(page);
    }


    /**
     * 功能描述: 跳转到标签界面
     * @Return: void
     * @Author: 15735400536
     * @Date: 2020/8/28 15:26
     */
    @FXML
    public void toLabel() throws IOException {
        BorderPane page = FXMLLoader.load(getClass().getResource("/fxml/label.fxml"));
        Stage stage = CacheUtils.getStage();
        stage.getScene().setRoot(page);
    }

}
