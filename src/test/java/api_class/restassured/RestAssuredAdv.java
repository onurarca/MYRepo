package api_class.restassured;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestAssuredAdv {

    RequestSpecification reqSpec;
    ResponseSpecification respSpec;

    @BeforeMethod
    public void setup(){
        RestAssured.baseURI = "http://pokeapi.co";
        RestAssured.basePath = "api/v2/ability";
        reqSpec = new RequestSpecBuilder().setAccept(ContentType.JSON).build();
        respSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

    }


    @Test
    public void test1(){
        given().spec(reqSpec)
                .when().get()
                .then().spec(respSpec);

        File petPayLoad = new File("src/test/java/api_class/serialization/pet.json");
        given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .body(petPayLoad)
                .when().post()
                .then().statusCode(200)
                .and().body("id", Matchers.equalTo(876))
                .and().body("name", Matchers.is("T-Rex"))
                .and().body("status",Matchers.equalTo("monster"));


    }

    @Test
    public void test2(){
       Response response = given().spec(reqSpec).queryParam("limit", "1")
                .when().get()
                .then().spec(respSpec).extract().response();

       List<Map<String,String>>result = JsonPath.from(response.asString()).getList("results");
        Assert.assertEquals(result.size(),1);


    }


}
