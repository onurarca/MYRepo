package selenium_class.ProjectDay;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class ProjectDay3 {

    @Test
    public void case1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("http://automationpractice.com/index.php");

        WebElement cartEmpty = driver.findElement(By.className("ajax_cart_no_product"));
        Assert.assertEquals(cartEmpty.getText(),"(empty)");



        List<WebElement> price = driver.findElements(By.xpath("//div[@class='right-block']//span[@class='price product-price']"));

        List<Double> elements = new ArrayList<>();
        double dbl;
        for (WebElement prices: price){
            if (prices.getText().length()>2){
           dbl=Double.parseDouble(prices.getText().substring(1));
            elements.add(dbl);
            }

        }
        Collections.sort(elements);
        System.out.println(elements.get(0));

        int orderNum=0;
        for (int i=0; i< price.size(); i++){
            if (price.get(i).getText().length()>2){
                if (Double.parseDouble(price.get(i).getText().replace("$",""))==elements.get(0)){
                    orderNum=i;
                }
            }
        }
List<WebElement> productNm = driver.findElements(By.xpath("//h5[@itemprop='name']/a"));
        System.out.println(productNm.get(orderNum).getText());

        List<WebElement> discount = driver.findElements(By.xpath("//div[@class='right-block']//div[@class='content_price']"));
        String str =discount.get(orderNum).getText().substring(discount.get(orderNum).getText().indexOf("-"));
        System.out.println(str);
       String orginalP = discount.get(orderNum).getText().substring(discount.get(orderNum).getText().indexOf(" "),discount.get(orderNum).getText().indexOf("-"));
        String temp4 ="";
        for (int i =0; i<orginalP.length(); i++){
            if (Character.isDigit(orginalP.charAt(i))||orginalP.charAt(i)=='.'){
                temp4=temp4+orginalP.charAt(i);
            }
        }
        double originalPriceFinal = Double.parseDouble(temp4);
        System.out.println(originalPriceFinal);
        String temp ="";
        for (int i =0; i<str.length(); i++){
            if (Character.isDigit(str.charAt(i))){
                temp=temp+str.charAt(i);
            }
        }
        double temp2 = Double.parseDouble(temp);
        double remainder = (100-temp2)/100;
        BigDecimal bd = new BigDecimal(originalPriceFinal*remainder).setScale(1, RoundingMode.DOWN);
        double expectedDblTotal = bd.doubleValue();
        double dbbblll = expectedDblTotal;
        double actual =elements.get(0);
        Assert.assertEquals(actual,dbbblll);


    }
    public static void getElement(WebElement element){

    }

    @Test
    public void case2(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("http://automationpractice.com/index.php");
       List<WebElement> prices = driver.findElements(By.xpath("//div[@class='right-block']//span[@class='price product-price']"));
       List<String> elementPrices = new ArrayList<>();
       for (WebElement price: prices){
           elementPrices.add(price.getText());
       }
        Set<String> elementOrder = new TreeSet<String>(elementPrices);
       List <String> elementPrice = new ArrayList<>();
       for (String elem : elementOrder){
           elementPrice.add(elem);
       }
        System.out.println("Expencive product price is : " + elementPrice.get(elementPrice.size()-1));
       int indexOfPrice = elementPrices.indexOf(elementPrice.get(elementPrice.size()-1));
       List<WebElement> names = driver.findElements(By.xpath("//a[@class='product-name']"));
       List<String> namesString = new ArrayList<>();
       for (WebElement name : names){
           namesString.add(name.getText());
       }

        System.out.println("Product name is : " + namesString.get(indexOfPrice));




    }
}
