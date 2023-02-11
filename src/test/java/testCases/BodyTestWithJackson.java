package testCases;

import base.BaseClass;
import entities.Gists;
import entities.NotFound;
import entities.RateLimit;
import entities.User;
import org.apache.http.client.methods.HttpGet;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ResponseUtils;

import java.io.IOException;

public class BodyTestWithJackson extends BaseClass {
    @Test
    public void returnsCorrectLogin() throws IOException{
        HttpGet get = new HttpGet(BASE_ENDPOINT+"/users/kaflin");
        response =client.execute(get);
        User user= ResponseUtils.unmarshellGeneric(response, User.class);
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
    @Test
    public void correctRateLimitsAreSet() throws IOException{  //Unmarshell of nested json entity
        HttpGet get = new HttpGet(BASE_ENDPOINT+"/rate_limit");
        response =client.execute(get);
        RateLimit rateLimit =ResponseUtils.unmarshellGeneric(response, RateLimit.class);
        Assert.assertEquals(rateLimit.getCoreLimit(),60);
        Assert.assertEquals(rateLimit.getSearchLimit(),"10");
    }
    @Test
    public void gistsDescriptionForParticularId() throws IOException{
        HttpGet get = new HttpGet(BASE_ENDPOINT+"/gists/ceced31fac6b9f1100803820dc804cc7");
        response =client.execute(get);
        Gists gists =ResponseUtils.unmarshellGeneric(response, Gists.class);
        Assert.assertEquals(gists.getDescription(),"tic tac toe");
        Assert.assertEquals(gists.getFileName(),"tic-tac");
    }
}
