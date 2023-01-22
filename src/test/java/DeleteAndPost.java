import entities.TokenStore;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpDelete;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class DeleteAndPost extends BaseClass{

    @Test
    public void deleteIsSuccessful() throws IOException{
        HttpDelete request = new HttpDelete("https://api.github.com/repos/kaflin/deleteRepo");
        request.setHeader(HttpHeaders.AUTHORIZATION,"Token " +TokenStore.TOKEN_KEY);
        response=client.execute(request);
        int actualStatusCode =response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode,204);
    }
}
