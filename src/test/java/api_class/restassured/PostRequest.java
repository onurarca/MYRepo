package api_class.restassured;

import Utils.Constants;
import Utils.PayloadUtils;
import api_class.deserialization.pojo.PetPojo;
import io.cucumber.java.it.Ma;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

import static Utils.Constants.*;
import static Utils.Constants.ID;
import static Utils.Constants.NAME;
import static io.restassured.RestAssured.given;

public class PostRequest {

    @BeforeMethod
    public void setup(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";



    }

    @Test
    public void test1() {

        String requestPayload = PayloadUtils.getPetStorePayload(989, "Hutch", "on duty");
        given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .body(requestPayload)
                .when().post()
                .then().statusCode(200);

    }

    @Test
    public void test2() {

        String requestPayload = PayloadUtils.getPetStorePayload(159, "Reks", "lunch break");
        given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .body(requestPayload)
                .when().post()
                .then().statusCode(200).contentType(ContentType.JSON)
                .and().body("id", Matchers.equalTo(159))
                .body("name", Matchers.is("Reks"))
                .body("status", Matchers.is("lunch break"));


    }

    @Test
    public void test3(){
        File petPayLoad = new File("src/test/java/api_class/serialization/pet.json");
        given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .body(petPayLoad)
                .when().post()
                .then().statusCode(200)
                .and().body("id",Matchers.equalTo(876))
                .and().body("name", Matchers.is("T-Rex"))
                .and().body("status",Matchers.equalTo("monster"));

    }

    @Test
    public void createPetTest(){
        int petId = 5568;
        String petName = "Snoopy";
        String petStatus = "to be deleted";

        PetPojo pet = new PetPojo(petId,petName,petStatus);
        given().accept(ContentType.JSON).contentType(ContentType.JSON).body(pet)
                .when().post("https://petstore.swagger.io/v2/pet")
                .then().statusCode(200)
                .and().body(ID,Matchers.equalTo(petId))
                .and().body(NAME,Matchers.is(petName))
                .and().body(STATUS,Matchers.is(petStatus));


    }


}
