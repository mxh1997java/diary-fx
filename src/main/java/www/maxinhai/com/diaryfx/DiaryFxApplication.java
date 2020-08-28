package www.maxinhai.com.diaryfx;

import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import javafx.stage.Stage;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import www.maxinhai.com.diaryfx.splash.DiarySplash;
import www.maxinhai.com.diaryfx.util.CacheUtils;
import www.maxinhai.com.diaryfx.view.LoginView;

@MapperScan("www.maxinhai.com.diaryfx")
@SpringBootApplication(scanBasePackages = "www.maxinhai.com.diaryfx")
public class DiaryFxApplication extends AbstractJavaFxApplicationSupport {

    public static void main(String[] args) {
        launch(DiaryFxApplication.class, LoginView.class, new DiarySplash(), args);
    }

    @Override
    public void beforeInitialView(Stage stage, ConfigurableApplicationContext ctx) {
        stage.setTitle("心情日记");
        stage.setWidth(800);
        stage.setHeight(600);
        CacheUtils.putStage(stage);
    }

    /**
     * 功能描述: 重启方法
     * @Return: void
     * @Author: 15735400536
     * @Date: 2020/8/28 18:03
     */
    public void relaunch() {
        try {
            getStage().close();
            this.stop();
            this.init();
            this.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("重启成功!");
    }

}
