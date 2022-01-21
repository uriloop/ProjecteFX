package uri.elpuig.projectefx.control;

import javafx.fxml.Initializable;
import uri.elpuig.projectefx.connection.Connection;
import uri.elpuig.projectefx.model.DoSomething;
import uri.elpuig.projectefx.model.PublicIP;

import java.net.URL;
import java.util.ResourceBundle;

public class ControlDoSomething implements Initializable {

    String params = "";


/*                  ETIQUETES TIPUS

    ["education", "recreational", "social", "diy", "charity", "cooking", "relaxation", "music", "busywork"]
*/




    public static void main(String[] args) {
        Connection connection = new Connection();
        DoSomething activity = connection.getRandomActivityToDo("api/activity");
        System.out.println(activity.toString());
        System.out.println(activity.activity);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Connection connection = new Connection();
        DoSomething activity = connection.getRandomActivityToDo(params);

        System.out.println(activity.toString());


    }
}