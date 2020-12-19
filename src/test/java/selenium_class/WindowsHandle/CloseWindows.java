package selenium_class.WindowsHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class CloseWindows {

    @Test
    public void validateWindowClose(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("http://www.popuptest.com/popuptest1.html");

        String parentID = driver.getWindowHandle();
      //Since the method is static we can call with the class name
        BrowserUtils.closeWindows(driver,parentID);

        System.out.println(driver.getCurrentUrl());


    }

    public static void switchByUrl(WebDriver driver, String targetUrl){

        Set<String> ids =driver.getWindowHandles();
        for (String id: ids){
            if (!driver.getCurrentUrl().equals(targetUrl)){
                driver.switchTo().window(id);
            }
        }



    }




}
