package selenium_class.Sentrifugo;

import Utils.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestBase {

    //Inside this class I will be initializing my webDriver adn Call the driver from this class
    //This one will help us to avaid creating WebDriverManager.chromedriver().setUp() in every class

    public WebDriver driver;


    @Parameters("driverName")
    @BeforeClass
    public void setUp(String driverName){
        //WebDriverManager.chromedriver().setup();
        driver = Driver.getDriver(driverName);
        //driver.manage().window().maximize();
        System.out.println("Setup");


    }





}
