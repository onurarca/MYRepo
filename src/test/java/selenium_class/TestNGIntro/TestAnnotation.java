package selenium_class.TestNGIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestAnnotation {

    @Test
    public void testA()throws InterruptedException{
        //It will download the chromeDriver for your automation.
        //All dependencies will me downloaded inside .m2 file
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.facebook.com/");

        WebElement createNew = driver.findElement(By.id("u_0_2"));
        createNew.click();

        Thread.sleep(2000);

        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("David");

        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Hunt");

        WebElement phoneNumber = driver.findElement(By.name("reg_email__"));
        phoneNumber.sendKeys("5554442323");

        WebElement password = driver.findElement(By.id("password_step_input"));
        password.sendKeys("password1234");

        //1- it might be opening new window
        //2-it might be inside the iframe
        //3-Your page might be refreshed after you find the element
        //4-it might be javascript alert

        WebElement month = driver.findElement(By.id("month"));
        Select selectMonth = new Select(month);
        selectMonth.selectByVisibleText("May");
        Thread.sleep(1000);

        selectMonth.selectByValue("2");
        Thread.sleep(1000);

        selectMonth.selectByIndex(9);
        ;

        WebElement day = driver.findElement(By.id("day"));
        Select selectDay = new Select(day);

        WebElement year= driver.findElement(By.id("year"));
        Select selectYear = new Select(year);


    }
}
