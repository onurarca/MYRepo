package selenium_class.ActionsPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SliderPractice {


    @Test
    public void validateHerokuAppSlider() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");

        WebElement slider = driver.findElement(By.xpath("//input[@type = 'range']"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(slider)
                .moveByOffset(10, 0)
                .release()
                .perform();


    }

    @Test
    public void moveSlider() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");

        WebElement slider = driver.findElement(By.xpath("//input[@type = 'range']"));
        WebElement text = driver.findElement(By.id("range"));

        moveTarget(driver, slider, text, "5");


    }

    public void moveTarget(WebDriver driver, WebElement element, WebElement textElement, String target) {

        Actions actions = new Actions(driver);
        actions.clickAndHold(element).perform();
        Double db = Double.parseDouble(target);
        if (db > 2.5) {
            int xCord = 10;
            while (textElement.getText().equals(target)) {
                actions.moveByOffset(xCord, 0)
                        .perform();
                xCord += 10;
            }
        } else if (db < 2.5) {
            int xCord = -10;
            while (textElement.getText().equals(target)) {
                actions.moveByOffset(xCord, 0)
                        .perform();
                xCord += -10;

            }


        }else if (db ==2.5){
            actions.clickAndHold(element).perform();

        }


    }

    public static class KeyPractice {

        @Test
        public void ValidateGoogleSearch(){
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.google.com/");
            Actions actions = new Actions(driver);
            //Keys -->pressable keys on the keyboard which is not text

            WebElement searchBox = driver.findElement(By.name("q"));
           actions.moveToElement(searchBox)
                   .click(searchBox)
                   .keyDown(searchBox, Keys.SHIFT)
                   .sendKeys("selenium")
                   .keyUp(searchBox,Keys.SHIFT)
                   .doubleClick()
                   .contextClick()
                   .perform();

            searchBox.sendKeys(Keys.ARROW_DOWN);
            searchBox.sendKeys(Keys.ARROW_DOWN);
            searchBox.sendKeys(Keys.ENTER);



        }
    }
}
