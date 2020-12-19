package selenium_class.HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class HomeWork3 {

    @Test
    public void case1(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        WebElement logIn = driver.findElement(By.id("login-button"));
        logIn.click();

        WebElement zToA = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(zToA);
        select.selectByValue("za");

        List<WebElement> names = driver.findElements(By.className("inventory_item_name"));
        List<String> actualTitles = new ArrayList<>();
        for (WebElement title : names){
            actualTitles.add(title.getText());
        }
        Set<String> descending = new TreeSet<>(actualTitles);
        List<String>reversedTreeSet = new ArrayList<>(descending);
        Collections.reverse(reversedTreeSet);

        Assert.assertEquals(reversedTreeSet,actualTitles);




        }
        @Test
        public void case2(){
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.saucedemo.com/");

            WebElement userName = driver.findElement(By.id("user-name"));
            userName.sendKeys("standard_user");
            WebElement password = driver.findElement(By.id("password"));
            password.sendKeys("secret_sauce");
            WebElement logIn = driver.findElement(By.id("login-button"));
            logIn.click();

            WebElement lowToHigh = driver.findElement(By.className("product_sort_container"));
            Select select = new Select(lowToHigh);
            select.selectByIndex(2);

            List<WebElement> prices = driver.findElements(By.className("inventory_item_price"));
            List<Double> actualPrices = new ArrayList<>();
            double dbl;
            for (WebElement price:prices){
                dbl=Double.parseDouble(price.getText().substring(1));
              actualPrices.add(dbl);

            }

            List<Double> expected = new ArrayList<>(actualPrices);
            Collections.sort(expected);

            Assert.assertEquals(expected,actualPrices);







        }

        @Test
        public void task()throws InterruptedException{
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.saucedemo.com/");

            WebElement userName = driver.findElement(By.id("user-name"));
            userName.sendKeys("standard_user");
            WebElement password = driver.findElement(By.id("password"));
            password.sendKeys("secret_sauce");
            WebElement logIn = driver.findElement(By.id("login-button"));
            logIn.click();

            WebElement openMenu = driver.findElement(By.xpath("//button[.='Open Menu']"));
            openMenu.click();
            Thread.sleep(1000);

            WebElement logOut = driver.findElement(By.id("logout_sidebar_link"));
            logOut.click();

            driver.navigate().back();
            String currentPage =driver.getCurrentUrl();
            String loginPage ="https://www.saucedemo.com/";

            if (currentPage.equals(loginPage)){
                System.out.println("Driver is pointing to log in page");
            }else{
                System.out.println("Driver is not pointing to correct page");
            }
            Assert.assertEquals(currentPage,loginPage);




        }

        @Test
    public void test3(){
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.saucedemo.com/");

            WebElement userName = driver.findElement(By.id("user-name"));
            userName.sendKeys("standard_user");
            WebElement password = driver.findElement(By.id("password"));
            password.sendKeys("secret_sauce");
            WebElement logIn = driver.findElement(By.id("login-button"));
            logIn.click();

            WebElement lowToHigh = driver.findElement(By.className("product_sort_container"));
            Select select = new Select(lowToHigh);
            select.selectByIndex(2);
            WebElement addCartBtn = driver.findElement(By.xpath("//div[@class='pricebar']//button[1]"));
            addCartBtn.click();
            List<WebElement> element = driver.findElements(By.className("inventory_item_name"));
            List<String> actualElements = new ArrayList<>();
            for (WebElement elem:element){
                actualElements.add(elem.getText());
            }
            String firstElementText =actualElements.get(0);

            WebElement shoppingCart = driver.findElement(By.id("shopping_cart_container"));
            shoppingCart.click();

            WebElement checkItem = driver.findElement(By.className("inventory_item_name"));
            Assert.assertEquals(checkItem.getText(),firstElementText);






        }

        @Test
    public void case4(){

            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.saucedemo.com/");

            WebElement userName = driver.findElement(By.id("user-name"));
            userName.sendKeys("standard_user");
            WebElement password = driver.findElement(By.id("password"));
            password.sendKeys("secret_sauce");
            WebElement logIn = driver.findElement(By.id("login-button"));
            logIn.click();

            WebElement lowToHigh = driver.findElement(By.className("product_sort_container"));
            Select select = new Select(lowToHigh);
            select.selectByVisibleText("Price (high to low)");

            List<WebElement> items= driver.findElements(By.xpath("//button[contains(text(),'ADD')]"));
            items.get(0).click();
            items.get(1).click();

            WebElement shoppingCart = driver.findElement(By.id("shopping_cart_container"));
            shoppingCart.click();

            WebElement checkOut = driver.findElement(By.xpath("//a[@class='btn_action checkout_button']"));
            checkOut.click();

            WebElement fname = driver.findElement(By.id("first-name"));
            fname.sendKeys("Onur");

            WebElement lname = driver.findElement(By.id("last-name"));
            lname.sendKeys("Arca");

            WebElement zip = driver.findElement(By.id("postal-code"));
            zip.sendKeys("78748");

            WebElement ctn = driver.findElement(By.xpath("//input[@class='btn_primary cart_button']"));
            ctn.click();

            WebElement itemTotal = driver.findElement(By.className("summary_subtotal_label"));
           String str= itemTotal.getText();
           String temp ="";
           int count =0;
            while (count<str.length()){
                if (Character.isDigit(str.charAt(count))||str.charAt(count)=='.'){
                    temp=temp+str.charAt(count);
                }
                ++count;
            }
            double dblItemTotal = Double.parseDouble(temp);

            WebElement taxTotal = driver.findElement(By.className("summary_tax_label"));
            String str2= taxTotal.getText();
            String temp2 ="";
            int count2 =0;
            while (count2<str2.length()){
                if (Character.isDigit(str2.charAt(count2))||str2.charAt(count2)=='.'){
                    temp2=temp2+str2.charAt(count2);
                }
                ++count2;
            }
            double dblTaxTotal = Double.parseDouble(temp2);

            WebElement total = driver.findElement(By.className("summary_total_label"));
            String str3= total.getText();
            String temp3 ="";
            int count3 =0;
            while (count3<str3.length()){
                if (Character.isDigit(str3.charAt(count3))||str3.charAt(count3)=='.'){
                    temp3=temp3+str3.charAt(count3);
                }
                ++count3;
            }
            double dblTotal = Double.parseDouble(temp3);
            BigDecimal bd = new BigDecimal(dblItemTotal+dblTaxTotal).setScale(2, RoundingMode.DOWN);
            double expectedDblTotal = bd.doubleValue();

            Assert.assertEquals(dblTotal,expectedDblTotal);

        }

    }



