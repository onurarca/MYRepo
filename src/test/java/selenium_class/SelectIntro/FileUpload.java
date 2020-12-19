package selenium_class.SelectIntro;

import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FileUpload {

    WebDriver driver;

    @Test
    public void uploadFile(){
        driver= Driver.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement fileUpload = driver.findElement(By.cssSelector("#file-upload"));
        fileUpload.sendKeys("C:/Users/Onur/Downloads/Onur.txt");

        WebElement upload = driver.findElement(By.cssSelector("#file-submit"));
        upload.click();


    }
}
