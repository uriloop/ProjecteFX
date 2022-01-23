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
@FXML TextField participants;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        dificultat=new Slider();
        tipus.setTooltip(new Tooltip("Select type"));
        tipus= new ChoiceBox(FXCollections.observableArrayList(
                "Tría", "Education", "Recreational","Social","DIY","Charity","Cooking","Relaxation","Music","Busywork")
        );

        participants= new TextField();
        dificultat.setMin(0);
        dificultat.setMax(1);
        gratis= new CheckBox();



        if (reiniciar.isPressed()){

        }
       /* if (buscar.isPressed()){


        }*/

    }

    private void reiniciar(){
        dificultat.setValue(0);
        tipus.setValue("Tría");
        gratis.setSelected(false);
        participants.setText("");
/*
        activitat.setText("");
*/
    }




    private void buscar(){
        StringBuilder sb= new StringBuilder();
        if (gratis.isSelected()) sb.append("activity?price=0.0&");
        if(!participants.getText().equals("")) sb.append("activity?participants="+participants.getText()+"&");
        sb.append("activity?minaccessibility=0&maxaccessibility="+dificultat.getValue()+"&");
        switch (tipus.getValue().toString()){
            case "Tría":
                break;
            case "Education":
                sb.append("activity?type=education&");
                break;
            case "Recreational":
                sb.append("activity?type=recreational&");
                break;
            case "Social":
                sb.append("activity?type=social&");
                break;
            case "DIY":
                sb.append("activity?type=diy&");
                break;
            case "Charity":
                sb.append("activity?type=charity&");
                break;
            case "Cooking":
                sb.append("activity?type=cooking&");
                break;
            case "Relaxation":
                sb.append("activity?type=relaxation&");
                break;
            case "Music":
                sb.append("activity?type=music&");
                break;
            case "Busywork":
                sb.append("activity?type=busywork&");
                break;
        }
        Connection connect= new Connection();
        DoSomething activity= connect.getRandomActivityToDo(sb.toString());
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