package uri.elpuig.projectefx.connection;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import uri.elpuig.projectefx.PublicIP;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.MalformedInputException;

public class Connection {
    private String url_source = connectionConfig.URL_OWM;

    public PublicIP getPublicIp(String params) {
        PublicIP ip = null;
        URL url = null;
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

   /* public Forecast getForecast(String params) {
        Forecast forecast = null;
        URL url = null;
        StringBuilder sb = new StringBuilder(configData.URL_OWM).append(params).append("&appid=").append(configData.API_KEY);

        try {
            url = new URL(sb.toString());
            forecast = new ObjectMapper().readValue(url, Forecast.class);
        } catch (MalformedURLException | JsonMappingException | JsonParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return forecast;


    }
*/
}
