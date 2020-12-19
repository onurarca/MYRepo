package selenium_class.WindowsHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowsPractice {

    @Test
    public void test1(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/windows");

        WebElement clickHere = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHere.click();
        String currentPageID = driver.getWindowHandle();
        Set<String> ids = driver.getWindowHandles();

        for (String id : ids){
            if(!id.equals(currentPageID)){
                driver.switchTo().window(id);
            }
        }
        WebElement newWindowText = driver.findElement(By.tagName("h3"));
        System.out.println("text from new window : " + newWindowText.getText());

        Assert.assertEquals(newWindowText.getText(), "New Window");

        driver.switchTo().window(currentPageID);

        WebElement parentPageText= driver.findElement(By.tagName("h3"));
        System.out.println("text from parent window : " + parentPageText.getText());





    }

    @Test
    public void validateNewWindows(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://www.popuptest.com/popuptest12.html");

        String currentID = driver.getWindowHandle();

        Set<String>ids = driver.getWindowHandles();

        for (String id : ids){
            if (!id.equals(currentID)){
                driver.switchTo().window(id);
                driver.close();
            }
        }

        driver.switchTo().window(currentID);


    }




}
