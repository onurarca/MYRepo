package selenium_class.HeadlessBrowser;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class HeadlessChrome {


    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
       options.addArguments("--headless");
       // options.addArguments("--incognito");// --> opens in incognito mode
        driver = new ChromeDriver(options);

    }



    @Test
    public void headlessChromeTest()throws IOException {

        driver.get("https://techtorialacademy.com");
        BrowserUtils.takeScreenshot(driver, "headlessChrome");



    }



}
