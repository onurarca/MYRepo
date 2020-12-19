package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class BrowserUtils {

    WebDriver driver;

    /*
    closeWindows() method will close all the windows
    other than parent window
     */


    public static void closeWindows(WebDriver driver, String parentWindowID) {

        Set<String> ids = driver.getWindowHandles();
        for (String id : ids) {
            if (!id.equals(parentWindowID)) {
                driver.switchTo().window(id);
                driver.close();
            }
        }
        driver.switchTo().window(parentWindowID);


    }

    public static void switchByTitle(WebDriver driver, String targetTitle) {
        Set<String> ids = driver.getWindowHandles();
        for (String id : ids) {
            if (!driver.getTitle().equals(targetTitle)) {
                driver.switchTo().window(id);
            }
        }


    }

    public static void switchByUrl(WebDriver driver, String targetUrl) {

        Set<String> ids = driver.getWindowHandles();
        for (String id : ids) {
            if (!driver.getCurrentUrl().equals(targetUrl)) {
                driver.switchTo().window(id);
            }


        }

    }

    public static void switchByID(WebDriver driver, String pageID){

        Set<String> ids = driver.getWindowHandles();
        for (String id : ids) {
            if (id.equals(pageID)) {
                driver.switchTo().window(id);
            }


        }


    }

    public static void scrollIntoView(WebDriver driver, WebElement element){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true)",element);
    }
    public static void hoverOver(WebDriver driver, WebElement element){
        Actions actions=new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public static void click(WebDriver driver, WebElement element){
        Actions actions=new Actions(driver);
        actions.click(element).perform();
    }

    public static void jsClick(WebDriver driver, WebElement element){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",element);
    }

    public static void takeScreenshot(WebDriver driver, String testCaseName) throws IOException {

        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        long timestamp = System.currentTimeMillis();
        File destinationDir = new File("screenshots/"+testCaseName+"_"+timestamp+".png");
      FileUtils.copyFile(file,destinationDir);


    }

    @Test(testName = "my fav test")
    public void test2(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.findElement(By.name("b"));

    }

    @AfterMethod
    public void tearDown(ITestResult result)  {
        if (!result.isSuccess()){
            try{
                BrowserUtils.takeScreenshot(driver,result.getName());
            } catch (IOException ex){
                ex.printStackTrace();
            }

        }



    }

}
