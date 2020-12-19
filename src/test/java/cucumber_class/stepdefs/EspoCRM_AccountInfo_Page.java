package cucumber_class.stepdefs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EspoCRM_AccountInfo_Page {

    public EspoCRM_AccountInfo_Page(WebDriver driver){

        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//div[@data-name='name']//div[@class='field']")
    public WebElement nameActual;

    @FindBy(xpath = "//a[@data-action='mailTo']//span")
    public WebElement emailActual;

    @FindBy(xpath = "//a[@data-action='dial']//span")
    public WebElement phoneActual;

    @FindBy(xpath = "//div[@data-name='type']//span[@class='text-default']")
    public WebElement typeActual;

    @FindBy(xpath = "//div[@data-name='industry']//span[@class='text-default']")
    public WebElement industryActual;


    @FindBy(id = "nav-menu-dropdown")
    public WebElement logOffMenu;

    @FindBy(xpath = "//a[@data-action='logout']")
    public WebElement logOutButton;

    public void logOff(){
        logOffMenu.click();
        logOutButton.click();
    }



}
