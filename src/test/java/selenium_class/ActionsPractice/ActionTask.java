package selenium_class.ActionsPractice;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionTask {

    @Test
    public void test1()throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        Actions actions = new Actions(driver);
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");

        try{
           Thread.sleep(2000);
           WebElement cookies = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
           cookies.click();

        }catch (Exception NoSuchElementException){
        }
        WebElement target = driver.findElement(By.xpath("//div[@class='test2']"));
        WebElement source = driver.findElement(By.id("draggable"));

        actions.dragAndDrop(source,target).perform();

        WebElement lastText = driver.findElement(By.xpath("//div[@id='droptarget']//div[@class='test2']"));
        String lastTxt =lastText.getText();

        Assert.assertEquals(lastTxt,"You did great!");







    }
}
