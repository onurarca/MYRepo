package selenium_class.slack.tests;

import Utils.PayloadUtils;
import io.restassured.http.ContentType;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium_class.slack.TestBaseForSlack;
import selenium_class.slack.pages.SlackSignInPage;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Set;

import static io.restassured.RestAssured.given;

public class SlackTest  extends TestBaseForSlack {

    String message = "This is Oscar";

    @Test
    public void test() throws InterruptedException, AWTException {
        setup("chrome");

        SlackSignInPage slackSignInPage = new SlackSignInPage(driver);
        driver.get("https://techtorialbatch6.slack.com/?redir=%2Fgantry%2Fclient");
        slackSignInPage.emailField.sendKeys("onurarca@gmail.com");
        slackSignInPage.password.sendKeys("217055");
        slackSignInPage.signInButton.click();
        Thread.sleep(5000);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        Thread.sleep(3000);

        slackSignInPage = new SlackSignInPage(driver);
        slackSignInPage.continueToBrowserLink.click();

        String windowHandle = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        for (String h : windows){
            if (h.equals(windowHandle)){
                driver.switchTo().window(h);

            }
        }

        slackSignInPage.apiChannel.click();
        slackSignInPage.messageField.sendKeys(message);
        slackSignInPage.sendMessageButton.click();

        verifyUIMessage(message);


    }

    private void verifyUIMessage(String slackmessage){
    SlackSignInPage slackSignInPage = new SlackSignInPage(driver);
        boolean isMessageSent = false;
        for (WebElement messages:slackSignInPage.apiChannelMessageList){
            if (messages.getText().equals(slackmessage)){
                isMessageSent=true;

            }
        }
        Assert.assertTrue(isMessageSent);
    }

    @Test
    public void apiUITest() throws AWTException {
        String slackMessage = "Sent from Java Code Again, And This is Jack (Again)";
        String payload = PayloadUtils.getSlackMessagePayload(slackMessage);

        given().accept(ContentType.JSON).contentType(ContentType.JSON).body(payload)
                .auth().oauth2("xoxb-1265938717187-1552841584019-5RRWy3TMd86ukXjHRpMpKM6Q")
                .when().post("https://slack.com/api/chat.postMessage")
                .then().statusCode(200);

        setup("chrome");

        driver.get("https://techtorialbatch6.slack.com/?redir=%2Fgantry%2Fclient");
        SlackSignInPage slackSignInPage = new SlackSignInPage(driver);
        slackSignInPage.emailField.sendKeys("onurarca@gmail.com");
        slackSignInPage.password.sendKeys("217055");
        slackSignInPage.signInButton.click();

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(slackSignInPage.continueToBrowserLink)).click();
        wait.until(ExpectedConditions.visibilityOf(slackSignInPage.apiChannel)).click();

        verifyUIMessage(slackMessage);

    }

}
