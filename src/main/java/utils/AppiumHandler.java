package utils;

import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.ServerSocket;

public class AppiumHandler {

    private static AppiumDriverLocalService service;
    static int port = 4723;
    private static String address = "127.0.0.1";
    private static AppiumServiceBuilder builder;
    private static DesiredCapabilities cap;

    public static void startServer() {
        /*
        Set Capabilities
            1. Clear cache and settings
            2. Assign test device to run the upcoming tests
         */
        cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.NO_RESET, false);
//        cap.setCapability(MobileCapabilityType.UDID, "PLEGAR17A2617402");

        //Build the Appium service
        builder = new AppiumServiceBuilder();
        builder.withIPAddress(address);
        builder.usingPort(port);
        builder.withCapabilities(cap);
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");

        //Start the server with the builder
        service = AppiumDriverLocalService.buildService(builder);
        service.start();
    }

    public static boolean checkIfServerIsRunnning() {

        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        } catch (IOException e) {
            //If control comes here, then it means that the port is in use
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }
}
