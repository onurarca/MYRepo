package selenium_class.SeleniumIntro.HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork_1 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("file:///C:/Users/Onur/Desktop/Techtorial%20(2).html");

        //Home Button

        WebElement homeButton = driver.findElement(By.xpath("//a[contains(@href, 'techtorial')]"));
        System.out.println(homeButton.getText());
        System.out.println();

        //Java Button

        WebElement javaButton = driver.findElement(By.xpath("//a[contains(@href, 'oracle.com/java')]"));
        System.out.println(javaButton.getText());
        System.out.println();

        //Selenium Button

        WebElement seleniumButton = driver.findElement(By.xpath("//a[starts-with(@href, 'https://www.se')]"));
        System.out.println(seleniumButton.getText());
        System.out.println();

        //Cucumber Button

        WebElement cucumberButton = driver.findElement(By.xpath("//a[contains(@href, 'cucum')]"));
        System.out.println(cucumberButton.getText());
        System.out.println();

        //TestNG Button

        WebElement testNGButton = driver.findElement(By.xpath("//a[contains(@href, 'org/doc/')]"));
        System.out.println(testNGButton.getText());
        System.out.println();

        //Rest Api Button

        WebElement restApiButton = driver.findElement(By.xpath("//a[starts-with(@href, 'http://')]"));
        System.out.println(restApiButton.getText());
        System.out.println();

        //SQL Button

        WebElement sqlButton = driver.findElement(By.xpath("//a[contains(@href, 'sql.html')]"));
        System.out.println(sqlButton.getText());



    }
}
