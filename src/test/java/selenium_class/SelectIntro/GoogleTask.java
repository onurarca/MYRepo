package selenium_class.SelectIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GoogleTask {

    @Test
    public void TestB()throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.google.com/");
        WebElement input = driver.findElement(By.xpath("//input[contains(@class,'gLFyf gsfi')]"));
        input.sendKeys("selenium_class");
        WebElement searchButton = driver.findElement(By.xpath("//div[@class='tfB0Bf']//input[@class='gNO89b']"));
        searchButton.click();

        List<WebElement> titles = driver.findElements(By.xpath("//h3//span"));
        for (WebElement title :titles){
            Assert.assertTrue(title.getText().toLowerCase().contains("selenium"));
        }





    }

}
