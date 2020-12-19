package api_class.restassured;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestAssuredGroovyFunctions {

    @Test
    public void getCompetitionTest(){

        Response response = given().accept(ContentType.JSON).when().get("http://api.football-data.org/v2/competitions")
                .then().statusCode(200).contentType(ContentType.JSON).extract().response();

        Map<String,Object> map =response.path("competitions.find { it.name=='WC Qualification' }");
        System.out.println(map);


    }

    @Test
    public void getCompt(){
        Response response = given().accept(ContentType.JSON).when().get("http://api.football-data.org/v2/competitions")
                .then().statusCode(200).contentType(ContentType.JSON).extract().response();

        Map<String,Object> map2 = response.path("competitions.find{it.id==2036}");
        System.out.println(map2.get("name"));

    }

    @Test
    public void findAllCompetitionsTest(){
        Response response = given().accept(ContentType.JSON).when()
                .get("http://api.football-data.org/v2/competitions")
                .then().statusCode(200).contentType(ContentType.JSON).extract().response();

        List<Map<String,Object>> competitionList =response.path("competitions.findAll {it.id >2006}");
        System.out.println(competitionList.size());


    }

    @Test
    public void findAllCompetitionsTest2(){
        Response response = given().accept(ContentType.JSON).when()
                .get("http://api.football-data.org/v2/competitions")
                .then().statusCode(200).contentType(ContentType.JSON).extract().response();

        List<String> competitionNames =response.path("competitions.findAll {it.id >2006}.name");
        System.out.println(competitionNames);


    }



}
