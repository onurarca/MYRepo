package selenium_class.SelectIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ScreenShot {

    @Test
    public void test1() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.techtorialacademy.com/");
        File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        long timestamp = System.currentTimeMillis();
        File destinationFolder = new File("src/test/java/selenium_class.ScreenShots/"+timestamp+".png");
        FileUtils.copyFile(screenShot,destinationFolder);
    }


}
