package api_class.get;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class GETIntro {

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

    @Test
    public void getTest() throws URISyntaxException, IOException {

        //Launch/initialize the client
        HttpClient client = HttpClientBuilder.create().build();

        //Construct URL : https://petstore.swagger.io/v2/store/inventory
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("petstore.swagger.io");
        uriBuilder.setPath("v2/store/inventory");

        //Define the Http Method
        HttpGet httpGet = new HttpGet(uriBuilder.build());


        //Add parameters (if needed):
        httpGet.addHeader("accept","application/json");


        //Execute API call
       HttpResponse response = client.execute(httpGet);

        Assert.assertEquals(response.getStatusLine().getStatusCode(),200);


    }

    @Test
    public void getTest2() throws URISyntaxException, IOException {
        //initialize http client
        HttpClient client = HttpClientBuilder.create().build();

        //construct the URL: https://reqres.in/api/user/2
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("reqres.in");
        uriBuilder.setPath("api/user/2");

        //Define the Http Method
        HttpGet httpGet =new HttpGet(uriBuilder.build());

        //Add parameters (if needed):
        httpGet.addHeader("accept","application/json");

        //Execute API call
        HttpResponse response = client.execute(httpGet);

        Assert.assertEquals(response.getStatusLine().getStatusCode(),200);




    }


}
