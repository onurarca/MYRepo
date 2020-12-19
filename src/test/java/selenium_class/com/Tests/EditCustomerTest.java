package selenium_class.com.Tests;

import selenium_class.com.Pages.AddNewCustomer;
import selenium_class.com.Pages.EditCustomer;
import selenium_class.com.Pages.LoginPage;
import selenium_class.com.Pages.NewCustomer;
import selenium_class.com.TestBaseForDG;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class EditCustomerTest extends TestBaseForDG {

   LoginPage loginPage;
   EditCustomer editCustomer;
   NewCustomer newCustomer;
   AddNewCustomer addNewCustomer;
   NewCustomerTest newCustomerTest;

    @BeforeClass
    public void setup(){
        loginPage = new LoginPage(driver);
        editCustomer = new EditCustomer(driver);
        newCustomer = new NewCustomer(driver);
        addNewCustomer = new AddNewCustomer(driver);
        newCustomerTest = new NewCustomerTest();


    }

    @Parameters({"username","password"})
    @Test
    public void case4(String username, String password){
        loginPage.setLogin(username,password);

        editCustomer.customerIDEnter.sendKeys(newCustomerTest.idNumber);
        editCustomer.submitButn.click();
        editCustomer.editAddress.clear();
        editCustomer.editAddress.sendKeys("227 W Monroe");
        editCustomer.editPin.clear();
        editCustomer.editPin.sendKeys("443322");
        editCustomer.editCity.clear();
        editCustomer.editCity.sendKeys("Des Plaines");
        editCustomer.editEmail.clear();
        editCustomer.editEmail.sendKeys("michaelqueen@gmail.com");
        editCustomer.editPhone.clear();
        editCustomer.editPhone.sendKeys("2243084345");
        editCustomer.editedSubmit.click();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(newCustomer.addressData,"227 W Monreo", "address error");
        softAssert.assertEquals(newCustomer.cityData, "Des Plaines", "City Error");
        softAssert.assertEquals(newCustomer.pinData, "443322", "Pin Error");
        softAssert.assertEquals(newCustomer.emailData, "michaelqueen@gmail.com", "Email Error");
        softAssert.assertEquals(newCustomer.mobilNoData, "2243084345", "PhoneNumber Error");
        softAssert.assertAll("Edit Customer Error");



    }





}
