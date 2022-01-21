package uri.elpuig.projectefx.connection;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import uri.elpuig.projectefx.model.DoSomething;
import uri.elpuig.projectefx.model.PublicIP;


import java.io.IOException;
import java.net.URL;
import java.nio.charset.MalformedInputException;

public class Connection {
    private String url_source;

    public PublicIP getPublicIp(String params) {
        PublicIP ip = null;
        URL url = null;
        url_source = connectionConfig.URL_IP;
        StringBuilder sb = new StringBuilder(url_source).append(params);
        try {
            url = new URL(sb.toString());
            ip = new ObjectMapper().readValue(url, PublicIP.class);
        } catch (JsonProcessingException | MalformedInputException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ip;

    }

    public DoSomething getRandomActivityToDo(String params) {

        DoSomething activity = null;
        URL url = null;
        String url_source2 = connectionConfig.URL_DO_RANDOM;
        StringBuilder sb = new StringBuilder(url_source2).append(params);

        try {
            url = new URL(sb.toString());
            activity = new ObjectMapper().readValue(url, DoSomething.class);
        } catch (JsonProcessingException | MalformedInputException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return activity;


    }


}
