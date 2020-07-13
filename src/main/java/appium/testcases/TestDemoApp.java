package appium.testcases;

import appium.pages.HomePage;
import appium.pages.LoginPage;
import org.testng.annotations.Test;
import utils.EnvParams;

public class TestDemoApp extends TestBase{

    @Test
    public void loginSuccess() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        System.out.println("App is running!");
        LoginPage login = new LoginPage(driver);
        homePage.openLoginForm();
        login.inputEmail(EnvParams.getDefaultEmail());
        login.inputPassword(EnvParams.getDefaultPass());
        login.clickLogin();
//        Assert.assertEquals(login.getAlertContent(), "Success");
    }
}