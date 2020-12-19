package api_class.get;

import api_class.deserialization.pojo.StarWarsPojo;
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

public class StarWarsGet {


    @Test
    public void starWarsPojoTest() throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("http").setHost("swapi.dev").setPath("api/starships").setParameter("page","2");

        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("accept","application/json");

        HttpResponse response = client.execute(httpGet);
        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));

        ObjectMapper objectMapper = new ObjectMapper();
       StarWarsPojo parsedPojo = objectMapper.readValue(response.getEntity().getContent(), StarWarsPojo.class);
        Assert.assertEquals(parsedPojo.getCount(),36);




    }

    @Test
    public void countAllStarships() throws URISyntaxException, IOException {

        int starShipCount=0;
        int pageNumber =1;
        String nextPage ="";
        while (nextPage!=null){

            String page = String.valueOf(pageNumber);

            HttpClient client = HttpClientBuilder.create().build();

            URIBuilder uriBuilder = new URIBuilder();
            uriBuilder.setScheme("http").setHost("swapi.dev").setPath("api/starships").setParameter("page",page);

            HttpGet httpGet = new HttpGet(uriBuilder.build());
            httpGet.addHeader("accept","application/json");

            HttpResponse response = client.execute(httpGet);
            Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
            Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));

            ObjectMapper objectMapper = new ObjectMapper();
            StarWarsPojo parsedPojo = objectMapper.readValue(response.getEntity().getContent(), StarWarsPojo.class);
            starShipCount+=parsedPojo.getCount();
            pageNumber++;
            nextPage=parsedPojo.getNext();
        }
        System.out.println("Total Number of Ships: " + starShipCount);
    }
}
