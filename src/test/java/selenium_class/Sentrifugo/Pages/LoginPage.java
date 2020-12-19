package selenium_class.Sentrifugo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver){
        //initElements method will initialize the WebElements
        //this keyword refers the class itself

        PageFactory.initElements(driver, this);

    }

    //We will be using FindBy annotation to store the web elements inside this class
    @FindBy(id = "username")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "loginsubmit")
    public WebElement logInButton;

    @FindBy(xpath = "//input[@id='password']/following-sibling::div")
    public WebElement errorMessage;

    public void login(String username, String Password){
       userName.sendKeys(username);
       password.sendKeys(Password);
       logInButton.click();


    }

}
