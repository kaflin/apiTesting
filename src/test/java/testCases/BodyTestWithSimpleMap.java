package testCases;

import base.BaseClass;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

import static entities.User.ID;
import static entities.User.LOGIN;

public class BodyTestWithSimpleMap extends BaseClass {

    @Test
    public void returnsCorrectLogin() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT+ "/users/kaflin");
        response = client.execute(get);

        String jsonBody=EntityUtils.toString(response.getEntity());
//        System.out.println(jsonBody);

        JSONObject jsonObject = new JSONObject(jsonBody);
         String loginvalue= (String) getValueFor(jsonObject,LOGIN);
        Assert.assertEquals(loginvalue,"kaflin");
    }
    @Test
    public void returnsCorrectId() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT+ "/users/kaflin");
        response = client.execute(get);

        String jsonBody=EntityUtils.toString(response.getEntity());
//        System.out.println(jsonBody);

        JSONObject jsonObject = new JSONObject(jsonBody);
        Integer loginId= (Integer) getValueFor(jsonObject,ID);
        Assert.assertEquals(loginId,Integer.valueOf(43107348));
    }

    private Object getValueFor(JSONObject jsonObject, String key ) {
        try {
            return jsonObject.get(key);
        }catch (Exception e){
            e.printStackTrace();
            return "Not found the key";
        }
    }
}
//Marshalling:-Changing Java Object to JSON/XML object
//UnMarshalling:- Changing JSON/XML object to Java Object