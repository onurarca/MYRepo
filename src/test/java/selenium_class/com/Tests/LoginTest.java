package selenium_class.com.Tests;

import selenium_class.com.Pages.LoginPage;
import selenium_class.com.TestBaseForDG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

public class LoginTest extends TestBaseForDG {
    LoginPage loginPage;

    @BeforeClass
    public void setLoginPage(){
        loginPage=new LoginPage(driver);


    }
    @Parameters({"username","password"})
    @BeforeMethod
    public void login(String Username, String Password){
        driver.get("http://demo.guru99.com/V4/");
       loginPage.setLogin(Username, Password);

    }


    @Test
    public void case1() throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver,10);

        List<WebElement>funcNames = driver.findElements(By.xpath("//ul[@class='menusubnav']//li"));

        List <String> elements = new ArrayList<>();

        for (WebElement element :funcNames){
            elements.add(element.getText().trim());
            }
            Thread.sleep(1000);
               Assert.assertEquals(elements.size(),15);
        for (int i =0 ; i<elements.size(); i++){

            if (elements.get(i).contains(" ") && !elements.get(i).equals("Log out")){
                System.out.println(elements.get(i));
                Assert.assertTrue(elements.get(i).charAt(0) >=65 && elements.get(i).charAt(0) <=90);
                Assert.assertTrue(elements.get(i).charAt(elements.get(i).indexOf(" ")+1) >=65 && elements.get(i).charAt(elements.get(i).indexOf(" ")+1) <=90);
                }
            else if (!elements.get(i).contains(" ")){
                Assert.assertTrue(elements.get(i).charAt(0) >=65 && elements.get(i).charAt(0) <=90);
            }
        }


    }




}
