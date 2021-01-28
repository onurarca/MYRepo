package selenium_class.Practice.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selenium_class.Practice.Pages.LoginPage;
import selenium_class.Practice.Practice_Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class LoginTests extends Practice_Utils {

    LoginPage loginPage;

    @BeforeClass
    public void setup() {
        setupDriver("chrome");
        driver.get("https://phptravels.com/demo");
        loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @Test
    public void test1() {



        loginPage.frontEnd.click();
        loginPage.myAccount.click();
        loginPage.loginDirect.click();
        String emailAdd = "user@phptravels.com";
        String passwordAdd = "demouser";
        Set<String> windows = driver.getWindowHandles();
        System.out.println(windows);
        String currentID = driver.getWindowHandle();
            BreakFor:for (String window : windows) {
              if (window.equals(currentID)){
                    driver.switchTo().window(window);
                }


            loginPage.email.sendKeys(emailAdd);
            loginPage.password.sendKeys(passwordAdd);
            loginPage.loginButton.click();
            List<WebElement> elements = new ArrayList<>();
            elements.add(loginPage.bookingInfo);
            System.out.println(elements);

        }


    }
}