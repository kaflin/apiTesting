import entities.TokenStore;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class DeleteAndPost extends BaseClass{

    @Test
    public void deleteIsSuccessful() throws IOException{
        HttpDelete request = new HttpDelete("https://api.github.com/repos/kaflin/deleteRepo1");
        request.setHeader(HttpHeaders.AUTHORIZATION,"Token " +TokenStore.TOKEN_KEY);
        response=client.execute(request);
        int actualStatusCode =response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode,204);
    }

    @Test(description = "This test will work if you set valid Email+password in TokenStore Class")
    public void createRepoReturns201() throws IOException {

        //Define Json to post
        String json = "{\"name\": \"deleteRepo1\"}";
        StringEntity entity =new StringEntity(json);
        // Create an HttpPost with valid Endpoint

        HttpPost request =  new HttpPost("https://api.github.com/user/repos");

        // Set the Basic Auth Header
//        String auth =TokenStore.Email +":"+TokenStore.Password;
//        byte[] encodedAuth= Base64.encodeBase64(auth.getBytes(StandardCharsets.ISO_8859_1));
//        String authHeader = "Basic " + new String(encodedAuth);
        request.setHeader(HttpHeaders.CONTENT_TYPE,"application/json");
        request.setHeader(HttpHeaders.AUTHORIZATION,"Token "+TokenStore.TOKEN_KEY);


        // Set as Entity

        request.setEntity(entity);

        //send
        response =client.execute(request);
        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode,201);

    }
}
