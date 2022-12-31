import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.User;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ResponseUtils {
    public static String getHeader(CloseableHttpResponse response, String headerName) {
        //Get All headers
        Header[] headers =response.getAllHeaders();
        List<Header> httpHeaders = Arrays.asList(headers);
        String returnHeader = "";

        //Loop over the headers List
        for(Header header : httpHeaders){
            if(headerName.equalsIgnoreCase(header.getName())){
                returnHeader =header.getValue();
            }
        }
        // If no header found -throw an exception
        if(returnHeader.isEmpty()){
            throw new RuntimeException("Didn't find Header: " + headerName);
        }
        //Return Header
        return returnHeader;
    }
    // Getting Headers using Java 8
    public static String getHeaderJava8Way(CloseableHttpResponse response, final String headerName) {
        List<Header> httpHeaders = Arrays.asList(response.getAllHeaders());

        Header matchedHeader =  httpHeaders.stream()
                                .filter(header -> headerName.equalsIgnoreCase(header.getName()))
                                .findFirst().orElseThrow(() ->new RuntimeException("Didn't find the header"));
        return matchedHeader.getValue();
    }
    public static boolean headerIsPresent(CloseableHttpResponse response, final String headerName) {
        List<Header> httpheaders = Arrays.asList(response.getAllHeaders());
        return httpheaders.stream()
                           .anyMatch(header -> header.getName().equalsIgnoreCase(headerName));
    }
    public static User unmarshell(CloseableHttpResponse response, Class<User> userClass) throws IOException {
        String jsonBody = EntityUtils.toString(response.getEntity());
        return new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false)
                .readValue(jsonBody,userClass);
    }
    public static <T> T unmarshellGeneric(CloseableHttpResponse response, Class<T> userClass) throws IOException {
        String jsonBody = EntityUtils.toString(response.getEntity());
        return new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false)
                .readValue(jsonBody,userClass);
    }


}
// Class<T> :- It is java Generic
