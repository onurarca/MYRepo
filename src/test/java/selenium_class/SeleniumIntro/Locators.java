package selenium_class.SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("file:///C:/Users/Onur/Desktop/Techtorial%20(2).html");

        WebElement addressOne = driver.findElement(By.name("address1"));

        addressOne.sendKeys("10101 S. 1ST ST ");

        WebElement addressTwo = driver.findElement(By.name("address2"));
        addressTwo.sendKeys("Apt 131");

        WebElement city = driver.findElement(By.name("city"));
        city.sendKeys("Austin");

        WebElement state = driver.findElement(By.className("state"));
        state.sendKeys("TX");

        WebElement zipCode = driver.findElement(By.className("pstlCode"));
        zipCode.sendKeys("78748");

        WebElement country = driver.findElement(By.name("country"));
        country.sendKeys("ANDORRA");

        WebElement header = driver.findElement(By.tagName("h1"));
        // header.sendKeys("aa"); //--> it will throw exception
        System.out.println(header.getText());

        WebElement btag = driver.findElement(By.tagName("b"));
        //FinElement method returns single web element.
        //If we have more than one matching locator value in the html
        //finElement method returns only the first matching web element
        System.out.println(btag.getText());

        WebElement seleniumButton = driver.findElement(By.linkText("selenium_class"));
        //I have only one matching <a> tag on the html which has Selenium text.
        seleniumButton.click();

        driver.navigate().back();

        WebElement testNG = driver.findElement(By.linkText("TestNG"));
        testNG.click();

        driver.navigate().back();

        WebElement restApi = driver.findElement(By.partialLinkText("Rest"));
        restApi.click();

        driver.navigate().back();
        addressOne=driver.findElement(By.name("address1"));
        addressOne.clear();
        addressTwo=driver.findElement(By.name("address2"));
        addressTwo.clear();
        city = driver.findElement(By.name("city"));
        city.clear();
        state = driver.findElement(By.className("state"));
        state.clear();
        zipCode = driver.findElement(By.className("pstlCode"));
        zipCode.clear();

       // WebElement cucumber = driver.findElement(By.linkText("Cucumber"));
        //cucumber.submit();

        WebElement submit = driver.findElement(By.id("submitbutton"));
        submit.submit();




    }
}
