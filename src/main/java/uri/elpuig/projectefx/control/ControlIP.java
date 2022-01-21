package uri.elpuig.projectefx.control;

import javafx.fxml.Initializable;
import uri.elpuig.projectefx.model.PublicIP;
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
