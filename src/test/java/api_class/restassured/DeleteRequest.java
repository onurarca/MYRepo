package api_class.restassured;

import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteRequest {


    @Test
    public void test1(){
        given().accept(ContentType.JSON)
                .when().delete("https://petstore.swagger.io/v2/pet/1020")
                .then().statusCode(200).contentType(ContentType.JSON)
                .and().body("code", Matchers.equalTo(200));


    }




}
