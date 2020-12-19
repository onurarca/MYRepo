package selenium_class.SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumMethodsTwo {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.testdiary.com/training/selenium/selenium-test-page/");

        WebElement saveButton = driver.findElement(By.id("demo"));
        System.out.println("Is save button enabled?");
        System.out.println(saveButton.isEnabled());
        System.out.println();

        WebElement java1 = driver.findElement(By.id("java1"));
        System.out.println("Is Java enabled?");
        System.out.println(java1.isEnabled());
        System.out.println();

        WebElement seleniumCheckBox = driver.findElement(By.id("seleniumbox"));
        System.out.println("Is Selenium selected?");
        System.out.println(seleniumCheckBox.isSelected());
        System.out.println("Select Selenium");
        seleniumCheckBox.click();
        System.out.println(seleniumCheckBox.isSelected());
        System.out.println();

        WebElement restAPICheckBox = driver.findElement(By.id("restapibox"));
        System.out.println("is rest api displayed on the page?");
        System.out.println(restAPICheckBox.isDisplayed());

    }
}
