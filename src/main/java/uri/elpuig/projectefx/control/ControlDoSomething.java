package uri.elpuig.projectefx.control;

import eu.hansolo.tilesfx.Tile;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import uri.elpuig.projectefx.connection.Connection;
import uri.elpuig.projectefx.model.DoSomething;
import uri.elpuig.projectefx.model.PublicIP;

import java.net.URL;
import java.util.ResourceBundle;

public class ControlDoSomething implements Initializable {

    String params = "";

    public ControlDoSomething() {
    }

    @FXML
    AnchorPane backgroundPane;
    @FXML
    Slider dificultat;
    @FXML
    ChoiceBox tipus;
    @FXML
    CheckBox gratis;
    @FXML
    TextArea activitat;
    @FXML
    Button reiniciar;
    @FXML
    Button buscar;
    @FXML
    TextField participants;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> hola = FXCollections.observableArrayList(
                "", "Education", "Recreational", "Social", "DIY", "Charity", "Cooking", "Relaxation", "Music", "Busywork");


        tipus.setItems(hola);
        tipus.setTooltip(new Tooltip("Select type"));


        dificultat.setMin(0);
        dificultat.setMax(1);


    }

    @FXML
    private void reiniciar() {
        dificultat.setValue(0);
        tipus.getSelectionModel();
        gratis.setSelected(false);
        participants.setText("");


    }


    @FXML
    private void buscar() {
        StringBuilder sb = new StringBuilder();
        if (gratis.isSelected()) sb.append("?price=0.0&");
        if (!participants.getText().equals("")) sb.append("?participants=" + participants.getText() + "&");
        sb.append("?minaccessibility=0&maxaccessibility=" + dificultat.getValue() + "&");
        if (tipus.isShowing()) {
            switch (tipus.getValue().toString()) {
                case "Education":
                    sb.append("?type=education&");
                    break;
                case "Recreational":
                    sb.append("?type=recreational&");
                    break;
                case "Social":
                    sb.append("?type=social&");
                    break;
                case "DIY":
                    sb.append("?type=diy&");
                    break;
                case "Charity":
                    sb.append("?type=charity&");
                    break;
                case "Cooking":
                    sb.append("?type=cooking&");
                    break;
                case "Relaxation":
                    sb.append("?type=relaxation&");
                    break;
                case "Music":
                    sb.append("?type=music&");
                    break;
                case "Busywork":
                    sb.append("?type=busywork&");
                    break;
                case "":
                    break;
            }
        }
        Connection connect = new Connection();

        DoSomething activity = connect.getRandomActivityToDo(sb.toString());

        activitat.setText(activity.getActivity());



    }




/*                  ETIQUETES DE TIPUS D'ACTIVITAT

    ["education", "recreational", "social", "diy", "charity", "cooking", "relaxation", "music", "busywork"]
*/




    /*public static void main(String[] args) {
        Connection connection = new Connection();
        DoSomething activity = connection.getRandomActivityToDo("api/activity");
        System.out.println(activity.toString());
        System.out.println(activity.activity);

    }*/

}