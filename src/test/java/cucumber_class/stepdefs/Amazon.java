package cucumber_class.stepdefs;

import Utils.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Amazon {

    WebDriver driver = Driver.getDriver("chrome");

    @When("user navigates to web site {string}")
    public void user_navigates_to_web_site(String string) {
        driver.get("https:www.amazon.com");

    }

    @Then("user searches {string} on search bar")
    public void user_searches_on_search_bar(String string) {
        Actions actions = new Actions(driver);
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        actions.sendKeys(searchBox,"Iphone", Keys.ENTER).perform();


    }

    @Then("user validates the number of search results on web site")
    public void user_validates_the_number_of_search_results_on_web_site() {

        WebElement result = driver.findElement(By.xpath("//div[contains(@class,'a-sect')]//span[contains(text(), 'result')]"));
        String str = result.getText().substring(result.getText().indexOf("f")+1,result.getText().indexOf("r")-1);
        System.out.println("Result number is : " + str);

    }



}
