package selenium_class.Sentrifugo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DepartmentPage {

    public DepartmentPage(WebDriver driver){

        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@title='Departments']")
    public WebElement departmentsButton;

    @FindBy(xpath = "//input[@title='Add']")
    public WebElement addButton;

    @FindBy(id = "deptname")
    public WebElement departmentName;

    @FindBy(id = "deptcode")
    public WebElement departmentCode;

    @FindBy(id = "submitbutton")
    public WebElement saveButton;

    @FindBy(id = "errors-deptname")
    public WebElement errorDeptName;

    @FindBy(id = "errors-deptcode")
    public WebElement errorDeptCode;

    @FindBy(className = "ml-alert-1-success")
    public WebElement successMessage;






}
