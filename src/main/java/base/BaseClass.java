package base;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class BaseClass {
    protected static final String BASE_ENDPOINT = "https://api.github.com";

    public CloseableHttpClient client;
    public CloseableHttpResponse response;

    @BeforeMethod
    public void setup(){
        client= HttpClientBuilder.create().build();
    }

    @AfterMethod
    public void closeResources() throws IOException,NullPointerException {
        client.close();
        response.close();
    }

}
