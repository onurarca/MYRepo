package selenium_class.TestNGAnnotations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ParallelExecution2 {


    @Test
    @Parameters("Url")
public void nagigaToURL(String myFavURL){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://"+myFavURL+".com");
        Assert.assertTrue(driver.getCurrentUrl().contains(myFavURL));





    }
}
