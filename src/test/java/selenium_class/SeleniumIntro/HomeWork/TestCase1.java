package selenium_class.SeleniumIntro.HomeWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase1 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("");

    }
}
