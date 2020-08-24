package www.maxinhai.com.diaryfx;

import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import www.maxinhai.com.diaryfx.splash.DemoSplash;
import www.maxinhai.com.diaryfx.view.LoginView;

@SpringBootApplication
public class DiaryFxApplication extends AbstractJavaFxApplicationSupport {

    public static void main(String[] args) {
        launch(DiaryFxApplication.class, LoginView.class, new DemoSplash(), args);
    }

    @Override
    public void beforeInitialView(Stage stage, ConfigurableApplicationContext ctx) {
        stage.setTitle("心情日记");
        stage.setWidth(800);
        stage.setHeight(600);
    }
}
