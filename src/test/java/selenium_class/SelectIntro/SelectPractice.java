package selenium_class.SelectIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectPractice {

    public static void main(String[] args) {
        double dbl = Double.parseDouble("$15.02");
        System.out.println(dbl);
    }

    @Test
    public void test1() throws InterruptedException{
        WebDriverManager .chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.facebook.com/TechtorialBootcamp/");
        Thread.sleep(2000);

        WebElement createNew = driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _3obb _4jy6 _4jy2 selected _51sy']"));
        createNew.click();

        WebElement month = driver.findElement(By.id("month"));
        Select selectMonth = new Select(month);
        selectMonth.selectByIndex(6);

        WebElement day = driver.findElement(By.id("day"));
        Select selectDay = new Select(day);
        selectDay.selectByValue("26");

        WebElement year = driver.findElement(By.id("year"));
        Select selectYear = new Select(year);
        selectYear.selectByVisibleText("1998");



    }

    @Test
    public void test2()throws InterruptedException{


        WebDriverManager .chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.facebook.com/TechtorialBootcamp/");
        Thread.sleep(2000);

        WebElement createNew = driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _3obb _4jy6 _4jy2 selected _51sy']"));
        createNew.click();


        WebElement month = driver.findElement(By.id("month"));
        Select selectMonth = new Select(month);
        //getFirstSelectedOption() --> this method return the WebElement of first selected option
        WebElement selectedOption = selectMonth.getFirstSelectedOption(); //<option selected="1"Oct</option>
        String actual =selectedOption.getText().toLowerCase();

        String expected = LocalDate.now().getMonth().toString().substring(0,3).toLowerCase();
        Assert.assertEquals(actual, expected);



    }

    @Test
    public void test3()throws InterruptedException{

        WebDriverManager .chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.facebook.com/TechtorialBootcamp/");
        Thread.sleep(2000);

        WebElement createNew = driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _3obb _4jy6 _4jy2 selected _51sy']"));
        createNew.click();

        WebElement month = driver.findElement(By.id("month"));
        Select selectMonth = new Select(month);
        //getOptions() --> method returns all options under given select element.
        //We can store this method as List of WebElement then get the text

        List<WebElement> options = selectMonth.getOptions();
        List<String > actualOptions=new ArrayList<>();

        for (WebElement option :options){
            actualOptions.add(option.getText());
        }
        String [] expOptions = {"Month", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        List<String> expectedOptions = Arrays.asList(expOptions);

        Assert.assertEquals(expectedOptions,actualOptions);

    }



}
