package api_class.restassured;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;


public class GetRequest {

    @Test
    public void getTest(){

        given().accept("application/json")
                .when().get("https://petstore.swagger.io/v2/pet/1020")
                .then().statusCode(200).contentType("application/json");

    }

    @Test
    public void getTest2(){

        given().accept("application/json")
                .when().get("http://swapi.dev/api/people")
                .then().statusCode(HttpStatus.SC_OK).contentType("application/json").log().all();
    }

    @Test
    public void getTest3(){

        given().accept(ContentType.JSON)
                .when().get("https://petstore.swagger.io/v2/pet/1020")
                .then().statusCode(200).contentType(ContentType.JSON)
                .and().body("id", Matchers.equalTo(1020))
                .and().body("category.name", Matchers.is("Spaniel"));

    }

    @Test
    public void getTest4(){

        given().accept(ContentType.JSON)
                .when().get("https://pokeapi.co/api/v2/ability")
                .then().statusCode(200).contentType(ContentType.JSON)
                .and().body("count",Matchers.equalTo(327))
                .and().body("results[2].name",Matchers.is("speed-boost"))
                .and().body("results.name[2]", Matchers.equalTo("speed-boost"));




        }


    }






