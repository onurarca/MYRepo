package selenium_class.com.Tests;

import selenium_class.com.Pages.LoginPage;
import selenium_class.com.Pages.NewCustomer;
import selenium_class.com.TestBaseForDG;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class NewCustomerTest extends TestBaseForDG {

    public String idNumber;

    LoginPage loginPage;
    NewCustomer newCustomer;

    @BeforeClass
    public void setupPage(){
        loginPage=new LoginPage(driver);
        newCustomer=new NewCustomer(driver);

    }

    @Parameters({"username","password"})
    @Test
    public void case2(String username, String password ) throws InterruptedException, IOException {
        driver.get("http://demo.guru99.com/V4/");
        loginPage.setLogin(username,password);
     //   WebDriverWait wait=new WebDriverWait(driver,10);
       //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'New Cus')]"))));
        newCustomer.newCustomer.click();
        Assert.assertEquals(newCustomer.titleCheck.getText(),"Add New Customer");
        newCustomer.customerName.sendKeys("Micha Gre");
        newCustomer.female.click();
        newCustomer.dob.sendKeys("05-03-1989");
        newCustomer.address.sendKeys("3334 W Michigan Ave");
        newCustomer.city.sendKeys("Chicago");
        newCustomer.state.sendKeys("Illinois");
        newCustomer.pin.sendKeys("123556");
        newCustomer.phone.sendKeys("3345562226");
        newCustomer.email.sendKeys("michaelgre@gmail.com");
        newCustomer.password.sendKeys("michaelbest6");
        newCustomer.submitButton.click();

        Thread.sleep(2000);
        try{
            File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            long timestamp = System.currentTimeMillis();
            File destinationFolder = new File("src/test/java/selenium_class.ScreenShots/"+"MichaelGreen"+"-"+timestamp+".png");
            FileUtils.copyFile(screenShot,destinationFolder);

        }catch (Exception e){

        }



        Thread.sleep(2000);

        Assert.assertEquals(newCustomer.titleCheck.getText(),"Customer Registered Successfully!!!");

        Assert.assertEquals(newCustomer.nameData.getText(),"Micha Gre");
        String temp = "";
        String str =newCustomer.dobData.getText();
        temp=temp+str.substring(str.length()-2)+"-"+str.charAt(5)+str.charAt(6)+"-"+str.substring(0,4);

       Assert.assertEquals(temp,"05-03-1989");
       Assert.assertEquals(newCustomer.cityData.getText(), "Chicago");
       Assert.assertEquals(newCustomer.addressData.getText(),"3334 W Michigan Ave");
       Assert.assertEquals(newCustomer.stateData.getText(),"Illinois");
       Assert.assertEquals(newCustomer.pinData.getText(),"123556");
       Assert.assertEquals(newCustomer.mobilNoData.getText(),"3345562226");
       Assert.assertEquals(newCustomer.emailData.getText(),"michaelgre@gmail.com");

        try{
            File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            long timestamp = System.currentTimeMillis();
            File destinationFolder = new File("src/test/java/selenium_class.ScreenShots/"+"MichaelGreen"+"-"+timestamp+".png");
            FileUtils.copyFile(screenShot,destinationFolder);

        }catch (Exception e){

        }

        WebElement id = driver.findElement(By.xpath("//td[contains(text(), 'ID')]/following-sibling::td"));
        idNumber= id.getText();


    }


}
