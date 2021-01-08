package selenium_class;

import Utils.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class JiraTest {




    @Test
    public void test() throws InterruptedException {
        WebDriver driver = Driver.getDriver("chrome");
        driver.get("http://localhost:8080");

        WebElement usernameField = driver.findElement(By.id("login-form-username"));
        WebElement passwordField = driver.findElement(By.id("login-form-password"));

        usernameField.sendKeys(PropertyReader.readPropertyByKey("username2"));
        passwordField.sendKeys(PropertyReader.readPropertyByKey("password2"));

        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();

        WebElement boardButton = driver.findElement(By.id("greenhopper_menu"));
        boardButton.click();

        WebElement tecBoard = driver.findElement(By.id("rapidb_lnk_1_lnk"));
        tecBoard.click();
        Thread.sleep(3000);

        Assert.assertTrue(driver.getTitle().contains("TEC board"));




    }


    @Test
    public void apiTest(){



        String summary = "API: Create payment return wrong status code V3";
        String description = "AC: Fix Status code to return 201";
        String issueType = "Story";

        Response response = given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .cookie("JSESSIONID", JiraUtils.getSessionId())
                .body(PayloadUtils.getJiraStoryPayload(summary, description, issueType))
                .when().post("http://localhost:8080/rest/api/2/issue")
                .then().statusCode(201).log().all().extract().response();
       String storyKey = response.jsonPath().getString("key");

        WebDriver driver = Driver.getDriver("chrome");
        driver.get("http://localhost:8080");

        WebElement usernameField = driver.findElement(By.id("login-form-username"));
        WebElement passwordField = driver.findElement(By.id("login-form-password"));

        usernameField.sendKeys(PropertyReader.readPropertyByKey("username2"));
        passwordField.sendKeys(PropertyReader.readPropertyByKey("password2"));

        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();

        WebElement boardButton = driver.findElement(By.id("greenhopper_menu"));
        boardButton.click();

        WebElement tecBoard = driver.findElement(By.id("rapidb_lnk_1_lnk"));
        tecBoard.click();

        WebElement backlog = driver.findElement(By.xpath("//span[@class='aui-icon aui-icon-large agile-icon-plan aui-iconfont-backlog']"));
        backlog.click();

        Assert.assertTrue(driver.getTitle().contains("TEC board"));


       WebElement userStory = driver.findElement(By.xpath("//*[@title='" + storyKey + "']"));
        Actions actions = new Actions(driver);
        actions.keyDown(userStory,Keys.CONTROL).click().perform();

        BrowserUtils.switchByID(driver,driver.getWindowHandle());

        WebElement summaryActual = driver.findElement(By.id("summary-val"));
        WebElement descriptionActual = driver.findElement(By.xpath("//div[@class='user-content-block']"));

        Assert.assertEquals(summaryActual.getText(),summary);
        Assert.assertEquals(descriptionActual.getText(),description);



    }

    @Test
    public void createBug(){
        WebDriver driver = Driver.getDriver("chrome");
        driver.get("http://localhost:8080");

        WebElement usernameField = driver.findElement(By.id("login-form-username"));
        WebElement passwordField = driver.findElement(By.id("login-form-password"));

        usernameField.sendKeys(PropertyReader.readPropertyByKey("username2"));
        passwordField.sendKeys(PropertyReader.readPropertyByKey("password2"));

        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();

        WebElement boardButton = driver.findElement(By.id("greenhopper_menu"));
        boardButton.click();

        WebElement tecBoard = driver.findElement(By.id("rapidb_lnk_1_lnk"));
        tecBoard.click();

        WebElement backlog = driver.findElement(By.xpath("//span[@class='aui-icon aui-icon-large agile-icon-plan aui-iconfont-backlog']"));
        backlog.click();

        WebElement createButton = driver.findElement(By.id("create_link"));
        createButton.click();

        WebElement issueTypeField = driver.findElement(By.id("issuetype-field"));
        issueTypeField.click();
        issueTypeField.sendKeys("Bug", Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement summaryField = driver.findElement(By.id("summary"));
        String summary = "UI: Create a bug from UI V3";
        String description = "AC: Fix Summary and Description.";
        wait.until(ExpectedConditions.visibilityOf(summaryField)).sendKeys(summary);


        driver.switchTo().frame("mce_7_ifr");

        WebElement descBody = driver.findElement(By.id("tinymce"));
        descBody.sendKeys(description);
        driver.switchTo().defaultContent();
        WebElement createIssueButton = driver.findElement(By.id("create-issue-submit"));
        createIssueButton.click();



    }
}
