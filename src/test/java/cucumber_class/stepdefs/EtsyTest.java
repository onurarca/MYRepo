package cucumber_class.stepdefs;

import Utils.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class EtsyTest {

    WebDriver driver = Driver.getDriver("chrome");

    @When("user navigate to {string}")
    public void user_navigate_to(String string) {
        driver.get("https://etsy.com");


    }

    @When("searches for {string}")
    public void searches_for(String string) {
        Actions actions = new Actions(driver);
        WebElement searchbar = driver.findElement(By.id("global-enhancements-search-query"));
        actions.sendKeys(searchbar,"antique Jeweleries",Keys.ENTER).perform();



    }

    @Then("confirms total prices are bigger than {int}")
    public void confirms_total_prices_are_bigger_than(Integer int1) {

        List<WebElement> prices = driver.findElements(By.className("currency-value"));
        List <String> price= new ArrayList<>();
        double i =0;
        for (WebElement p : prices){
            i=i+Double.parseDouble(p.getText().replace(",",""));

        }
        Assert.assertTrue(i>0);

    }


}
