package selenium_class.com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomer {

    public NewCustomer(WebDriver driver){



        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[contains(text(), 'New Cus')]")
    public WebElement newCustomer;

    @FindBy(className = "heading3")
    public WebElement titleCheck;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement customerName;

    @FindBy(xpath = "//input[@value='f']")
    public WebElement female;

    @FindBy(xpath = "//input[@value='m']")
    public WebElement male;

    @FindBy(id = "dob")
    public WebElement dob;

    @FindBy(name = "addr")
    public WebElement address;

    @FindBy(name = "city")
    public WebElement city;

    @FindBy(name = "state")
    public WebElement state;

    @FindBy(name = "pinno")
    public WebElement pin;

    @FindBy(name = "telephoneno")
    public WebElement phone;

    @FindBy(name = "emailid")
    public WebElement email;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(name = "sub")
    public WebElement submitButton;

    ////////////


    @FindBy(xpath = "//td[contains(text(), 'Customer Na')]/following-sibling::td")
    public WebElement nameData;

    @FindBy(xpath = "//td[contains(text(), 'Gender')]/following-sibling::td")
    public WebElement genderData;

    @FindBy(xpath = "//td[contains(text(), 'Birt')]/following-sibling::td")
    public WebElement dobData;

    @FindBy(xpath = "//td[contains(text(), 'Add')]/following-sibling::td")
    public WebElement addressData;

    @FindBy(xpath = "//td[contains(text(), 'City')]/following-sibling::td")
    public WebElement cityData;

    @FindBy(xpath = "//td[contains(text(), 'Stat')]/following-sibling::td")
    public WebElement stateData;

    @FindBy(xpath = "//td[contains(text(), 'Pin')]/following-sibling::td")
    public WebElement pinData;

    @FindBy(xpath = "//td[contains(text(), 'Mob')]/following-sibling::td")
    public WebElement mobilNoData;

    @FindBy(xpath = "//td[contains(text(), 'Ema')]/following-sibling::td")
    public WebElement emailData;










}
