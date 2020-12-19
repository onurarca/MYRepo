package selenium_class.SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumMethods {

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("file:///C:/Users/Onur/Desktop/Techtorial%20(2).html");

        WebElement submitButton = driver.findElement(By.id("submitbutton"));
        System.out.println(submitButton.getText());
        System.out.println(submitButton.getAttribute("type"));
        System.out.println(submitButton.getAttribute("value"));

        WebElement nextPage = driver.findElement(By.tagName("button"));
        System.out.println(nextPage.getText());

        WebElement javaButton = driver.findElement(By.linkText("Java"));
        System.out.println(javaButton.getAttribute("href"));
        javaButton.click();


        WebElement selenuimButton = driver.findElement(By.linkText("selenium_class"));
        selenuimButton.click();


        WebElement cucumberButton = driver.findElement(By.linkText("Cucumber"));
        cucumberButton.click();

        //driver.close(); // it will close the tab which driver is pointing.

        driver.quit();// it will close all the tabs












    }
}
