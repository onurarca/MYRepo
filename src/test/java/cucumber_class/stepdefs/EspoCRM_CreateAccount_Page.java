package cucumber_class.stepdefs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class EspoCRM_CreateAccount_Page {

    public EspoCRM_CreateAccount_Page(WebDriver driver) {


        PageFactory.initElements(driver, this);
    }

    ///Input data and Expected Data
    @FindBy(xpath = "//input[@data-name='name']")
    public WebElement nameData;

    @FindBy(xpath = "//input[contains(@class, ' email-add')]")
    public WebElement emailData;

    @FindBy(xpath = "//input[contains(@class, ' phone')]")
    public WebElement phoneData;

    @FindBy(xpath = "//textarea[contains(@data-name,'billing')]")
    public WebElement streetData;

    @FindBy(xpath = "//div[contains(@data-name,'billing')]//input[contains(@data-name,'City')]")
    public WebElement cityData;

    @FindBy(xpath = "//div[contains(@data-name,'billing')]//input[contains(@data-name,'Sta')]")
    public WebElement stateData;

    @FindBy(xpath = "//div[contains(@data-name,'billing')]//input[contains(@data-name,'Post')]")
    public WebElement postalCodeData;

    @FindBy(xpath = "//div[contains(@data-name,'billing')]//input[contains(@data-name,'Count')]")
    public WebElement countryData;

    @FindBy(xpath = "//button[text()='Copy Billing']")
    public WebElement copyBillingButton;

    @FindBy(xpath = "//Select[@data-name='type']")
    public WebElement typeData;

    @FindBy(xpath = "//Select[@data-name='industry']")
    public WebElement industryData;

    @FindBy(xpath = "//button[@data-action='save']")
    public WebElement saveButton;


    public List<String> lisOfStringConverter(WebDriver driver,String xpath ){
        List<WebElement> elements = driver.findElements(By.xpath(xpath));
        List<String> elementsAsString = new ArrayList<>();

        for (WebElement element: elements){
            elementsAsString.add(element.getText());
        }
        return elementsAsString;
    }





}
