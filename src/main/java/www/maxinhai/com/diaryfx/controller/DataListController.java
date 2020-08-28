package www.maxinhai.com.diaryfx.controller;

import de.felixroske.jfxsupport.FXMLController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import www.maxinhai.com.diaryfx.entity.UserInfo;
import www.maxinhai.com.diaryfx.util.CacheUtils;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

@FXMLController
public class DataListController implements Initializable {

    @FXML
    private TextField nameTextFiled;

    @FXML
    private TextField descTextFiled;

    @FXML
    private DatePicker startTextFiled;

    @FXML
    private DatePicker endTextFiled;

    @FXML
    private TableView<UserInfo> tableView;

    @FXML
    private Button reset;

    @FXML
    private Button query;

    @FXML
    private MenuItem addDiary;

    @FXML
    private MenuItem addLabel;

    /**
     * 功能描述: 系统加载时绑定事件
     * @Param: [location, resources]
     * @Return: void
     * @Author: 15735400536
     * @Date: 2020/8/24 18:22
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        query.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                query();
            }
        });
        reset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                reset();
            }
        });

        TableColumn idCol = new TableColumn<UserInfo, String>("userId");
        idCol.setMinWidth(100);
        idCol.setCellValueFactory(new PropertyValueFactory<UserInfo, String>("userId"));

        TableColumn nameCol = new TableColumn<UserInfo, String>("name");
        nameCol.setMinWidth(100);
        nameCol.setCellValueFactory(new PropertyValueFactory<UserInfo, String>("name"));
        TableColumn sexCol = new TableColumn<UserInfo, String>("sex");
        sexCol.setMinWidth(100);
        sexCol.setCellValueFactory(new PropertyValueFactory<UserInfo, String>("sex"));
        TableColumn ageCol = new TableColumn<UserInfo, Integer>("age");
        ageCol.setMinWidth(100);
        ageCol.setCellValueFactory(new PropertyValueFactory<UserInfo, Integer>("age"));
        TableColumn addressCol = new TableColumn<UserInfo, String>("address");
        addressCol.setMinWidth(200);
        addressCol.setCellValueFactory(new PropertyValueFactory<UserInfo, String>("address"));
        TableColumn timeCol = new TableColumn<UserInfo, String>("time");
        timeCol.setMinWidth(150);
        timeCol.setCellValueFactory(new PropertyValueFactory<UserInfo, String>("time"));
        TableColumn operateCol = new TableColumn<UserInfo, String>("operate");
        operateCol.setMinWidth(150);
        tableView.getColumns().addAll(idCol, nameCol, ageCol, sexCol, addressCol, timeCol, operateCol);

//        addDiary.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                try {
//                    toWriteDiary(event);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        addLabel.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                try {
//                    toLabel(event);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
    }


    /**
     * 功能描述: 查询数据
     * @Return: void
     * @Author: 15735400536
     * @Date: 2020/8/24 18:23
     */
    @FXML
    public void query() {
        String name = nameTextFiled.getText();
        String desc = descTextFiled.getText();
        String startTime = startTextFiled.getValue().toString();
        String endTime = endTextFiled.getValue().toString();

        System.out.println("name: " + name + " desc: " + desc);
        System.out.println("time: " + startTime + "=>" + endTime);

        //加载数据
        loadData(name);
    }


    /**
     * 功能描述: 重置组件数据
     * @Return: void
     * @Author: 15735400536
     * @Date: 2020/8/24 18:23
     */
    @FXML
    public void reset() {
        nameTextFiled.setText("");
        descTextFiled.setText("");
        startTextFiled.setValue(null);
        endTextFiled.setValue(null);
    }

    public void loadData(String name) {
        ObservableList<UserInfo> userInfoList = FXCollections.observableArrayList();
        List<UserInfo> userInfos = new ArrayList<>();
        for(int i=0; i<10; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setName("MaXinHai" + i);
            userInfo.setAge(i);
            userInfo.setSex("男");
            userInfo.setAddress("山西省晋城市阳城县北留镇");
            userInfo.setUserId(100L);
            userInfo.setTime(LocalDate.now().toString());
            userInfos.add(userInfo);
        }

        if(null != name) {
            userInfos = userInfos.stream().filter(userInfo -> {
                if(name.equals(userInfo.getName())) {
                    return true;
                } else {
                    return false;
                }
            }).collect(Collectors.toList());
        }
        userInfoList.addAll(userInfos);
        tableView.setEditable(true);
        tableView.setItems(userInfoList);
    }


    /**
     * 功能描述: 跳转到写日记界面
     * @Param: [actionEvent]
     * @Return: void
     * @Author: 15735400536
     * @Date: 2020/8/28 15:26
     */
    @FXML
    public void toWriteDiary(ActionEvent actionEvent) throws IOException {
        BorderPane page = FXMLLoader.load(getClass().getResource("/fxml/writeDiary.fxml"));
        Stage stage = CacheUtils.getStage();
        stage.getScene().setRoot(page);
    }


    /**
     * 功能描述: 跳转到标签界面
     * @Param: [actionEvent]
     * @Return: void
     * @Author: 15735400536
     * @Date: 2020/8/28 15:26
     */
    @FXML
    public void toLabel(ActionEvent actionEvent) throws IOException {
        BorderPane page = FXMLLoader.load(getClass().getResource("/fxml/label.fxml"));
        Stage stage = CacheUtils.getStage();
        stage.getScene().setRoot(page);
    }

}