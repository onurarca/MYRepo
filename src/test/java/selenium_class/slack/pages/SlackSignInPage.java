package selenium_class.slack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium_class.slack.TestBaseForSlack;

import java.util.List;

public class SlackSignInPage {

    public SlackSignInPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@href='/workspace-signin']")
    public WebElement signInManually;


    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailField;

    @FindBy(xpath = "//input[@id = 'domain']")
    public WebElement workspace;

    @FindBy(xpath = "//input[@id = 'password']")
    public WebElement password;

    @FindBy(xpath = "//button[.='Continue']")
    public WebElement continueButton;

    @FindBy(id = "signin_btn")
    public WebElement signInButton;

    @FindBy(xpath = "//button[@data-qa='continue_in_browser']")
    public WebElement continueToBrowserLink;

    @FindBy(xpath = "//span[@data-qa='channel_sidebar_name_api']")
    public WebElement apiChannel;

    @FindBy(xpath = "//div[@class='ql-placeholder']")
    public WebElement messageField;

    @FindBy(xpath = "//button[@aria-label='Send message']")
    public WebElement sendMessageButton;

    @FindBy(xpath = "//div[@class='c-message_kit__blocks c-message_kit__blocks--rich_text']")
    public List<WebElement> apiChannelMessageList;

}
