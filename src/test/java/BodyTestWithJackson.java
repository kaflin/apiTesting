import entities.NotFound;
import entities.User;
import org.apache.http.client.methods.HttpGet;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class BodyTestWithJackson extends BaseClass {
    @Test
    public void returnsCorrectLogin() throws IOException{
        HttpGet get = new HttpGet(BASE_ENDPOINT+"/users/kaflin");
        response =client.execute(get);
        User user=ResponseUtils.unmarshellGeneric(response, User.class);
        Assert.assertEquals(user.getLogin(),"kaflin");
    }
    @Test
    public void returnsCorrectId() throws IOException{
        HttpGet get = new HttpGet(BASE_ENDPOINT+"/users/kaflin");
        response =client.execute(get);
        User user=ResponseUtils.unmarshellGeneric(response, User.class);
        Assert.assertEquals(user.getId(),43107348);
    }
    @Test
    public void notFoundMessageIsCorrect() throws IOException{
        HttpGet get = new HttpGet(BASE_ENDPOINT+"/nonexistingendpoint");
        response =client.execute(get);
        NotFound notFound=ResponseUtils.unmarshellGeneric(response, NotFound.class);
        Assert.assertEquals(notFound.getMessage(),"Not Found");
    }
}
