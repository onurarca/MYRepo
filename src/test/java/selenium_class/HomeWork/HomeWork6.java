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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HomeWork6 {

    WebDriver driver;

    @BeforeClass
    public void initializeDriver(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    }

    @Test
    public void case1(){
        driver.get("http://demo.openemr.io/openemr/interface/login/login.php?site=default");
        Actions actions = new Actions(driver);

        WebElement userName = driver.findElement(By.id("authUser"));
        userName.sendKeys("admin");
        WebElement password = driver.findElement(By.id("clearPass"));
        password.sendKeys("pass");
        WebElement login = driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']"));
        login.click();

        driver.switchTo().frame("left_nav");

        WebElement searchBox = driver.findElement(By.className("inputtext"));
        searchBox.sendKeys("Belford");
        searchBox.sendKeys(Keys.ENTER);

        driver.switchTo().parentFrame();


        driver.switchTo().frame("RTop");

        WebElement patientName = driver.findElement(By.xpath("//td[@class='srName']"));
        String name = "Belford Phil";
        String actualName =patientName.getText();
        actualName=actualName.replace(",","");
        Assert.assertEquals(actualName,name );

        WebElement socialSec = driver.findElement(By.xpath("//td[@class='srSS']"));
        Assert.assertTrue(socialSec.isDisplayed());
        WebElement phoneNum = driver.findElement(By.xpath("//td[@class='srPhone']"));
        Assert.assertTrue(phoneNum.isDisplayed());

        WebElement externalID = driver.findElement(By.xpath("//td[@class='srID']"));
        String idNum = externalID.getText();
        externalID.click();
        WebElement actualId = driver.findElement(By.id("text_pubpid"));
        Assert.assertEquals(actualId.getText(),idNum);
        WebElement dob = driver.findElement(By.id("text_DOB"));
        Assert.assertTrue(dob.isDisplayed());
        String dobYear = dob.getText().substring(0,4);
        int year = Integer.parseInt(dobYear);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy");
        LocalDateTime now = LocalDateTime.now();
        String currentDateYear = dtf.format(now);
        int currentYear = Integer.parseInt(currentDateYear);
        int age = currentYear-year;
        String ageAsString = String.valueOf(age);

        driver.switchTo().parentFrame();

        driver.switchTo().frame("Title");

        WebElement actualAge = driver.findElement(By.xpath("//span[@id='current_patient']"));
        String ageUpdated = actualAge.getText();
        ageUpdated=ageUpdated.substring((ageUpdated.indexOf("Age:"))+5);
        Assert.assertEquals(ageUpdated,ageAsString);



    }


    @Test
    public void case2(){

        driver.get("http://demo.openemr.io/openemr/interface/login/login.php?site=default");
        Actions actions = new Actions(driver);
        WebElement username = driver.findElement(By.id("authUser"));
        username.sendKeys("admin");
        WebElement password = driver.findElement(By.id("clearPass"));
        password.sendKeys("pass");
        WebElement loginButton = driver.findElement(By.xpath("//button[@onclick='transmit_form()']"));
        loginButton.click();
        driver.switchTo().frame("left_nav");
        WebElement searchBox = driver.findElement(By.className("inputtext"));
        actions.sendKeys(searchBox,"Belford").sendKeys(Keys.ENTER).perform();
        driver.switchTo().parentFrame();
        driver.switchTo().frame("RTop");
        WebElement element = driver.findElement(By.xpath("//td[@class='srName']"));
        actions.click(element).perform();
        WebElement editButton = driver.findElement(By.xpath("//a[@href='pnotes_full.php?form_active=1']"));
        editButton.click();
        WebElement addButton = driver.findElement(By.xpath("//a[@href='pnotes_full_add.php?docid=0&orderid=0']"));
        addButton.click();
        driver.switchTo().frame("modalframe");
        WebElement typeOption = driver.findElement(By.xpath("//select[@id='form_note_type']"));
        Select select = new Select(typeOption);
        select.selectByValue("Lab Results");
        WebElement assignedTo = driver.findElement(By.xpath("//select[@name='assigned_to']"));
        select = new Select(assignedTo);
        select.selectByVisibleText("Stone, Fred");

        WebElement noteSection = driver.findElement(By.id("note"));
        noteSection.sendKeys("This is for testing");

        WebElement saveMessage= driver.findElement(By.xpath("//a[@id='newnote']"));
        saveMessage.click();

        driver.switchTo().parentFrame();

        WebElement noteCell = driver.findElement(By.xpath("//td[@class='notecell'][1]"));
        Assert.assertFalse(noteCell.getText().isEmpty());

        WebElement activeBox = driver.findElement(By.xpath("//td[@class='text bold']//input[@type='checkbox']"));
        Assert.assertTrue(activeBox.isEnabled());

        WebElement typeText = driver.findElement(By.xpath("//a[@class='note_modal']"));
        Assert.assertEquals(typeText.getText(),"Lab Results");


        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        String currentDateYear = dtf.format(now);
       System.out.println(currentDateYear);

        noteCell = driver.findElement(By.xpath("//td[@class='notecell'][1]"));

        String actualDate = noteCell.getText().substring(0,noteCell.getText().indexOf(" "));
       Assert.assertEquals(actualDate,currentDateYear);

        WebElement status = driver.findElement(By.xpath("//td[@class='notecell'][2]"));
        Assert.assertEquals(status.getText(),"New");

        WebElement updateBy = driver.findElement(By.xpath("//td[@class='notecell'][4]"));
        Assert.assertNotEquals(updateBy.getText(), "BILLY SMITH");


    }

    @Test
    public void case3 (){

        driver.get("http://demo.openemr.io/openemr/interface/login/login.php?site=default");
        Actions actions = new Actions(driver);
        WebElement username = driver.findElement(By.id("authUser"));
        username.sendKeys("admin");
        WebElement password = driver.findElement(By.id("clearPass"));
        password.sendKeys("pass");
        WebElement loginButton = driver.findElement(By.xpath("//button[@onclick='transmit_form()']"));
        loginButton.click();
        driver.switchTo().frame("left_nav");
        WebElement searchBox = driver.findElement(By.className("inputtext"));
        actions.sendKeys(searchBox,"Belford").sendKeys(Keys.ENTER).perform();

        driver.switchTo().parentFrame();
        driver.switchTo().frame("RTop");
        WebElement element = driver.findElement(By.xpath("//td[@class='srName']"));
        actions.click(element).perform();

        WebElement amendment = driver.findElement(By.xpath("//span[.='Amendments']/following-sibling::span"));
        amendment.click();
        Assert.assertEquals(amendment.getText(),"expand");
        amendment.click();
        Assert.assertEquals(amendment.getText(),"collapse");

        WebElement editButton = driver.findElement(By.xpath("//span[.='Amendments']/../../preceding-sibling::td//a//span"));
        editButton.click();

        driver.switchTo().frame("modalframe");

        WebElement amendmentRequestText= driver.findElement(By.xpath("//span[.='List']/following-sibling::span"));
        Assert.assertEquals(amendmentRequestText.getText(),"No amendment requests available");
        String color = amendmentRequestText.getCssValue("color");
        Assert.assertEquals(color,"rgba(255, 0, 0, 1)");

        WebElement addButton = driver.findElement(By.xpath("//button[.='Add']"));
        addButton.click();

    }


}
