package selenium_class.Frames;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IframePractice {

    WebDriver driver;


    //BeforeClass annotation will run before Test and
    //BeforeMethod annotations inside the class

    @BeforeClass
    public void initializeDriver(){
       // System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //it will maximize the window
        driver.manage().window().maximize();


    }


    @Test
    public void test1(){
       driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement header = driver.findElement(By.tagName("h3"));
        System.out.println(header.getText());

        driver.switchTo().frame(0);

        WebElement content = driver.findElement(By.tagName("p"));
        System.out.println(content.getText());


        //defaultContentMethod switch back to your main html.
        driver.switchTo().defaultContent();
        header = driver.findElement(By.tagName("h3"));



        System.out.println(header.getText());



    }

    @Test
    public void test2(){
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        //driver.switchTo().frame(0); We can not swtich to frameSet
        driver.switchTo().frame("frame-top");
       // driver.switchTo().frame("frameset-middle"); We can not switch to frameSet
        WebElement secondPerson = driver.findElement(By.xpath("//frame[@name='frame-middle']"));
        driver.switchTo().frame(secondPerson);

        WebElement middleText = driver.findElement(By.id("content"));
        System.out.println(middleText.getText());


        //When we use nested frames, we can use the parentFrame() method to switch to parent frame
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");

        System.out.println(driver.findElement(By.tagName("body")).getText());





    }

    @Test
    public void test3(){

        driver.get("https://skpatro.github.io/demo/iframes/");
        String id = driver.getWindowHandle();
        driver.switchTo().frame("Frame1");
        WebElement cat1 = driver.findElement(By.xpath("//a[.='Category1']"));
        cat1.click();
        String newUrl ="http://qavalidation.com/category/seleniumtesting/";

        BrowserUtils.switchByUrl(driver,newUrl);

        System.out.println(driver.getTitle());

        BrowserUtils.switchByID(driver,id);
        driver.switchTo().defaultContent();
        driver.switchTo().frame("Frame2");
        WebElement cat3 = driver.findElement(By.xpath("//a[.='Category3']"));
        cat3.click();

        BrowserUtils.switchByUrl(driver,"http://qavalidation.com/category/softwaretesting/");
        System.out.println(driver.getCurrentUrl());



    }


}
