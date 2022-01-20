package uri.elpuig.projectefx.control;

import com.fasterxml.jackson.databind.jsontype.impl.MinimalClassNameIdResolver;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import uri.elpuig.projectefx.PublicIP;
import uri.elpuig.projectefx.connection.Connection;

import java.net.URL;
import java.util.ResourceBundle;

public class ControlIP implements Initializable {

     String params = "?format=json&location=True/";

    public static void main(String[] args) {
        Connection connection = new Connection();
        PublicIP ip = connection.getPublicIp("?format=json&location=True/");
        System.out.println(ip.toString());
        System.out.println(ip.ip);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Connection connection = new Connection();
        PublicIP ip = connection.getPublicIp(params);

        System.out.println(ip.toString());


    }
}
