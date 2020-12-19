package selenium_class.SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumFirst {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        //WebDriver is an interface. Thats why we can not instantiate the WebDriver with new WebDriver();
        WebDriver driver = new ChromeDriver();

        //Get Method --> Navigates to the given url
        driver.get("https://www.google.com/");
        String googleTitle = driver.getTitle();
        System.out.println(googleTitle);


        driver.navigate().to("https://www.techtorialacademy.com/");
        String techtorialTitle = driver.getTitle();
        System.out.println(techtorialTitle);
        String currenturl = driver.getCurrentUrl();
        System.out.println(currenturl);

        //GetTitle method --> It will get the title of the page and return String value.

        if (techtorialTitle.equals("Home Page - Techtorial")){
            System.out.println("Title is correct");
        }else
            System.out.println("Title is not correct");

        //getCurrentUrl
        currenturl = driver.getCurrentUrl();
        System.out.println(currenturl);

        //System.out.println(driver.getPageSource()); prints HTML CODE

        /* We have two ways to navigate to the page
        1-driver.get("url"); --> waits until your page loads
        2-driver.navigate().to("url"); -->It will not wait for page to fully load.
         */

        driver.navigate().to("https://www.facebook.com/");
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().forward();

        driver.navigate().to("file:///C:/Users/Onur/Desktop/Techtorial%20(2).html");
        String tectorialUrl = driver.getCurrentUrl();
        System.out.println(tectorialUrl);

        



    }

}
