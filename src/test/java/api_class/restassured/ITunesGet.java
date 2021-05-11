package api_class.restassured;

import api_class.deserialization.pojo.PetPojo;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ITunesGet {

    @Test
    public void iTunesTest1(){

        given().accept(ContentType.JSON).queryParam("term", "greenday")
                .when().get("https://itunes.apple.com/search")
                .then().statusCode(200).contentType(ContentType.JSON)
                .and().body("resultCount", Matchers.equalTo(50));


    }

    @Test
    public void iTunesGetTest(){

      Response response = given().accept(ContentType.JSON).queryParam("term", "greenday")
                .when().get("https://itunes.apple.com/search")
                .then().statusCode(200).contentType(ContentType.JSON).extract().response();
      
      //as() method is like an object mapper. It defines typereference
      Map<String,Object> parsedResponse = response.as(new TypeRef<Map<String,Object>>() {
      });

     List<Map<String,Object>> resultsDataList = (List<Map<String,Object>>) parsedResponse.get("results");
        assertEquals(50, resultsDataList.size());



    }


    @Test
    public void starWarsGetAPI(){

        RestAssured.baseURI="http://swapi.dev/api/people";
        Response response = given().accept(ContentType.JSON)
                .when().get()
                .then().statusCode(200).contentType(ContentType.JSON).extract().response();

        Map<String,Object> parsedMap = response.as(new TypeRef<Map<String, Object>>() {
        });

        List<Map<String,Object>> resultList = (List<Map<String ,Object>>)parsedMap.get("results");
       assertEquals(resultList.get(0).get("name"), "Luke Skywalker");


    }

    @Test
    public void petStoreGetAPI(){

        RestAssured.baseURI = "https://petstore.swagger.io";
        RestAssured.basePath="v2/pet/159159159";

        Response response = given().accept(ContentType.JSON)
                .when().get()
                .then().statusCode(200).contentType(ContentType.JSON).extract().response();
        PetPojo deserializedPet = response.as(PetPojo.class);
        assertEquals(deserializedPet.getName(),"Cinnamon");
        assertEquals(deserializedPet.getStatus(),"Breakfast time");




    }

    @Test
    public void petTest2(){

        Response response = given().accept(ContentType.JSON)
                .when().get("http://swapi.dev/api/people")
                .then().statusCode(200).contentType(ContentType.JSON).extract().response();

                //"." means get the whole response as Map
       Map<String,Object> parsedResponse = JsonPath.from(response.asString()).getMap(".");
        System.out.println(parsedResponse);

        List<Map<String,Object>> results = JsonPath.from(response.asString()).getList("results");
        System.out.println(results);

        int count = JsonPath.from(response.asString()).getInt("count");
        System.out.println("Count is: " + count);

    }



}
