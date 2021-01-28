package api_class.get;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EXGameOfThrones {


    @Test
    public void getGameOfThrones() throws URISyntaxException, IOException {

        HttpClient httpClient = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("Http").setHost("api.got.show").setPath("api/show/characters");
        HttpGet get = new HttpGet(uriBuilder.build());
        get.addHeader("accept","application/json");

        HttpResponse response = httpClient.execute(get);

        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));

        ObjectMapper objectMapper = new ObjectMapper();

        List<Map<String,Object>> list = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<List<Map<String, Object>>>() {
        });

        List<Object> strList = new ArrayList<>();
        for (int i =0; i< list.size(); i++){
            Map<String,Object> map =list.get(i);
            strList.add(map.get("siblings"));
        }
        System.out.println(strList);


    }

    @Test
    public void test2() throws URISyntaxException, IOException {

        HttpClient client =HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("Https").setHost("petstore.swagger.io")
                .setPath("v2/pet/1").setParameter("size","256");

        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("accept","application/json");

        HttpResponse response = client.execute(httpGet);
            ObjectMapper objectMapper = new ObjectMapper();

        Map<String,Object> lists =objectMapper
                .readValue(response.getEntity().getContent(),new TypeReference<Map<String,Object>>(){});

        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));
        Assert.assertEquals(response.getStatusLine().getStatusCode(),HttpStatus.SC_OK);

      ;
        List<Map<String,Object>> listMaps =(List<Map<String, Object>>) lists.get("tags");
        System.out.println(  listMaps.get(0).get("id"));


    }





}
