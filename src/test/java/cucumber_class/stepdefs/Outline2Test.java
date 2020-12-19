package cucumber_class.stepdefs;

import Utils.Driver;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Outline2Test {
WebDriver driver = Driver.getDriver("chrome");

    @Then("user creates a new patient everytime with following data: {string}, {string}, {string}")
    public void user_creates_a_new_patient_everytime_with_following_data(String givenName, String familyNameValue, String gender) {

        try {

            WebElement regNewPatientButton = driver.findElement(By.id("referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension"));
            regNewPatientButton.click();

            WebElement name = driver.findElement(By.name("givenName"));
            name.sendKeys(givenName);
            WebElement familyname = driver.findElement(By.name("familyName"));
            familyname.sendKeys(familyNameValue);

            WebElement genderButton = driver.findElement(By.xpath("//span[@id='genderLabel']"));
            genderButton.click();

            WebElement option = driver.findElement(By.xpath("//select[contains(@class,'required')]"));
            Select select = new Select(option);
            if (gender.contains("F") || gender.contains("f")){
                select.selectByValue("F");
            } else {
                select.selectByValue("M");
            }

        }catch (ElementNotInteractableException e){
            logout();
        }

    }



    @Then("with also extra information:{string}, {string}, {string}")
    public void with_also_extra_information(String birthDayValue, String birthMonthValue, String birthYearValue) {

        try{

            WebElement birthInfoButton = driver.findElement(By.id("birthdateLabel"));
            birthInfoButton.click();

            WebElement bday = driver.findElement(By.id("birthdateDay-field"));
            bday.sendKeys(birthDayValue);
            WebElement bMonth= driver.findElement(By.id("birthdateMonth-field"));

            Select select=new Select(bMonth);
            select.selectByValue(birthMonthValue);
            WebElement bYear  = driver.findElement(By.id("birthdateYear-field"));
            bYear.sendKeys(birthYearValue);

            WebElement addressButton = driver.findElement(By.xpath("//span[text()='Address']"));
            addressButton.click();

        }catch (ElementNotInteractableException e){
            logout();
        }

    }
    @Then("also address:{string}, {string}, {string}, {string}, and {string}, {string}, {string}")
    public void also_address_and(String addressValue, String cityValue, String stateValue, String countryValue, String postalCodeValue, String phoneNumberValue, String relativeNameValue) {


        try{

            WebElement address1 = driver.findElement(By.xpath("//input[@id='address1']"));
            address1.sendKeys(addressValue);

            WebElement city = driver.findElement(By.id("cityVillage"));
            city.sendKeys(cityValue);

            WebElement state = driver.findElement(By.id("stateProvince"));
            state.sendKeys(stateValue);

            WebElement countryinfo = driver.findElement(By.id("country"));
            countryinfo.sendKeys(countryValue);

            WebElement postalCode = driver.findElement(By.id("postalCode"));
            postalCode.sendKeys(postalCodeValue);

            WebElement phoneNumButton = driver.findElement(By.xpath("//span[text()='Phone Number']"));
            phoneNumButton.click();

            WebElement phoneNum = driver.findElement(By.name("phoneNumber"));
            phoneNum.sendKeys(phoneNumberValue);

            WebElement relativesButton = driver.findElement(By.xpath("//span[text()='Relatives']"));
            relativesButton.click();

            WebElement relativetype = driver.findElement(By.id("relationship_type"));
            Select select= new Select(relativetype);
            select.selectByVisibleText("Sibling");

            WebElement relativename = driver.findElement(By.xpath("//input[@placeholder = 'Person Name']"));
            relativename.sendKeys(relativeNameValue);

            WebElement confirmButton = driver.findElement(By.id("confirmation_label"));
            confirmButton.click();

            WebElement confirmationSubmit = driver.findElement(By.id("submit"));
            confirmationSubmit.click();

        }catch (ElementNotInteractableException e){
            logout();
        }



    }
    @Then("confirms new patient has been registered with {string} and {string}")
    public void confirms_new_patient_has_been_registered_with_and(String givenName, String familyName) {

        try{

            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            WebElement personGivenName = driver.findElement(By.xpath("//span[contains(@class,'givenName')]"));
            String actualName = personGivenName.getText();
            WebElement personLastName = driver.findElement(By.xpath("//span[contains(@class,'familyName')]"));
            String actualLastName = personLastName.getText();

            Assert.assertEquals(actualName+" "+actualLastName,givenName+" "+familyName);
            logout();

        }catch (ElementNotInteractableException e){
            logout();
        }
    }

    public void logout(){
        WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Log')]"));
        logout.click();
    }


}
