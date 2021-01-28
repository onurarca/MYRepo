package selenium_class.ActionsPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SliderImagePractice {
    
    @Test
    public void test1()throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/slider/angular");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement cookies = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        cookies.click();

        Thread.sleep(3000);

        WebElement redCircle = driver.findElement(By.xpath("//div[contains(@class,'vertical')]//a[@role='slider']"));

        WebElement ten = driver.findElement(By.xpath("//div[contains(@class,'vertical')]//li[@title='10']"));
        WebElement zero = driver.findElement(By.xpath("//div[contains(@class,'vertical')]//li[@title='0']"));

        Point tenPoint = ten.getLocation();
        Point zeroPoint = zero.getLocation();
        System.out.println(tenPoint.getY());
        System.out.println(zeroPoint.getY());
        System.out.println(tenPoint.getY()-zeroPoint.getY());

        Actions actions = new Actions(driver);
        actions.clickAndHold(redCircle)
                .moveByOffset(0,-44)
                .release()
                .perform();




    }


    @Test
    public void test2()throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/slider/angular");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement cookies = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        cookies.click();

        WebElement redXCircle = driver.findElement(By.xpath("//div[contains(@class,'horizontal')]//a[@role='slider']"));

        WebElement tenX = driver.findElement(By.xpath("//div[contains(@class,'horizontal')]//li[@title='10']"));
        WebElement zeroX = driver.findElement(By.xpath("//div[contains(@class,'horizontal')]//li[@title='0']"));
        Actions actions = new Actions(driver);
        Point tenXPoint = tenX.getLocation();
        Point zeroXPoint = zeroX.getLocation();
        System.out.println(tenXPoint.getX());
        System.out.println(zeroXPoint.getX());
        System.out.println(tenXPoint.getX()-zeroXPoint.getX());

        actions.clickAndHold(redXCircle)
                .moveByOffset(88,0)
                .release()
                .perform();




    }


    
}
