package selenium_class.Sentrifugo.Tests;

import selenium_class.Sentrifugo.Pages.LoginPage;
import selenium_class.Sentrifugo.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    LoginPage loginPage;

    @BeforeClass
    public void setUpPage(){
        loginPage=new LoginPage(driver);
        System.out.println("Page");



    }

    @Parameters({"firstInput","secondInput"})
    @Test(priority = 4)
    public void logInTest1(String userName, String password){
        driver.get("http://demo.sentrifugo.com/index.php/");
        loginPage.login(userName, password);
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Sentrifugo - Open Source HRMS");

        /*
        While implementing the selenium code
        1- Create page class (Do not forget to create constructor, PageFactory.initElement())
        2- We are using TestBase class to initialize our webDriver
        3- Inside Test class create an object in BeforeClass for Pages and extend the test class with TestBase class
         */




    }

    @Test(priority = 1)
    public void negativeTest(){
        driver.get("http://demo.sentrifugo.com/index.php/");
        loginPage.login("EM01", "test");
        String actualErrorMessage = loginPage.errorMessage.getText();
        String expectedErrorMessage = "The username or password you entered is incorrect.";
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);

    }

    @Test(priority = 2)
    public void negativeTest2() {
        driver.get("http://demo.sentrifugo.com/index.php/");
        loginPage.login("EM", "Sentrifugo");
        String actualErrorMessage = loginPage.errorMessage.getText();
        String expectedErrorMessage = "The username or password you entered is incorrect.";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    @Test(priority = 3)
    public void negativeTest3() {
        driver.get("http://demo.sentrifugo.com/index.php/");
        loginPage.login("test", "test");
        String actualErrorMessage = loginPage.errorMessage.getText();
        String expectedErrorMessage = "The username or password you entered is incorrect.";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }


}
