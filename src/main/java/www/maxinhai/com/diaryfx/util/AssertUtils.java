package www.maxinhai.com.diaryfx.util;

import org.springframework.stereotype.Component;

/**
 * 断言
 */
@Component
public class AssertUtils {

    public static void assertTrue(boolean flag, String message) throws RuntimeException {
        if(flag) {
            throw new RuntimeException(message);
        }
    }

    public static void assertFalse(boolean flag, String message) throws RuntimeException {
        if(!flag) {
            throw new RuntimeException(message);
        }
    }

}
