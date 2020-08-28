package www.maxinhai.com.diaryfx.splash;

import de.felixroske.jfxsupport.SplashScreen;

/**
 * 类描述: 软件启动过度动画
 * @Author: 15735400536
 * @Date: 2020/8/28 17:36
 */
public class DiarySplash extends SplashScreen {

    @Override
    public boolean visible() {
        return true;
    }

    @Override
    public String getImagePath() {
        return "/image/1.png";
    }
}
