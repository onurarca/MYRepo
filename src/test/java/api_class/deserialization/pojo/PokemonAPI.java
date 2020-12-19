package api_class.deserialization.pojo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class PokemonAPI {

    @Test
    public void getAbilityTest() throws IOException, URISyntaxException {

        HttpClient httpClient = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").setHost("pokeapi.co").setPath("api/v2/ability");

        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("accept", "application/json");

        HttpResponse response = httpClient.execute(httpGet);

        ObjectMapper objectMapper = new ObjectMapper();
        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));

        Map<String, Object> deserializedResponse = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String,Object>>() {
        });

        List<Map<String,String>> result = (List<Map<String,String>>) deserializedResponse.get("results");

        for (int i =0; i<result.size(); i++){
           Map<String,String> map = result.get(i);
            System.out.println(map.get("name"));


        }







    }


    public static class ReqresAPI {


        @Test
        public void getUserByIDTest() throws URISyntaxException, IOException {

            /**
             * Building API request:
             * 0. Launch/initialize the client
             * 1. Construct URL
             * 2. Define the Http Method(GET, POST, PUT, Delete)
             * 3. Add parameters (if needed):
             * 	- path params
             * 	- query params
             * 	- headers params
             * 4. Click on SEND button/execute a call.
             */

            //Initializing the client

            HttpClient httpClient = HttpClientBuilder.create().build();

            //Construct URL :https://reqres.in/api/users/1

            URIBuilder uriBuilder = new URIBuilder();
            uriBuilder.setScheme("https").setHost("reqres.in").setPath("api/users/1");

            //Define the https method

            HttpGet httpGet = new HttpGet(uriBuilder.build());
            httpGet.addHeader("accept", "application/json");

            //Execute a call

            HttpResponse response = httpClient.execute(httpGet);
            int actualStatusCode = response.getStatusLine().getStatusCode();

            Assert.assertEquals(actualStatusCode, HttpStatus.SC_OK);

            //Verify response header : ContentType

            Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));

            ObjectMapper objectMapper = new ObjectMapper();

            //deserialization
            Map<String, Object> dataFromResponse = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String, Object>>() {
            });

            Object data = dataFromResponse.get("data");
            Map<String, Object> data2 = (Map<String, Object>) dataFromResponse.get("data");
            System.out.println(data2.get("first_name"));
            System.out.println(dataFromResponse.get("data"));


        }


        @Test
        public void getUserByIdTest() throws URISyntaxException, IOException {

            HttpClient httpClient = HttpClientBuilder.create().build();

            URIBuilder uriBuilder = new URIBuilder();
            uriBuilder.setScheme("https").setHost("reqres.in").setPath("api/users/1");

            HttpGet httpGet = new HttpGet(uriBuilder.build());
            httpGet.addHeader("accept", "application/json");

            HttpResponse response = httpClient.execute(httpGet);

            Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
            Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));

            //deserialization with ObjectMapper

            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> deserializedResponse = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String, Object>>() {
            });
            Map<String,String> support =(Map<String,String>) deserializedResponse.get("support");
            System.out.println(support);
            System.out.println(support.get("url"));
            System.out.println(support.get("text"));


        }

        @Test
        public void urlConst() throws URISyntaxException, IOException {
            HttpClient httpClient = HttpClientBuilder.create().build();

            URIBuilder uriBuilder = new URIBuilder();
            uriBuilder.setScheme("https").setHost("reqres.in").setPath("api/users");

            HttpGet httpGet = new HttpGet(uriBuilder.build());
            httpGet.addHeader("accept", "application/json");

            HttpResponse response = httpClient.execute(httpGet);

            Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
            Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));

            //deserialization with ObjectMapper

            ObjectMapper objectMapper = new ObjectMapper();
           Map<String,Object> map = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String,Object>>() {
            });
           Map<String,String> data = (Map<String,String>) map.get("support");
            System.out.println(data.get("url"));



        }




    }

    public static class StarWarsAPI {

        @org.testng.annotations.Test
        public void spaceshipTest() throws URISyntaxException, IOException {

            /**
             * Building API request:
             * 0. Launch/initialize the client
             * 1. Construct URL
             * 2. Define the Http Method(GET, POST, PUT, Delete)
             * 3. Add parameters (if needed):
             * 	- path params
             * 	- query params
             * 	- headers params
             * 4. Click on SEND button/execute a call.
             */


            HttpClient httpClient = HttpClientBuilder.create().build();

            URIBuilder uriBuilder = new URIBuilder();
            uriBuilder.setScheme("https");
            uriBuilder.setHost("swapi.dev");
            uriBuilder.setPath("api/starships");
            uriBuilder.setParameter("page", "2");


            //Define http method
            HttpGet httpGet = new HttpGet(uriBuilder.build());

            httpGet.addHeader("accept", "application/json");
            //execute a call
            HttpResponse response = httpClient.execute(httpGet);

            org.testng.Assert.assertEquals(response.getStatusLine().getStatusCode(),200);


        }


    }
}
