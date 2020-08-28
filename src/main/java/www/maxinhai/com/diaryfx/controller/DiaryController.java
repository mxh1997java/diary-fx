package www.maxinhai.com.diaryfx.controller;

import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import www.maxinhai.com.diaryfx.entity.Diary;
import www.maxinhai.com.diaryfx.mapper.DiaryMapper;
import www.maxinhai.com.diaryfx.util.CacheUtils;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@FXMLController
public class DiaryController implements Initializable {

    @Autowired
    public DiaryMapper diaryMapper;

    @FXML
    private TextField titleTextFile;

    @FXML
    private TextField tagTextFile;

    @FXML
    private TextArea contentTextArea;

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

    @FXML
    public void addDiary() throws RuntimeException {
        Diary diary = new Diary();
        diary.setTitle(titleTextFile.getText());
        diary.setContent("1111");
        diary.setName("aaaa");
        diary.setAuthor("admin");
        diary.setAuthor_id("1");
        System.out.println("diaryMapper: " + diaryMapper);
        diaryMapper.addDiary(diary);
    }

}
