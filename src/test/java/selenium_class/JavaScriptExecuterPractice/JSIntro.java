package selenium_class.JavaScriptExecuterPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class JSIntro {

    WebDriver driver;
    SoftAssert softAssert;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        softAssert=new SoftAssert();

    }

    @Test
    public void validationJSExecutor(){
        driver.get("https://www.techtorialacademy.com/");
        System.out.println(driver.getTitle());
        JavascriptExecutor js =(JavascriptExecutor) driver;
        String title=js.executeScript("return document.title").toString();
        System.out.println(title);

        WebElement browserCourse = driver.findElement(By.linkText("Browse Course"));

        js.executeScript("arguments[0].click()",browserCourse);
        System.out.println(js.executeScript("return document.title").toString());

        js.executeScript("alert (\"Techtorial Academy Javascript executor\")");

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

        WebElement getStartedButton = driver.findElement(By.xpath("//h4[.='Online Course']/following-sibling::div//a"));
        js.executeScript("arguments[0].scrollIntoView(true);", getStartedButton);

        WebElement programHeader = driver.findElement(By.tagName("h1"));
        js.executeScript("arguments[0].scrollIntoView(true);",programHeader);




    }

    @Test
    public void scrollUntilEndOfThePage(){
        driver.get("https://www.techtorialacademy.com/");
        JavascriptExecutor js =(JavascriptExecutor) driver;

        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");




    }

}
