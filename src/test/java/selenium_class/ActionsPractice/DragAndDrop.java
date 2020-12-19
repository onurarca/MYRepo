package selenium_class.ActionsPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DragAndDrop {
    WebDriver driver;

    @BeforeClass // BeforeClass Annotation will run before everything in this class
    public void initialize(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
    }

    @Test
    public void test1()throws InterruptedException{


        driver.manage().window().maximize();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/index");
        Thread.sleep(200);
        WebElement cookies = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        cookies.click();

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(source).moveToElement(target).release(target).perform();

       String actual = target.getText();
       String expected = "You did great!";
       Assert.assertEquals(actual,expected);

    }


    @Test
    public void test2()throws InterruptedException{

        driver.manage().window().maximize();
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        //Thread.sleep(200);
        //WebElement cookies = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
       // cookies.click();

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(source,target).perform();

    }


}
