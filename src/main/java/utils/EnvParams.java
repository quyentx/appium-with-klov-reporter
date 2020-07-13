package utils;

import java.io.IOException;

public class EnvParams {
    private static CommonOperations commonOps = new CommonOperations();
    private static String DEFAULT_EMAIL;
    private static String DEFAULT_PASS;

    public static String getDefaultPass() {
        try {
            DEFAULT_PASS = commonOps.getPropValues("defaultPass");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return DEFAULT_PASS;
    }

    public static String getDefaultEmail() {
        try {
            DEFAULT_EMAIL = commonOps.getPropValues("defaultEmail");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return DEFAULT_EMAIL;
    }
}
