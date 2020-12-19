package selenium_class.SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathPractice {

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("file:///C:/Users/Onur/Desktop/Techtorial%20(2).html");

        WebElement register = driver.findElement(By.xpath("//a[starts-with(@href, 'mercuryr')]"));
        System.out.println(register.getText());

        WebElement register2 = driver.findElement(By.xpath("//td[@name='contactbtn']/a[contains(@href, 'underconst')]"));
        System.out.println(register2.getText());


    }
}
