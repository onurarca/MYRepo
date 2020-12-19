package selenium_class;

import Utils.Driver;
import Utils.PayloadUtils;
import Utils.PropertyReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class JiraTest {


    @Test
    public void test(){
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

        Assert.assertTrue(driver.getTitle().contains("Tec board"));


    }


    @Test
    public void apiTest(){
        String summary = "API: Create payment return wrong status code";
        String description = "AC: Fix Status code to retun 201";
        String issueType = "Story";

        Response response = given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .cookie("JSESSIONID","2F2C0666EDF93430D573D71610F5CAB8")
                .body(PayloadUtils.getJiraStoryPayload(summary,description,issueType))
                .when().post("http://localhost:8080/rest/api/2/issue")
                .then().statusCode(201).log().all().extract().response();


    }
}
