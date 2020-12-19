package api_class.post;

import Utils.PayloadUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import org.testng.Assert;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.Map;

public class PetStorePost {


    @Test
    public void createPetTest() throws URISyntaxException, IOException {

        HttpClient client = HttpClientBuilder.create().build();

        URIBuilder uriBuilder= new URIBuilder();
        uriBuilder.setScheme("https").setHost("petstore.swagger.io").setPath("v2/pet");

        HttpPost httpPost = new HttpPost(uriBuilder.build());
        httpPost.addHeader("accept", "application/json");
        httpPost.addHeader("Content-Type", "application/json");

        int petId = 1003;
        String petname = "Trex";
        String status = "Super Pet";
        String postBody = PayloadUtils.getPetStorePayload(petId,petname,status);
        HttpEntity entity = new StringEntity(postBody);

        httpPost.setEntity(entity);

       HttpResponse response = client.execute(httpPost);

        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,Object> deserializedResponse = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String,Object>>() {
        });

        String  actualPetName = (String) deserializedResponse.get("name");
        int actualPetID = (int) deserializedResponse.get("id");
        String actualPetStatus = (String) deserializedResponse.get("status");

        Assert.assertEquals(actualPetID,petId);
        Assert.assertEquals(actualPetName,petname);
        Assert.assertEquals(actualPetStatus,status);



    }


    @Test
    public void createOrder() throws URISyntaxException, IOException {

        HttpClient httpClient = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").setHost("petstore.swagger.io").setPath("v2/pet");

        HttpPost httpPost = new HttpPost(uriBuilder.build());
        httpPost.addHeader("accept","application/json");
        httpPost.addHeader("Content-Type", "application/json");

        String postBody = "{\n" +
                "    \"id\": 5555,\n" +
                "  \"petId\": 2222,\n" +
                "  \"quantity\": 1111,\n" +
                "  \"shipDate\": \"2020-12-06T14:51:34.871Z\",\n" +
                "  \"status\": \"placed\",\n" +
                "  \"complete\": true\n" +
                "\n" +
                "}";

        HttpEntity entity = new StringEntity(postBody);
        httpPost.setEntity(entity);

        HttpResponse response = httpClient.execute(httpPost);
        Assert.assertEquals(response.getStatusLine().getStatusCode(),HttpStatus.SC_OK);
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));

        ObjectMapper objectMapper = new ObjectMapper();

        Map<String,Object> deserializedResponse= objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String, Object>>() {
        });

        int actualPetId = (int) deserializedResponse.get("id");
        String actualPetStatus = (String) deserializedResponse.get("status");

        Assert.assertEquals(actualPetId,5555);
        Assert.assertEquals(actualPetStatus,"placed");


    }

    @Test
    public void createUser() throws URISyntaxException, IOException {

        HttpClient httpClient = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").setHost("petstore.swagger.io").setPath("v2/pet");

        HttpPost httpPost = new HttpPost(uriBuilder.build());
        httpPost.addHeader("accept","application/json");
        httpPost.addHeader("Content-Type","application/json");

        String postbody="{\n" +
                "  \"id\": 5555,\n" +
                "  \"username\": \"Onur\",\n" +
                "  \"firstName\": \"Onur\",\n" +
                "  \"lastName\": \"Arca\",\n" +
                "  \"email\": \"oa@gmail.com\",\n" +
                "  \"password\": \"123456\",\n" +
                "  \"phone\": \"5552552525\",\n" +
                "  \"userStatus\": 1\n" +
                "}";

        HttpEntity entity = new StringEntity(postbody);
        httpPost.setEntity(entity);

        HttpResponse response = httpClient.execute(httpPost);

        Assert.assertEquals(response.getStatusLine().getStatusCode(),HttpStatus.SC_OK);
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));

        ObjectMapper objectMapper = new ObjectMapper();

        Map<String,Object> deserializedMap = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String,Object>>() {
        });

        int actualId = (int) deserializedMap.get("id");
        String actualUsername = (String) deserializedMap.get("username");


        Assert.assertEquals(actualId,5555);






    }




}
