package utils;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class PlatformFactory {
    public static MobileDriver driver = null;
    /*
     * Factory method for getting platform
     */
    public static MobileDriver getPlatform(String platform) throws MalformedURLException {
        switch(platform){
            case "android":
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
                cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.wdiodemoapp");
                cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".MainActivity");
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
                break;
            case "iOS":
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone");
                capabilities.setCapability(IOSMobileCapabilityType.APPLICATION_NAME, "");
                capabilities.setCapability(IOSMobileCapabilityType.XCODE_SIGNING_ID, "");
                driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                break;
        }
        return driver;
    }
}
