package www.maxinhai.com.diaryfx.util;

import javafx.stage.Stage;

public class CacheUtils {

    private CacheUtils() {}

    private static Stage stage = null;

    public static void putStage(Stage mainStage) {
        if(null == mainStage) {
            throw new RuntimeException("main stage is not null!");
        }
        stage = mainStage;
    }

    public static Stage getStage() {
        if(null == stage) {
            throw new RuntimeException("main stage is null!");
        }
        return stage;
    }

}
