package selenium_class.HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HomeWork5 {

    @Test
    public void case1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");
        Actions actions = new Actions(driver);

        WebElement blueBall = driver.findElement(By.id("draggable"));
        actions.clickAndHold(blueBall).moveByOffset(-10,0).perform();

        WebElement blueBox = driver.findElement(By.className("test1"));
        String expectedText = "(Drop here)";
        Assert.assertEquals(blueBox.getText(),expectedText);
        WebElement orangeBox = driver.findElement(By.className("test2"));
        Assert.assertEquals(orangeBox.getText(),expectedText);

    }

    @Test
    public void case2()throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");
        try {
            Thread.sleep(1000);
            WebElement cookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
            cookies.click();
            Thread.sleep(1000);
        }catch (Exception e){

        }
        Actions actions = new Actions(driver);
        WebElement blueBox = driver.findElement(By.className("test1"));

        WebElement blueBall = driver.findElement(By.id("draggable"));
        actions.clickAndHold(blueBall).moveToElement(blueBox).pause(2000).perform();
        blueBox = driver.findElement(By.className("test1"));
        String actualText = blueBox.getText();
        String expectedText = "Now you can drop it.";

        Assert.assertEquals(actualText,expectedText);
        WebElement orangeBox = driver.findElement(By.className("test2"));
        Assert.assertEquals(orangeBox.getText(),"(Drop here)");

    }

    @Test
    public void case3(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");
        try {
            Thread.sleep(1000);
            WebElement cookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
            cookies.click();
            Thread.sleep(1000);
        }catch (Exception e){

        }
        Actions actions = new Actions(driver);
        WebElement orangeBox = driver.findElement(By.className("test2"));

        WebElement blueBall = driver.findElement(By.id("draggable"));
        actions.clickAndHold(blueBall).moveToElement(orangeBox).pause(2000).perform();
        orangeBox = driver.findElement(By.className("test2"));
        String actualText = orangeBox.getText();
        String expectedText = "Now you can drop it.";

        Assert.assertEquals(actualText,expectedText);
        WebElement blueBox = driver.findElement(By.className("test1"));
        Assert.assertEquals(blueBox.getText(),"(Drop here)");

    }

    @Test
    public void case4()throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://demo.guru99.com/test/drag_drop.html");
        Actions actions = new Actions(driver);

        WebElement element = driver.findElement(By.xpath("//li[@data-id='1']//a"));
        actions.clickAndHold(element).moveByOffset(-10,0).perform();

        WebElement text = driver.findElement(By.xpath("//div[@class='e14']"));
        Assert.assertTrue(text.isEnabled());
        actions.release(element).perform();
        WebElement first5K = driver.findElement(By.xpath("//li[@data-id='1']/following-sibling::li[@data-id='2']//a"));
        WebElement target = driver.findElement(By.xpath("//ol[@id = 'amt7']//li"));
        actions.dragAndDrop(first5K,target).perform();


        WebElement debitMovement = driver.findElement(By.xpath("//div[@id = 't7']"));
        String actualDM = debitMovement.getText();


        Assert.assertEquals(actualDM,"5000");
        WebElement creditMovement = driver.findElement(By.xpath("//div[@id = 't8']"));
        String actualCM = creditMovement.getText();
        Assert.assertEquals(actualCM,"0");

        WebElement second5K = driver.findElement(By.xpath("//li[@data-id='3']/following-sibling::li[@data-id='2']//a"));
        WebElement targetAmount = driver.findElement(By.id("amt8"));

        actions.dragAndDrop(second5K,targetAmount).perform();
        Assert.assertEquals(actualDM,"5000");
        creditMovement = driver.findElement(By.xpath("//div[@id = 't8']"));
        actualCM = creditMovement.getText();
        Assert.assertEquals(actualCM,"5000");

        WebElement bank = driver.findElement(By.xpath("//li[@data-id='2']/following-sibling::li[@data-id='5']//a"));
        WebElement bankTarget = driver.findElement(By.xpath("//ol[@id='bank']//li"));

        actions.dragAndDrop(bank,bankTarget).perform();
        bankTarget = driver.findElement(By.xpath("//ol[@id='bank']//li"));
        String bankTargetText = bankTarget.getText();
        Assert.assertEquals(bankTargetText,"BANK");

        WebElement sales = driver.findElement(By.xpath("//li[@data-id='5']/following-sibling::li[@data-id='6']//a"));
        WebElement salesTarget = driver.findElement(By.id("loan"));

        actions.dragAndDrop(sales,salesTarget).perform();
        salesTarget = driver.findElement(By.id("loan"));
        String salesTargetText = salesTarget.getText();
        Assert.assertEquals(salesTargetText,"SALES");



    }

    public static String getCurrentDate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M dd yyyy ");
        LocalDateTime now = LocalDateTime.now();
        String currentDate = dtf.format(now);
        String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
       int indexMonth = Integer.parseInt(currentDate.substring(0,currentDate.indexOf(" ")));

       String currentActualDate = months[indexMonth-1]+","+currentDate.substring(currentDate.indexOf(" "));
       return currentActualDate;


    }

    @Test
    public void case5(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://www.popuptest.com/popuptest4.html");
        String currentWindowID = driver.getWindowHandle();
        Actions actions = new Actions(driver);
        WebElement mouseOver = driver.findElement(By.xpath("//a[contains(text(),'Mouseover PopUp')]"));
        actions.moveToElement(mouseOver).perform();

        Set<String> ids = driver.getWindowHandles();
      Assert.assertEquals(ids.size(),3);
        String currentDate = getCurrentDate();
        for (String title : ids){
            if (!(!title.equals(currentWindowID)) && driver.getTitle().contains(currentDate)){

            }
            driver.switchTo().window(title);
        }
        SoftAssert softAssert = new SoftAssert();
        List<String> listOfIDS = new ArrayList<>();
        for (String id :ids){
            listOfIDS.add(id);
        }
        for (int i =1 ; i<ids.size(); i++){
            if (!listOfIDS.get(i).equals(currentWindowID)&& i==1){
                Assert.assertTrue(driver.getCurrentUrl().contains("popup9"));

            } else if (!listOfIDS.get(i).equals(currentWindowID)&& i==2){
                Assert.assertTrue(driver.getCurrentUrl().contains("popup10"));;
            }

            driver.switchTo().window(listOfIDS.get(i));
        }


    }

    @Test
    public void case6()throws InterruptedException{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://seleniumpractise.blogspot.com/2017/");
        String currentPageID = driver.getWindowHandle();


        WebElement faceBook = driver.findElement(By.xpath("//a[@href = 'https://www.facebook.com']"));
        faceBook.click();
        Set<String> ids = driver.getWindowHandles();
        for (String id : ids){
            if (!id.equals(currentPageID)){
                driver.switchTo().window(id);
            }
        }

        WebElement createAccount = driver.findElement(By.id("u_0_2"));
        createAccount.click();
        Thread.sleep(1000);
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Techtorial");
        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Academy");
        WebElement phoneNum = driver.findElement(By.name("reg_email__"));
        phoneNum.sendKeys("2223334455");
        WebElement password = driver.findElement(By.name("reg_passwd__"));
        password.sendKeys("techtorial123");
        WebElement month = driver.findElement(By.name("birthday_month"));
        Select select = new Select(month);
        select.selectByValue("4");
        WebElement day = driver.findElement(By.name("birthday_day"));
        select = new Select(day);
        select.selectByIndex(20);
        WebElement year = driver.findElement(By.name("birthday_year"));
        select= new Select(year);
        select.selectByVisibleText("2002");
        WebElement sex = driver.findElement(By.xpath("//input[@value='-1']"));
        sex.click();
        driver.close();
        driver.switchTo().window(currentPageID);
        String expectedTitle = "Selenium Practise: 2017";
        Assert.assertEquals(driver.getTitle(),expectedTitle);









    }



}
