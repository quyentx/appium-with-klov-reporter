package appium.testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentKlovReporter;
import org.testng.annotations.*;
import utils.*;

import java.io.IOException;
import java.net.MalformedURLException;

import static utils.AvdHandler.startEmulator;

public class TestBase extends PlatformFactory{
    public static ExtentReports extentReports;

    @BeforeSuite
    public void setEnvironment() throws Exception {
        if(!AppiumHandler.checkIfServerIsRunnning()){
            AppiumHandler.startServer();
        } else {
            System.out.println("Appium Server already running");
        }
        startEmulator();
        MongoDBHandler.startMongoDB();
        KlovServerHandler.startKlovServer();
    }

    @BeforeClass
    public void setup () throws MalformedURLException, InterruptedException {
        PlatformFactory.getPlatform("android");
        ExtentKlovReporter klovReporter = new ExtentKlovReporter();
        klovReporter.initMongoDbConnection("localhost", 27017);
        klovReporter.setProjectName("APPIUM DEMO");
        klovReporter.setReportName("Appium Demo "+CommonOperations.reportTimeInReadableFormat());
        klovReporter.initKlovServerConnection("http://localhost");

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-output\\Appium Demo "+CommonOperations.reportTimeInFileNameFormat()+".html");

        //Want to configure klov using property file
        //klov.loadInitializationParams("klov.properties");
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter, klovReporter);
    }

    @AfterMethod
    public void afterMethod() throws IOException {
        driver.resetApp();
    }

    @AfterClass
    public void teardown(){
        extentReports.flush();
    }

    @AfterSuite
    public static void tearDown() {
        driver.quit();
//        stopEmulator();
    }

}
