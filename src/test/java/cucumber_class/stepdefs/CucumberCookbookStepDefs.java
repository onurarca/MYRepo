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

public class CucumberCookbookStepDefs {

    WebDriver driver = Driver.getDriver("chrome");


    @When("user navigates to {string} website")
    public void user_navigates_to_website(String string) {
        driver.get("https://google.com");
    }

    @Then("searches for {string} in google")
    public void searches_for_in_google(String string) {
        WebElement searchBar = driver.findElement(By.name("q"));
        Actions actions = new Actions(driver);
        actions.sendKeys(searchBar,"cucumber cookbook", Keys.ENTER).perform();
    }

    @Then("gets the number of links provided on the first and second pages.")
    public void gets_the_number_of_links_provided_on_the_first_and_second_pages() {
            List <String> temp = new ArrayList<>();
        List<WebElement> headers = driver.findElements(By.xpath("//h3[contains(@class,'LC20lb')]"));
        for (WebElement element:headers){
            temp.add(element.getText());
        }
        WebElement page2 = driver.findElement(By.xpath("//span[text()='Next']"));
        page2.click();

        List<WebElement> headers2= driver.findElements(By.xpath("//h3[contains(@class,'LC20lb')]"));
        for (WebElement element2:headers2){
            temp.add(element2.getText());
        }
        Assert.assertTrue(temp.size()>=20);



    }

}
