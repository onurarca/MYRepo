package selenium_class.Sentrifugo.Tests;

import selenium_class.Sentrifugo.Pages.DepartmentPage;
import selenium_class.Sentrifugo.Pages.LoginPage;
import selenium_class.Sentrifugo.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DepartmentTest extends TestBase {

    DepartmentPage departmentPage;
    LoginPage loginPage;

    @BeforeClass
    public void setupPage(){
        departmentPage = new DepartmentPage(driver);
        loginPage = new LoginPage(driver);


    }

    @Test(priority = 1)
    public void validateErrorMessage()throws InterruptedException{
        driver.get("http://demo.sentrifugo.com/index.php/");
        loginPage.login("EM01", "sentrifugo");
        departmentPage.departmentsButton.click();
        departmentPage.addButton.click();
        departmentPage.saveButton.click();
        Thread.sleep(1000);
        String expectedNameError = "Please enter department name.";
        String actualNameError = departmentPage.errorDeptName.getText().trim();
        String expectedCodeError = "Please enter department code.";
        String actualCodeError = departmentPage.errorDeptCode.getText().trim();

        Assert.assertEquals(actualNameError,expectedNameError);
        Assert.assertEquals(actualCodeError,expectedCodeError);


    }

    @Test(priority = 2)
    public void validateNewDepartment(){
        departmentPage.departmentName.sendKeys("Test");
        departmentPage.departmentCode.sendKeys("1234");
        departmentPage.saveButton.click();
        String expectedSuccessMessage = "Department added successfully.";
        String actualSuccessMessage = departmentPage.successMessage.getText().trim();
        Assert.assertEquals(actualSuccessMessage,expectedSuccessMessage);



    }

}
