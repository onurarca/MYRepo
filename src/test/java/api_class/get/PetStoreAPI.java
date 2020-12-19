package api_class.get;

import api_class.deserialization.pojo.PetPojo;
import api_class.deserialization.pojo.PetPojoOption2;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
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

public class PetStoreAPI {

    @Test
    public void petStoreIdName() throws URISyntaxException, IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").setHost("petstore.swagger.io").setPath("v2/pet/findByStatus").setParameter("status", "sold");

        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("accept", "application/json");

        HttpResponse response = httpClient.execute(httpGet);


        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));
        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String, Object>> list = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<List<Map<String, Object>>>() {
        });

        for (int i =0; i<list.size();i++){

            Map<String, Object> map =  list.get(i);
            System.out.println("id: "+map.get("id")+" and name: "+ map.get("name"));

            Map<String,Object> categoryData =(Map<String, Object>) map.get("category");
            if (categoryData!=null)

            System.out.println("Category ID: " + categoryData.get("id")+", Category Name: "+ categoryData.get("name"));

           List<Map<String,Object>>  tagsDataList = ( List<Map<String,Object>>) map.get("tags");

            if (tagsDataList!=null){
                for (int b =0; b<tagsDataList.size(); b++){
                    Map<String,Object> mapdata =( Map<String,Object>) tagsDataList.get(b);

                    System.out.println("Tags ID: " + mapdata.get("id")+", Tags Name: "+ mapdata.get("name"));
                }



            }



            }


        }



        @Test
    public void getPetTest() throws URISyntaxException, IOException {

            HttpClient httpClient = HttpClientBuilder.create().build();

            URIBuilder uriBuilder = new URIBuilder();
            uriBuilder.setScheme("https").setHost("petstore.swagger.io").setPath("v2/pet/159159159");

            HttpGet httpGet = new HttpGet(uriBuilder.build());
            httpGet.addHeader("accept", "application/json");

            HttpResponse response = httpClient.execute(httpGet);
            Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));
            Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);

            ObjectMapper objectMapper = new ObjectMapper();

            PetPojo petPojo = objectMapper.readValue(response.getEntity().getContent(), PetPojo.class);

            Assert.assertEquals(petPojo.getId(),159159159);
            Assert.assertEquals(petPojo.getName(),"doggie 2");
            Assert.assertEquals(petPojo.getStatus(),"doggie for sale");

            Map<String,Object> categoryData = petPojo.getCategory();
            int categoryId = (int)categoryData.get("id");
            String categoryName = (String) categoryData.get("name");


        }

        @Test
    public void getPetTest2() throws IOException, URISyntaxException {

            HttpClient httpClient = HttpClientBuilder.create().build();

            URIBuilder uriBuilder = new URIBuilder();
            uriBuilder.setScheme("https").setHost("petstore.swagger.io").setPath("v2/pet/10010000000");

            HttpGet httpGet = new HttpGet(uriBuilder.build());
            httpGet.addHeader("accept","application/json");

            HttpResponse response = httpClient.execute(httpGet);
            Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));
            Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);

            PetPojoOption2 parsedPet = objectMapper.readValue(response.getEntity().getContent(), PetPojoOption2.class);
            System.out.println(parsedPet.getCategory().getName());




        }


    }



