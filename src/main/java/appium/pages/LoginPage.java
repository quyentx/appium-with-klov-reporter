package appium.pages;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private MobileDriver<MobileElement> driver;

    public LoginPage(){
    }

    public LoginPage(MobileDriver<MobileElement> driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "input-email")
    @iOSBy(id = "")
    private MobileElement loginEmail;

    @AndroidFindBy(accessibility = "input-password")
    @iOSBy(id = "")
    private MobileElement loginPassword;

    @AndroidFindBy(accessibility = "button-LOGIN")
    @iOSBy(id = "")
    private MobileElement loginBtn;

    @AndroidBy(xpath = "*//android.widget.TextView[@resource-id='android:id/alertTitle'")
    @iOSBy()
    private MobileElement successAlertContent;

    public void inputEmail(String email) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(loginEmail));
        loginEmail.sendKeys(email);
        System.out.println("Input number");
    }

    public void inputPassword(String password) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(loginPassword));
        loginPassword.sendKeys(password);
        System.out.println("Input PIN");
    }

    public void clickLogin() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginBtn.click();
        System.out.println("Clicked");
    }

//    public String getAlertContent() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver,20);
//        wait.until(ExpectedConditions.visibilityOf(successAlertContent));
//        Thread.sleep(3000);
//        return successAlertContent.getText();
//    }
}
