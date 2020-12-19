package selenium_class.HeadlessBrowser;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class HeadlessPhantomJS {

    WebDriver driver;

    @Test
    public void  phantomTest() throws IOException {
        WebDriverManager.phantomjs().setup();
        driver= new PhantomJSDriver();
        driver.get("https://techtorialacademy.com");
        BrowserUtils.takeScreenshot(driver, "phantom");



    }

}
