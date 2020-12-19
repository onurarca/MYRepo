package cucumber_class.stepdefs;

import Utils.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.time.Duration;

public class TechtorialStepDefs {


    WebDriver driver = Driver.getDriver("chrome");

    @When("user navigates to Techtorial academy home page")
    public void user_navigates_to_techtorial_academy_home_page() {
        System.out.println("User navigates to Techtorial academy home page");
        driver.get("https://techtorialacademy.com");


    }

    @When("user uses {string} as username and {string} as password")
    public void user_uses_as_username_and_as_password(String string, String string2) {
        System.out.println("User tries to log in");

        WebElement studentLogin = driver.findElement(By.xpath("//div[@class='navigation hidden-xs']//a[@data-toggle='modal']"));
        studentLogin.click();

       // WebDriverWait wait = new WebDriverWait(driver,10);
       // wait.until(ExpectedConditions.presenceOfElementLocated(By.name("signup[signup_email]")));

        Wait <WebDriver> fluentWait = new FluentWait(driver)
                .pollingEvery(Duration.ofSeconds(2))
                .withTimeout(Duration.ofSeconds(10))
                .ignoring(ElementNotInteractableException.class);

        WebElement emailField = fluentWait.until(myDriver -> myDriver.findElement(By.name("signup[signup_email]")));

       // WebElement emailField = driver.findElement(By.name("signup[signup_email]"));
        emailField.sendKeys("admin");

        WebElement password = driver.findElement(By.name("signup[signup_password]"));
        password.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By.id("LoginSubmit"));
        loginButton.click();



    }

    @Then("user logged in")
    public void user_logged_in() {
        System.out.println("User was able to log in");

       WebElement error = driver.findElement(By.xpath("//*[@class='toast toast-error']"));
       Assert.assertTrue(error.isDisplayed());
        Assert.assertEquals(error.getText(),"Error");

    }


}
