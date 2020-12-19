package selenium_class.com.Tests;

import selenium_class.com.Pages.AddNewCustomer;
import selenium_class.com.Pages.LoginPage;
import selenium_class.com.Pages.NewCustomer;
import selenium_class.com.TestBaseForDG;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AddNewCustomerTest extends TestBaseForDG {

    NewCustomer newCustomer;
    LoginPage loginPage;

    @BeforeMethod
    public void setup(){
        newCustomer = new NewCustomer(driver);
        loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);



    }

    @Test (priority = 0)
    public void login(){

        driver.get("http://demo.guru99.com/V4/");
        loginPage.setLogin("mngr295333","vuzUpav");
        this.newCustomer.newCustomer.click();

    }

    @Test(dataProvider = "newCustomerData", dataProviderClass = AddNewCustomer.class ,priority = 1)
    public void case3(String name, String gender, String dob, String address, String city, String state, String pin, String phone, String email, String password) throws IOException, InterruptedException {
        newCustomer.customerName.sendKeys(name);
        if (gender.equalsIgnoreCase("male")){
            newCustomer.male.click();
        }else if (gender.equalsIgnoreCase("female")){
            newCustomer.female.click();
        }
        WebDriverWait webDriverWait = new WebDriverWait(driver,2);
        webDriverWait.until(ExpectedConditions.visibilityOf(newCustomer.dob));

        newCustomer.dob.sendKeys(dob);

        newCustomer.address.sendKeys(address);
        newCustomer.city.sendKeys(city);
        newCustomer.state.sendKeys(state);
        newCustomer.pin.sendKeys(pin);
        newCustomer.phone.sendKeys(phone);
        newCustomer.email.sendKeys(email);
        newCustomer.password.sendKeys(password);
        Thread.sleep(1000);

        newCustomer.submitButton.click();

        Thread.sleep(2000);
        try{
            File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            long timestamp = System.currentTimeMillis();
            File destinationFolder = new File("src/test/java/selenium_class.ScreenShots/"+name+"-"+timestamp+".png");
            FileUtils.copyFile(screenShot,destinationFolder);
        }catch (UnhandledAlertException e){


        }


        File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        long timestamp = System.currentTimeMillis();
        File destinationFolder = new File("src/test/java/selenium_class.ScreenShots/"+name+"-"+timestamp+".png");
        FileUtils.copyFile(screenShot,destinationFolder);

        Thread.sleep(2000);

        Assert.assertEquals(newCustomer.titleCheck.getText(),"Customer Registered Successfully!!!");
        SoftAssert softAssert = new SoftAssert();
        String temp = "";
        String str =newCustomer.dobData.getText();
        temp=temp+str.substring(str.length()-2)+"-"+str.charAt(5)+str.charAt(6)+"-"+str.substring(0,4);

        softAssert.assertEquals(temp,dob,"DOB ERROR");
        softAssert.assertEquals(newCustomer.cityData.getText(), city,"CITY ERROR");
        softAssert.assertEquals(newCustomer.addressData.getText(),address, "ADDRESS ERROR");
        softAssert.assertEquals(newCustomer.stateData.getText(),state, "STATE ERROR");
        softAssert.assertEquals(newCustomer.pinData.getText(),pin, "PIN ERROR");
        softAssert.assertEquals(newCustomer.mobilNoData.getText(),phone, "PHONE ERROR");
        softAssert.assertEquals(newCustomer.emailData.getText(),email, "EMAIL ERROR");
        softAssert.assertAll();
        this.newCustomer.newCustomer.click();

    }


}
