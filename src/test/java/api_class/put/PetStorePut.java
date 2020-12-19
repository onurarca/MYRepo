package api_class.put;

import Utils.PayloadUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import org.testng.Assert;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

public class PetStorePut {

    @Test
    public void perStorePutExample() throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").setHost("petstore.swagger.io").setPath("v2/pet");

        HttpPut httpPut = new HttpPut(uriBuilder.build());
        httpPut.addHeader("accept", "application/json");
        httpPut.addHeader("Content-Type", "application/json");

        int petId = 284840;
        String petname = "MonsterBunny";
        String status = "Carrot Killer";
        String putBody = PayloadUtils.getPetStorePayload(petId, petname, status);
        HttpEntity entity = new StringEntity(putBody);

        httpPut.setEntity(entity);

        HttpResponse response = client.execute(httpPut);

        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));




    }


}
