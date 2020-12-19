package cucumber_class.stepdefs;

import Utils.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class EspoCRM_StefDefs {

    WebDriver driver = Driver.getDriver("chrome");
    EspoCRM_CreateAccount_Page espoCRM_createAccount_page = new EspoCRM_CreateAccount_Page(driver);
    EspoCRM_AccountInfo_Page espoCRM_accountInfo_page = new EspoCRM_AccountInfo_Page(driver);


    @Given("the user navigate the {string}")
    public void the_user_navigate_the(String string) {

        driver.navigate().to("https://demo.espocrm.com/?");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement loginBtn = driver.findElement(By.id("btn-login"));
        loginBtn.click();
    }


    @When("the user open the home page")
    public void the_user_open_the_home_page() {

    }

    @Then("the user should see the function names")
    public void the_user_should_see_the_function_names(io.cucumber.datatable.DataTable dataTable) {

        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        List<WebElement> actualElements = driver.findElements(By.xpath("//li[contains(@class,'not-in')]"));
        List<String> actualData = new ArrayList<>();
        for (WebElement data : actualElements) {
            actualData.add(data.getText());

        }
        List<String> mapKeys = new ArrayList<>();

        for (String key : dataMap.keySet()) {
            mapKeys.add(key);
        }
        for (int i = 0; i < actualData.size(); i++) {
            Assert.assertEquals(actualData.get(i), mapKeys.get(i));
        }


    }


    @When("the user open the Accounts")
    public void the_user_open_the_accounts() {
        WebElement accounts = driver.findElement(By.xpath("//li//a//span[text()='Accounts']"));
        accounts.click();

    }

    @Then("the user clicks the Create Account button")
    public void the_user_clicks_the_create_account_button() {
        WebElement createAccount = driver.findElement(By.xpath("//a[@data-name='create']"));
        createAccount.click();

    }

    @Then("the user create 4 new account with {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void the_user_create_new_account_with(String name, String email, String phone, String street, String city, String state, String zip, String country, String type, String industry) {

        String window1 = driver.getWindowHandle();
        System.out.println(window1);
        try {

            espoCRM_createAccount_page.nameData.sendKeys(name);
            espoCRM_createAccount_page.emailData.sendKeys(email);
            espoCRM_createAccount_page.phoneData.sendKeys(phone);
            espoCRM_createAccount_page.streetData.sendKeys(street);
            espoCRM_createAccount_page.cityData.sendKeys(city);
            espoCRM_createAccount_page.stateData.sendKeys(state);
            espoCRM_createAccount_page.postalCodeData.sendKeys(zip);
            espoCRM_createAccount_page.countryData.sendKeys(country);
            Select select = new Select(espoCRM_createAccount_page.typeData);
            select.selectByVisibleText(type);
            select = new Select(espoCRM_createAccount_page.industryData);
            select.selectByVisibleText(industry);
            espoCRM_createAccount_page.saveButton.click();

            Thread.sleep(5000);


        } catch (Exception e) {

        }


    }


    @Then("the user validate the new users is created  with {string}, {string}, {string}, {string}, {string}")
    public void the_user_validate_the_new_users_is_created_with(String name, String email, String phone, String type, String industry) {

        String window2 = driver.getWindowHandle();
        System.out.println(window2);

        try {


            Assert.assertEquals(espoCRM_accountInfo_page.nameActual.getText(), name);
            Assert.assertEquals(espoCRM_accountInfo_page.emailActual.getText(), email);
            Assert.assertEquals(espoCRM_accountInfo_page.phoneActual.getText(), phone);
            Assert.assertEquals(espoCRM_accountInfo_page.typeActual.getText(), type);
            Assert.assertEquals(espoCRM_accountInfo_page.industryActual.getText(), industry);
            espoCRM_accountInfo_page.logOff();


        } catch (Exception e) {

        }


    }


    @When("user clicks the hamburger button")
    public void user_clicks_the_hamburger_button() {

    }


    @Then("user click on the treedor {string} at the end")
    public void user_click_on_the_treedor_at_the_end(String string) {

        WebElement threeDot = driver.findElement(By.xpath("//span[contains(@class, 'more-icon')]"));
        threeDot.click();


    }

    @Then("user click the users")
    public void user_click_the_users() {

        WebElement users = driver.findElement(By.xpath("//span[text()='Users']"));
        users.click();

    }

    @Then("the user should see given names and emails")
    public void the_user_should_see_given_names_and_emails(DataTable dataTable) {

        List<String> names = espoCRM_createAccount_page.lisOfStringConverter(driver, "//td[@data-name='name']");

        List<String> emails = espoCRM_createAccount_page.lisOfStringConverter(driver, "//td[@data-name='emailAddress']");

        Map<String,String> dataMap = dataTable.asMap(String.class,String.class);

        List<String> mapKeys =new ArrayList<>();
        List<String> mapValues = new ArrayList<>();
        for (Map.Entry<String,String> entry: dataMap.entrySet()){
            mapKeys.add(entry.getKey());
            mapValues.add(entry.getValue());
        }

        Assert.assertEquals(mapKeys,names);
        Assert.assertEquals(mapValues,emails);
    }


}
