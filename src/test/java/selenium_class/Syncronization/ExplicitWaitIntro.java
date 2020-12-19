package selenium_class.Syncronization;

import Utils.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitIntro {

    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= Driver.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }


    @Test
    public void test1(){

        driver.get("https://google.com");
        WebDriverWait wait=new WebDriverWait(driver,10);

        wait.until(ExpectedConditions.titleIs("techtorial"));


    }
}
