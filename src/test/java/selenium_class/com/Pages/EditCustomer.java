package selenium_class.com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomer {

    public EditCustomer(WebDriver driver){

        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[contains(text(), 'Edit Cust')]")
    public WebElement editCustomer;

    @FindBy(name = "cusid")
    public WebElement customerIDEnter;

    @FindBy(name = "AccSubmit")
    public WebElement submitButn;

    @FindBy(name = "addr")
    public WebElement editAddress;

    @FindBy(name = "city")
    public WebElement editCity;

    @FindBy (name = "pinno")
    public WebElement editPin;

    @FindBy (name = "emailid")
    public WebElement editEmail;

    @FindBy(name = "telephoneno" )
    public WebElement editPhone;

    @FindBy(name = "sub")
    public WebElement editedSubmit;
}
