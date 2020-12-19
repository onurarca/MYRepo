package selenium_class.ActionsPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class ActionsIntro {

    @Test
    public void testA(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/context_menu");

        WebElement box = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(box).perform();







    }


    @Test
    public void testB()throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/hovers");

        List<WebElement> headers = driver.findElements(By.xpath("//h5"));
        for (WebElement header :headers){
            System.out.println("Header : " + header.getText());
        }

        List<WebElement> images = driver.findElements(By.xpath("//div[@id='content']//img"));
        Actions actions =new Actions(driver);

        for (int i =0 ;i<images.size(); i++){
            actions.moveToElement(images.get(i)).perform();
            System.out.println("Header : " +headers.get(i).getText());


        }




    }

    @Test
    public void testC(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.primefaces.org/showcase/ui/misc/effect.xhtml");

        Actions actions = new Actions(driver);

        List<WebElement> texts = driver.findElements(By.xpath("//div[@class='content-section content-implementation ']/table//div[@class='ui-panel-content ui-widget-content']"));
        for (WebElement text :texts){
            System.out.println(text.getText());
            switch (text.getText()){
                case "click":
                    text.click();
                    break;
                case "doubleclick":
                    actions.doubleClick().perform();
                    break;
            }
        }



    }
    public static void main(String[] args) {

       int x =6;
       boolean y =(x>=6)|(++x<=7);
        System.out.println(x);

    }




}
