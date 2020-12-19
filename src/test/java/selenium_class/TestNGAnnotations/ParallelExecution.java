package selenium_class.TestNGAnnotations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParallelExecution {



    @BeforeMethod
    public void setup(){

        WebDriverManager.chromedriver().setup();

    }

    @Test
    public void test1()throws InterruptedException{
        WebDriver driver=new ChromeDriver();
        System.out.println("Executing test 1");
        driver.get("https://amazon.com");
        Thread.sleep(10000);
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon.com"));
    }

    @Test
    public void test2()throws InterruptedException{
        WebDriver driver=new ChromeDriver();
        System.out.println("Executing test 2");
        driver.get("https://www.techtorialacademy.com/");
        Thread.sleep(10000);
        Assert.assertTrue(driver.getCurrentUrl().contains("techtorial"));
    }


}
