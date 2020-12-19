package selenium_class.SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class XpathPro {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("file:///C:/Users/Onur/Desktop/Techtorial%20(2).html");

        //findElements() method returns List<WebElement>

        List<WebElement> titles = driver.findElements(By.xpath("//b"));
        for (WebElement title : titles){
            System.out.println(title.getText());
        }
        System.out.println();


        List<WebElement> texts = driver.findElements(By.xpath("//td[@width='80']//a"));
        for (WebElement text : texts){
            System.out.println(text.getText());
            System.out.println(text.getAttribute("href"));

        }









    }
}
