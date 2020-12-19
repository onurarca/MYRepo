package Utils;

import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class JiraUtils {

    public static String getSessionId(){

        Response response = given().accept(ContentType.JSON).contentType(ContentType.JSON).body(PayloadUtils.getJiraAuthPayload())
                .when().post("http://localhost:8080/rest/auth/1/session").then()
                .statusCode(200).extract().response();
        Map<String,Object> parsedResponse = response.as(new TypeRef<Map<String,Object>>() {
        });

        Map<String,Object> sessionData = (Map<String, Object>) parsedResponse.get("session");
        String value = (String) sessionData.get("value");


        ///OR


        String value1 = response.jsonPath().getString("session.value");
        System.out.println(value1);
        return value;




    }


}
