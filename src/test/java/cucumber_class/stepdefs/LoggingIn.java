package cucumber_class.stepdefs;

import Utils.Driver;
import Utils.PropertyReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LoggingIn {
    String nameValue;

    public String getNameValue() {
        return nameValue;
    }

    public void setNameValue(String nameValue) {
        this.nameValue = nameValue;
    }

    public String getFamilyNameValue() {
        return familyNameValue;
    }

    public void setFamilyNameValue(String familyNameValue) {
        this.familyNameValue = familyNameValue;
    }

    String familyNameValue;

    WebDriver driver = Driver.getDriver(PropertyReader.readPropertyByKey("browser"));

    @When("user navigates to OpenMRS web site")
    public void user_navigates_to_open_mrs_web_site() {
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
    }

    @When("user enters username {string} and password {string} and logs in")
    public void user_enters_username_and_password_and_logs_in(String string, String string2) {

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("admin");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Admin123");

        WebElement emergencyDept = driver.findElement(By.id("Inpatient Ward"));
        emergencyDept.click();

        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();

    }

    @Then("Message contains {string}")
    public void super_admin_message_displays(String superUser) {

        WebElement text = driver.findElement(By.xpath("//h4"));

       Assert.assertTrue(text.getText().contains("Coyote"));


    }


    @Given("user logged in to demo.openmrs.org")
    public void user_logged_in_to_demo_openmrs_org() {

        driver.get("https://demo.openmrs.org/openmrs/login.htm");

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys(PropertyReader.readPropertyByKey("username"));

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(PropertyReader.readPropertyByKey("password"));

        WebElement emergencyDept = driver.findElement(By.id("Inpatient Ward"));
        emergencyDept.click();

        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();

    }

    @When("user searches for {string} patient")
    public void user_searches_for_patient(String int1) {
        WebElement search = driver.findElement(By.id("coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension"));
        search.click();
        Actions actions = new Actions(driver);
        WebElement patientSearch = driver.findElement(By.id("patient-search"));
        actions.sendKeys(patientSearch,int1).sendKeys(patientSearch,Keys.ENTER).perform();
       // patientSearch.sendKeys("int1");
       // actions.sendKeys(patientSearch,Keys.ENTER);



    }

    @Then("no records found")
    public void no_records_found() {

        WebElement errorText = driver.findElement(By.className("dataTables_empty"));
        Assert.assertEquals(errorText.getText(),"No matching records found");

    }



    @When("user navigates to open MRS home page")
    public void user_navigates_to_open_mrs_home_page() {
        System.out.println("Navigate to open MRS home page");
        driver.get("https://demo.openmrs.org");

    }


    @When("user los in with following data:")
    public void user_los_in_with_following_data(io.cucumber.datatable.DataTable dataTable) {
        //We store multiple maps in one List: List Of Maps
        List<Map<String,String>> dataTableList = dataTable.asMaps();


      //  System.out.println("Size of list of maps is: " + dataTableList.size());

        // getting first element from list of maps
        Map<String, String> dataMap = dataTableList.get(0);

        //getting username from map
       String usernameValue = dataMap.get("username");

       //getting password from map
        String passwordValue = dataMap.get("password");
        String deptName = dataMap.get("departmentName");

      //  System.out.println("Getting values from datatable");
      //  System.out.println("Username: " + usernameValue);
      //  System.out.println("Password: " + passwordValue);

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys(usernameValue);

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(passwordValue);

        WebElement regDesk = driver.findElement(By.id(deptName));
        regDesk.click();

        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();


    }
    @Then("user is logged in as {string}")
    public void user_is_logged_in_as(String userInfo) {

        WebElement text = driver.findElement(By.xpath("//h4"));

        Assert.assertTrue(text.getText().contains(userInfo));

    }


    @Given("user logged in to demo.openmrs.org as admin")
    public void user_logged_in_to_demo_openmrs_org_as_admin() {

    }

    @When("user registers a new patient with following information:")
    public void user_registers_a_new_patient_with_following_information(io.cucumber.datatable.DataTable dataTable) {
    WebElement regNewPatientButton = driver.findElement(By.id("referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension"));
    regNewPatientButton.click();
        List<Map<String,String>> dataTableList = dataTable.asMaps();
        Map<String, String> dataMap = dataTableList.get(0);
        setNameValue(dataMap.get("GivenName"));
        setFamilyNameValue(dataMap.get("FamilyName"));
       //nameValue = dataMap.get("GivenName");
        //familyNameValue = dataMap.get("FamilyName");
        String genderValue = dataMap.get("Gender");
        String birthDayValue = dataMap.get("BirthDay");
        String birthMonthValue = dataMap.get("BirthMonth");
        String birthYearValue = dataMap.get("BirthYear");
        String addressValue = dataMap.get("Address");
        String cityValue = dataMap.get("City");
        String stateValue = dataMap.get("State");
        String countryValue = dataMap.get("Country");
        String postalCodeValue = dataMap.get("PostalCode");
        String phoneNumberValue = dataMap.get("PhoneNumber");
        String relativeNameValue = dataMap.get("RelativeName");

        WebElement name = driver.findElement(By.name("givenName"));
        name.sendKeys(nameValue);
        WebElement familyName = driver.findElement(By.name("familyName"));
        familyName.sendKeys(familyNameValue);

        WebElement genderButton = driver.findElement(By.xpath("//span[@id='genderLabel']"));
        genderButton.click();

        WebElement option = driver.findElement(By.xpath("//select[contains(@class,'required')]"));
        Select select = new Select(option);
        if (genderValue.contains("F") || genderValue.contains("f")){
            select.selectByValue("F");
        } else {
            select.selectByValue("M");
        }
        WebElement birthInfoButton = driver.findElement(By.id("birthdateLabel"));
        birthInfoButton.click();

        WebElement bday = driver.findElement(By.id("birthdateDay-field"));
        bday.sendKeys(birthDayValue);
        WebElement bMonth= driver.findElement(By.id("birthdateMonth-field"));
        select=new Select(bMonth);
        select.selectByValue(birthMonthValue);
        WebElement bYear  = driver.findElement(By.id("birthdateYear-field"));
        bYear.sendKeys(birthYearValue);

        WebElement addressButton = driver.findElement(By.xpath("//span[text()='Address']"));
        addressButton.click();

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
        select= new Select(relativetype);
        select.selectByVisibleText("Sibling");

        WebElement relativename = driver.findElement(By.xpath("//input[@placeholder = 'Person Name']"));
        relativename.sendKeys(relativeNameValue);

        WebElement confirmButton = driver.findElement(By.id("confirmation_label"));
        confirmButton.click();

        WebElement confirmationSubmit = driver.findElement(By.id("submit"));
        confirmationSubmit.click();





    }
    @Then("new patient is registered")
    public void new_patient_is_registered() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement personGivenName = driver.findElement(By.xpath("//span[contains(@class,'givenName')]"));
        String actualName = personGivenName.getText();
        WebElement personLastName = driver.findElement(By.xpath("//span[contains(@class,'familyName')]"));
        String actualLastName = personLastName.getText();

        Assert.assertEquals(actualName+" "+actualLastName,nameValue+" "+familyNameValue);



    }


    @When("user los in with following data with different table:")
    public void user_los_in_with_following_data_with_different_table(io.cucumber.datatable.DataTable dataTable) {
        System.out.println("Getting data from variant 2 datatable");
        Map<String,String> dataMap = dataTable.asMap(String.class,String.class);
        String deptNameValue = dataMap.get("departmentName");
        String usernameValue = dataMap.get("username");
        String passwordValue = dataMap.get("password");

        System.out.println(dataMap.get("departmentName"));
        System.out.println(deptNameValue);
        System.out.println(usernameValue);
        System.out.println(passwordValue);


    }


    @When("user registers a new patient with the following data:")
    public void user_registers_a_new_patient_with_the_following_data(io.cucumber.datatable.DataTable dataTable) {


        WebElement regNewPatientButton = driver.findElement(By.id("referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension"));
        regNewPatientButton.click();
       Map<String,String> dataMap = dataTable.asMap(String.class,String.class);

        String nameValue = dataMap.get("GivenName");
        String familyNameValue = dataMap.get("FamilyName");
        String genderValue = dataMap.get("Gender");
        String birthDayValue = dataMap.get("BirthDay");
        String birthMonthValue = dataMap.get("BirthMonth");
        String birthYearValue = dataMap.get("BirthYear");
        String addressValue = dataMap.get("Address");
        String cityValue = dataMap.get("City");
        String stateValue = dataMap.get("State");
        String countryValue = dataMap.get("Country");
        String postalCodeValue = dataMap.get("PostalCode");
        String phoneNumberValue = dataMap.get("PhoneNumber");
        String relativeNameValue = dataMap.get("RelativeName");

        WebElement name = driver.findElement(By.name("givenName"));
        name.sendKeys(nameValue);
        WebElement familyName = driver.findElement(By.name("familyName"));
        familyName.sendKeys(familyNameValue);

        WebElement genderButton = driver.findElement(By.xpath("//span[@id='genderLabel']"));
        genderButton.click();

        WebElement option = driver.findElement(By.xpath("//select[contains(@class,'required')]"));
        Select select = new Select(option);
        if (genderValue.contains("F") || genderValue.contains("f")){
            select.selectByValue("F");
        } else {
            select.selectByValue("M");
        }
        WebElement birthInfoButton = driver.findElement(By.id("birthdateLabel"));
        birthInfoButton.click();

        WebElement bday = driver.findElement(By.id("birthdateDay-field"));
        bday.sendKeys(birthDayValue);
        WebElement bMonth= driver.findElement(By.id("birthdateMonth-field"));
        select=new Select(bMonth);
        select.selectByValue(birthMonthValue);
        WebElement bYear  = driver.findElement(By.id("birthdateYear-field"));
        bYear.sendKeys(birthYearValue);

        WebElement addressButton = driver.findElement(By.xpath("//span[text()='Address']"));
        addressButton.click();

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
        select= new Select(relativetype);
        select.selectByVisibleText("Sibling");

        WebElement relativename = driver.findElement(By.xpath("//input[@placeholder = 'Person Name']"));
        relativename.sendKeys(relativeNameValue);

        WebElement confirmButton = driver.findElement(By.id("confirmation_label"));
        confirmButton.click();

        WebElement confirmationSubmit = driver.findElement(By.id("submit"));
        confirmationSubmit.click();


    }


    //------------------------------------------------------------------------------------------------------

    @Given("user is logged in to demo.openmrs.org as admin")
    public void user_is_logged_in_to_demo_openmrs_org_as_admin() {
        System.out.println("Navigate to openMRS and login as admin");

    }




    @When("user creates a new patient with following data: {string}, {string}, {string}")
    public void user_creates_a_new_patient_with_following_data(String givenName, String familyName, String gender) {
        System.out.println("Given name of the new patient " + givenName );
        System.out.println("Family name of new patient " + familyName);
        System.out.println("Gender os new patient is "+ gender);
    }
    @When("with extra information:{string}, {string}, {string}")
    public void with_extra_information(String birthDay, String birthMonth, String birthYear) {
        System.out.println("Birth date is: " + birthDay +" "+ birthMonth+" "+birthYear);

    }
    @When("with address:{string}, {string}, {string}, {string}, and {string}")
    public void with_address_and(String address, String city, String state, String country, String postalCode) {

        System.out.println("Patient address is: "+ address);
        System.out.println("Patient city is: "+city);
        System.out.println("patient state is: "+state);
        System.out.println("Patient country is: "+country);
        System.out.println("Patient postal code is: "+postalCode);

    }
    @Then("new patient has been registered with {string} and {string}")
    public void new_patient_has_been_registered_with_and(String givenName, String familyName) {
        System.out.println("Registered patient name: " + givenName);
        System.out.println("Registered patient family name: "+familyName);


    }
    @Then("address of the new patient is {string}, {string}, {string}")
    public void address_of_the_new_patient_is(String address, String city, String state) {
        System.out.println("Registered patient address: "+address);
        System.out.println("Registered patient city: "+ city);
        System.out.println("Registered patient state: "+state);

    }









}
