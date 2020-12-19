package cucumber_class.stepdefs;

import Utils.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Google {

    WebDriver driver = Driver.getDriver("chrome");


    @When("user navigates to {string}")
    public void user_navigates_to(String string) {
        driver.get("https://google.com");

    }

    @Then("user searches for {string}")
    public void user_searches_for(String string) {
        WebElement searchBar = driver.findElement(By.name("q"));
        Actions actions = new Actions(driver);
        actions.sendKeys(searchBar,"cucumber", Keys.ENTER).perform();


    }

    @Then("user validates the number of search results")
    public void user_validates_the_number_of_search_results() {
        WebElement number = driver.findElement(By.id("result-stats"));
        String str = number.getText().substring(number.getText().indexOf(" ")+1,number.getText().indexOf("r")-1);

        System.out.println(str);
    }



    @When("user enters {string} in search field")
    public void userEntersJavaBasicsInSearchField(String string) {

    }




    @Then("the result page will not have topics about {string}")
    public void teResultPageWillNotHaveTopicsAbout(String string) {

    }


}
