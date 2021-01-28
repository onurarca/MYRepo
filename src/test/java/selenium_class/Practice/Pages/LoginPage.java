package selenium_class.Practice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Homepage - Front-End')]")
    public WebElement frontEnd;

    @FindBy(xpath = "//a[.='Login']/../../..")
    public WebElement myAccount;

    @FindBy(xpath = "//a[.='Login']")
    public WebElement loginDirect;

    @FindBy(xpath = "//input[@type='email']")
    public WebElement email;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement password;

    @FindBy(xpath = "//button[.='Login']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[contains(@class,'go-text')]//span")
    public WebElement bookingInfo;

}
