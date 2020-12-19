package selenium_class.ActionsPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testing {

    @Test
    public void DragAndDropBlueCircle() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        Thread.sleep(2000);
        WebElement cookies = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        cookies.click();

        driver.manage().window().maximize();
        WebElement circle= driver.findElement(By.id("draggable"));
        WebElement orangeBox= driver.findElement(By.xpath("//div[@class='test2']"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(circle,orangeBox).perform();

        //Until here everything works and your driver is pointing to the blue ball.
        //We need to reInitialize the "orange box" so your driver will point out to the orange box and you can get the text.
        orangeBox= driver.findElement(By.xpath("//div[@class='test2']"));

        String actualText=orangeBox.getText();

        String expected="You did great!";
        Assert.assertEquals(actualText,expected);
    }
}
