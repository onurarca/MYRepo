package selenium_class.com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

public class AddNewCustomer {

     public AddNewCustomer(WebDriver driver){

         PageFactory.initElements(driver,this);
     }

     @DataProvider (name = "newCustomerData")
    public static Object[][] createData(){

         return dataCreater();
     }

     public static Object[][] dataCreater(){

         return new Object[][]{
                 {"Onfer Pacr", "Male", "11-01-1993", "10156 S 1ST SeT", "Austin", "Texas", "783113", "4452525521", "p1ace2@hotmail.com", "1OPaca93934" },
                 {"Adrir Marr", "Female", "11-01-1995", "101011 2ND SeT", "Austin", "Texas", "159719", "1541525521", "a1driana2@gmail.com", "A1driana20204"},
                 {"Stevern Chn", "Male", "11-01-1965", "405 Behl Cte", "Norfolk", "Virginia", "456113", "7572142771", "s1tevench2@hotmail.com", "S1teven21254"},
                 {"Blackk Rabt", "Female", "11-01-1966", "Black rabbit parke", "Dallas", "Texas", "456719", "7414562521", "b1lackrabbit2@gmail.com", "Ra1bbitBlack224"}


         };
     }



}
