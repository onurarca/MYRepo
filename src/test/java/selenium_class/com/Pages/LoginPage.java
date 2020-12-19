package selenium_class.com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver){

        PageFactory.initElements(driver, this);
    }



    @FindBy (name = "uid" )
    public WebElement userID;

    @FindBy (name = "password")
    public WebElement password;

    @FindBy (name = "btnLogin")
    public WebElement loginButton;



    public void setLogin(String userName,String password){
        userID.sendKeys(userName);
        this.password.sendKeys(password);
        loginButton.click();
    }




}
