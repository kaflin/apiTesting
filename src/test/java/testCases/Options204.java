package testCases;

import base.BaseClass;
import org.apache.http.client.methods.HttpOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ResponseUtils;

import java.io.IOException;

public class Options204 extends BaseClass {
    // to test Options method:
    //Options methods helps to confirm WebApi under Test indeed supports these operation like "GET,POST,PATCh,PUT,DELETE"
    @Test
    public void optionsReturnsCorrectMethodList() throws IOException {
        String header = "Access-Control-Allow-Methods";

        String expectedReply ="GET, POST, PATCH, PUT, DELETE";
        HttpOptions request =new HttpOptions(BASE_ENDPOINT);
        response =client.execute(request);

        String actualValue = ResponseUtils.getHeader(response, header);
        Assert.assertEquals(actualValue,expectedReply);
    }

}
