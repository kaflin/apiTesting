package testCases;

import base.BaseClass;
import org.apache.http.client.methods.HttpGet;
import org.testng.annotations.Test;
import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class Get200 extends BaseClass {
    @Test(priority = 1)
    public void baseUrlReturns200() throws IOException {
       HttpGet get = new HttpGet(BASE_ENDPOINT);
       response=client.execute(get);
       int actualStatus = response.getStatusLine().getStatusCode();
       assertEquals(actualStatus,200);
    }
    @Test(priority = 2)
    public void rateLimitReturns200() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/rate_limit");
        response=client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus,200);
    }
    @Test(priority = 3)
    public void searchReposReturns200() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/search/repositories?q=java");
        response=client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus,200);
    }
    @Test(priority = 4)
    public void publicGistsUrlReturns200() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT+"/gists/public");
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus,200);
    }

}
