package selenium_class.SeleniumIntro.HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork2 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        //CASE 1
        System.out.println("CASE 1");

        WebElement checkAllBtn = driver.findElement(By.id("check1"));
        System.out.println("Is Check All Button Displayed? \n" + checkAllBtn.isDisplayed()+"\n");

        System.out.println("What is the text on button Check All? \n" + checkAllBtn.getAttribute("value")+"\n");

        checkAllBtn.click();

        System.out.println("Are the check boxes checked?");
        WebElement checkboxes = driver.findElement(By.xpath("//div[@class='checkbox']//label//input[@type='checkbox']"));
        System.out.println(checkboxes.isEnabled()+"\n");

        System.out.println("Does button value Uncheck All?");
        checkAllBtn=driver.findElement(By.id("check1"));
        System.out.println(checkAllBtn.getAttribute("value").equals("Uncheck All"));
        System.out.println();


        //CASE 2 Same as CASE 1

        //CASE 3
        System.out.println("CASE 3");

        driver.get("https://www.saucedemo.com/");
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("Java");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("selenium_class");
        WebElement logIn = driver.findElement(By.id("login-button"));
        logIn.click();
        WebElement validate = driver.findElement(By.xpath("//h3[@data-test='error']"));
        System.out.println("\nIS ERROR MESSAGE:\n\"Epic sadface: Username and password do notmatch any user in this service\" ?\n" + validate.getText().equals("Epic sadface: "+"Username and password do not match any user in this service"));

        //CASE 4

        driver.navigate().to("https://www.saucedemo.com/");
        System.out.println();
        System.out.println("CASE 4");

        WebElement userName2= driver.findElement(By.id("user-name"));
        userName2.sendKeys("standard_user");
        WebElement password2 = driver.findElement(By.id("password"));
        password2.sendKeys("secret_sauce");
        WebElement logIn2 = driver.findElement(By.id("login-button"));
        logIn2.click();
        System.out.println("Is the current URL \"https://www.saucedemo.com/inventory.html\" ?");
        System.out.println(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html"));












    }
}
