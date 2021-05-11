package CucumberAPI.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PetAPIRunner {
    int petId;

    public String setPetBody(int id, String name, String status){


    String petBody = "{\n" +
            "  \"id\": "+id+",\n" +
            "  \"category\": {\n" +
            "    \"id\": 0,\n" +
            "    \"name\": \"string\"\n" +
            "  },\n" +
            "  \"name\": \""+name+"\",\n" +
            "  \"photoUrls\": [\n" +
            "    \"string\"\n" +
            "  ],\n" +
            "  \"tags\": [\n" +
            "    {\n" +
            "      \"id\": 0,\n" +
            "      \"name\": \"Good Dog\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"status\": \""+status+"\"\n" +
            "}";
    return petBody;
}


    @When("user creates a pet with given <id> <name> and <status>")
    public void user_creates_a_pet_with_given_id_name_and_status(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String,String>> maps = dataTable.asMaps();
        Map<String,String> map = maps.get(0);
        petId =Integer.parseInt(map.get("id"));
        String petName = map.get("name");
        String petStatus = map.get("status");
        System.out.println(petId + petName + petStatus+2222);
      given().accept(ContentType.JSON).contentType(ContentType.JSON).body(setPetBody(petId,petName,petStatus))
              .when().post("https://petstore.swagger.io/v2/pet/")
              .then().statusCode(HttpStatus.SC_OK)
              .and().contentType(ContentType.JSON)
              .body("id", Matchers.equalTo(petId))
              .body("name", Matchers.equalTo(petName))
              .body("status", Matchers.equalTo(petStatus));




    }


    @Then("user verifies the pet is created.")
    public void user_verifies_the_pet_is_created() {

        given().accept(ContentType.JSON)
                .when().get("https://petstore.swagger.io/v2/pet/"+petId)
                .then().statusCode(HttpStatus.SC_OK)
                .and().contentType(ContentType.JSON).log().all();


    }
    @Then("user deletes the pet.")
    public void user_deletes_the_pet() {
        given().accept(ContentType.JSON)
                .when().delete("https://petstore.swagger.io/v2/pet/"+petId)
                .then().statusCode(HttpStatus.SC_OK);

    }


}
