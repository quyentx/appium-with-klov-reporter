package utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class CommonOperations {
    private String result = "";
    private InputStream inputStream;

    public static String reportTimeInReadableFormat(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date();
        return formatter.format(date);
    }

    public static String reportTimeInFileNameFormat(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmm");
        Date date = new Date();
        return formatter.format(date);
    }

    public String getPropValues(String key) throws IOException {
        try {
            Properties prop = new Properties();
            String propFileName = "config.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            result = prop.getProperty(key);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return result;
    }

    public static void scrollToElement(MobileElement element) throws InterruptedException {
        Dimension size = PlatformFactory.driver.manage().window().getSize();
        TouchAction action = new TouchAction(PlatformFactory.driver);
        int xOffset = element.getCenter().x;
        int yOffset = element.getCenter().y;
        int endX = size.width - xOffset + 100;
        System.out.println("Coordinate:" + xOffset + ":" + yOffset + "--"+ endX);
        System.out.println(size.width);
        System.out.println(size.height);
        action.press(PointOption.point(xOffset, yOffset)).moveTo(PointOption.point(endX, yOffset)).release().perform();
        Thread.sleep(1000);
        System.out.println("Slide to pay");
    }

    public static String captureScreenshot() throws IOException {
        String dest = "test-output/img/Screenshot"+ RandomGenerator.randNumb(9) +".jpg";
        File file  = ((TakesScreenshot)PlatformFactory.driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(dest));
        File target = new File(dest);
        FileUtils.copyFile(file, target);
        return dest;
    }

}
