package selenium_class.SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FirefoxTest {

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver","geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        driver.get("https://the-internet.herokuapp.com/");

        List<WebElement> links = driver.findElements(By.xpath("//li/a"));
        ArrayList<String> webOrder = new ArrayList<>();
        for (WebElement link : links){
            webOrder.add(link.getText());

        }
        Set<String> ascending = new TreeSet<>(webOrder);
        ArrayList<String> ascendingList = new ArrayList<>(ascending);
        boolean isAscending = true;

        for (int i =0; i<webOrder.size(); i++){

            if (!webOrder.get(i).equals(ascendingList.get(i))){
                System.out.println("the tex is not ascending ordered.");
                isAscending=false;
                break;
            }
            }
        System.out.println(isAscending);
        }






    }

