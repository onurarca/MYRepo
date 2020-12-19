package api_class.restassured;

import Utils.PayloadUtils;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static Utils.Constants.*;
import static io.restassured.RestAssured.given;

public class PutRequest {

    @Test
    public void updatePetTest(){

        int petid = 8776;
        String petName = "Oliver";
        String petStatus = "Running";


        String petPayLoad = PayloadUtils.getPetStorePayload(petid,petName,petStatus);
        given().accept(ContentType.JSON).contentType(ContentType.JSON).body(petPayLoad)
                .when().put("https://petstore.swagger.io/v2/pet")
                .then().statusCode(200)
                .and().body(ID, Matchers.is(petid))
                .and().body(NAME,Matchers.equalTo(petName)).body(STATUS,Matchers.equalTo(petStatus));


    }


}
