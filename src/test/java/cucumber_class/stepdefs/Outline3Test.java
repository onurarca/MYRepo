package cucumber_class.stepdefs;

import Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class Outline3Test {
    WebDriver driver = Driver.getDriver("chrome");


    @Given("user navigated to demo.openmrs.org")
    public void user_navigated_to_demo_openmrs_org() {
        driver.get("https://demo.openmrs.org");

    }




    @When("user tries to login with {string}, {string},{string}")
    public void user_tries_to_login_with_admin(String username, String password, String loginType) {


    }
    @When("user gets error message {string}")
    public void user_gets_error_message(String string) {



    }



}
