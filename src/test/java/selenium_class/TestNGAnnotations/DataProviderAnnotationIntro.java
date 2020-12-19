package selenium_class.TestNGAnnotations;

import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class DataProviderAnnotationIntro {

    WebDriver driver;

    @BeforeClass
    public void driverSetUp(){
        driver=Driver.getDriver("chrome");
    }





    @Test(dataProvider = "testData")
    public void test1(String firstName, String lastName){

        System.out.println("First name: " + firstName + ", last name: " + lastName);



    }


    //return type of data type must be two dimensinal object array
   @DataProvider(name ="testData")
    public Object[][] getTestDate(){

        return new Object[][]{
                {"John", "Smith"},
                {"Mike", "Green"},
                {"Priyanka","Khan"},
                {"admin", "Admin123"}};


    }


    @Test(dataProvider = "testData")
    public void validateLoginFunc( String username, String passWord){

        driver.get("https://demo.openmrs.org/openmrs/login.htm");

        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys(username);
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(passWord);
        WebElement select = driver.findElement(By.id("Pharmacy"));
        select.click();
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
        String message="You must choose a location!";
        WebElement actualMessage = driver.findElement(By.id("sessionLocationError"));
        Assert.assertEquals(actualMessage.getText(),message);



    }



}
