package selenium_class.HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class HomeWork4 {

    @Test
    public void case1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://uitestpractice.com/Students/Select#");
        driver.manage().window().maximize();

        WebElement defaultSelected = driver.findElement(By.id("countriesSingle"));
        Select select = new Select(defaultSelected);
        String expected = "India";
        String actual = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actual,expected); //Is India Selected??

        List<WebElement> elements = select.getOptions();
        int actualSize = elements.size();
        int expectedSize = 4;
        Assert.assertEquals(actualSize, expectedSize); //Size of Drop downBox is 4


        List<String> expectedValues = new ArrayList<String>();
        expectedValues.add("India");
        expectedValues.add("United states of America");
        expectedValues.add("China");
        expectedValues.add("England");

    //{"India", "United states of America", "China", "England"};
        List<String> values = new ArrayList<>();

        for (WebElement element : elements){
            values.add(element.getText());
        }
        Assert.assertEquals(values,expectedValues); //Are the values(Texts) same

        //Select China with Index Number
        select.selectByIndex(2);
        //Select England with value
        select.selectByValue("england");
        //Select USA with visible text
        select.selectByVisibleText("United states of America");







    }


    @Test
    public void case2(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://uitestpractice.com/Students/Select#");
        driver.manage().window().maximize();

        List<String> expectedValues = new ArrayList<String>();
        expectedValues.add("India");
        expectedValues.add("United states of America");
        expectedValues.add("China");
        expectedValues.add("England");
        WebElement ele = driver.findElement(By.id("countriesMultiple"));
        Select select = new Select(ele);
        List<WebElement> values = select.getOptions();
        List<String> elements = new ArrayList<>();
        for (WebElement element : values){
            elements.add(element.getText());
        }

        Assert.assertEquals(elements,expectedValues);

        //Select china england
        WebElement china = driver.findElement(By.xpath("//select[@id = 'countriesMultiple']//option[@value='china']"));
        WebElement england = driver.findElement(By.xpath("//select[@id = 'countriesMultiple']//option[@value='england']"));
        WebElement usa = driver.findElement(By.xpath("//select[@id = 'countriesMultiple']//option[@value='usa']"));
        WebElement india = driver.findElement(By.xpath("//select[@id = 'countriesMultiple']//option[@value='india']"));


        Actions actions = new Actions(driver);
        actions.click(china).keyDown(china,Keys.SHIFT).click(england).keyUp(england,Keys.SHIFT).perform();

        WebElement result = driver.findElement(By.id("result"));
        String expectedText = "China England";
        Assert.assertEquals(result.getText(),expectedText);
        select.deselectAll();
        actions.click(india).keyDown(india,Keys.SHIFT).click(usa).click(china).click(england).perform();
        String selectAll = "India United states of America China England";
        Assert.assertEquals(result.getText(),selectAll);

        select.deselectByIndex(2);
        select.deselectByValue("england");





    }

    @Test
    public void case3() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.cars.com/");
        driver.manage().window().maximize();

        WebElement menu = driver.findElement(By.name("stockType"));
        Select select = new Select(menu);
        select.selectByIndex(3);
        WebElement make = driver.findElement(By.name("makeId"));
        select=new Select(make);
        select.selectByValue("20088");

        WebElement model = driver.findElement(By.name("modelId"));
        select=new Select(model);
        select.selectByValue("20861");

        WebElement maxPrice = driver.findElement(By.name("priceMax"));
        select=new Select(maxPrice);
        select.selectByValue("30000");

        WebElement radius = driver.findElement(By.name("radius"));
        select = new Select(radius);
        select.selectByValue("40");


        WebElement zip = driver.findElement(By.name("zip"));
        zip.clear();
        zip.sendKeys("60018");

        WebElement search = driver.findElement(By.xpath("//input[@value='Search']"));
        search.click();
        Thread.sleep(2000);
        // I had to make the code wait other wise code is running faster than page loading time
        //And getting the title of previous page

        String title = driver.getTitle();
        System.out.println(title);
        System.out.println(title.contains("Certified Used"));

        WebElement h1 = driver.findElement(By.className("srp-header"));
        String h1ExpectedText = "Certified Used Toyota Corolla for Sale";
        String h1ActualText = h1.getText();
        Assert.assertEquals(h1ActualText,h1ExpectedText);


        WebElement elem = driver.findElement(By.xpath("//select[@name='rd']"));
        select= new Select(elem);

        String actual = select.getFirstSelectedOption().getText();
        String expected ="40 miles";
        Assert.assertEquals(actual,expected);

        WebElement radioLabel = driver.findElement(By.id("stkTypId-28444"));

        Assert.assertTrue(radioLabel.isSelected());

        WebElement corolla = driver.findElement(By.id("mdId-20861"));

        Assert.assertTrue(corolla.isSelected());



    }

    @Test
    public void case4()throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.cars.com/");
        driver.manage().window().maximize();

        WebElement menu = driver.findElement(By.name("stockType"));
        Select select = new Select(menu);
        select.selectByIndex(3);
        Thread.sleep(1000);

        WebElement make = driver.findElement(By.name("makeId"));
        select=new Select(make);
        select.selectByValue("20070");
        Thread.sleep(1000);

        WebElement model = driver.findElement(By.name("modelId"));
        select=new Select(model);
        select.selectByValue("21027");
        Thread.sleep(1000);

        WebElement maxPrice = driver.findElement(By.name("priceMax"));
        select=new Select(maxPrice);
        select.selectByValue("50000");
        Thread.sleep(1000);

        WebElement radius = driver.findElement(By.name("radius"));
        select = new Select(radius);
        select.selectByValue("50");
        Thread.sleep(1000);


        WebElement zip = driver.findElement(By.name("zip"));
        zip.clear();
        zip.sendKeys("60016");
        Thread.sleep(1000);

        WebElement search = driver.findElement(By.xpath("//input[@value='Search']"));
        search.click();
        Thread.sleep(5000);

        List<WebElement> results = driver.findElements(By.className("listing-row__title"));
        System.out.println(results.size());
        Assert.assertTrue(results.size()<=20);


        List<String> texts = new ArrayList<>();
        for (WebElement text:results){
            texts.add(text.getText());
            System.out.println("car Name :" + text.getText());
            if (!text.getText().contains("Lexus ES 350")){
                System.out.println(text.getText() + "Does not contain Lexus ES 350");
            }


        }

        List<WebElement> miles = driver.findElements(By.className("listing-row__distance"));
        List<String> distance = new ArrayList<>();
        for (WebElement dist:miles){
            String str =dist.getText().substring(0,dist.getText().indexOf(" "));
            distance.add(str);
            double dbl = Double.parseDouble(str);
            Assert.assertTrue(dbl<=50);

        }
        WebElement sort = driver.findElement(By.className("select-sort-options"));
        select=new Select(sort);
        select.selectByValue("price-highest");
        Thread.sleep(2000);

        List<WebElement> prices = driver.findElements(By.className("listing-row__price"));
       String str2 = prices.get(0).getText().substring(1).replace(",","");
       double dbl2 = Double.parseDouble(str2);
       Assert.assertTrue(dbl2<=50000);










    }

}
