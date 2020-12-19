package selenium_class.SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTech {

    public static void main(String[] args) {

        System.setProperty("Webdriver.chrome.driver","chromedriver.exe");
        // System.setProperty --> set the file location and use the chromedriver from selenium.
        // It will set the value for chromeDriver.
        // without setproperty we cannot launch the chrome driver
        WebDriver driver = new ChromeDriver();

        driver.get("file:///C:/Users/Onur/Desktop/Techtorial%20(2).html");

        WebElement header = driver.findElement(By.id("techtorial1"));

        //get text, click element, is displayed, is selected, send key
        //getText() --> returns the text of the web element
        System.out.println(header.getText());

        WebElement firstNameInput = driver.findElement(By.id("frstName"));
        //sendKeys Method will send the given string to the input box.
        firstNameInput.sendKeys("Onur");

        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Arca");

        WebElement phone = driver.findElement(By.id("phoneNum"));
        phone.sendKeys("7573242885");

        WebElement eMail = driver.findElement(By.id("userName"));
        eMail.sendKeys("onurarca@gmail.com");

    }
}
