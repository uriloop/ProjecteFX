package uri.elpuig.projectefx.control;

import eu.hansolo.tilesfx.Tile;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import uri.elpuig.projectefx.MainApp;
import uri.elpuig.projectefx.connection.Connection;
import uri.elpuig.projectefx.model.DoSomething;
import uri.elpuig.projectefx.model.PublicIP;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControlDoSomething implements Initializable {

    String params = "";

    public ControlDoSomething() {
    }

    /*@FXML
    MenuItem quit;*/
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
    Object defaultValueOfChoiceBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> hola = FXCollections.observableArrayList(
                "", "Education", "Recreational", "Social", "DIY", "Charity", "Cooking", "Relaxation", "Music", "Busywork");
        defaultValueOfChoiceBox = tipus.getValue();

        tipus.setItems(hola);
        tipus.setTooltip(new Tooltip("Select type"));
        dificultat.setMin(0);
        dificultat.setMax(1);


    }

    /*@FXML
    private void quit() {

    }*/

    @FXML
    private void reiniciar() {
        System.out.println("El valor de la barra de dificultat: "+dificultat.getValue());
        dificultat.setValue(0);
        gratis.setSelected(false);
        tipus.show();
        participants.setText("");
        tipus.setValue(defaultValueOfChoiceBox);
        tipus.hide();

    }

 /*   @FXML
    private void about(){
        // tornaar a main i cambiar l'escena? obrir una nova escena desde akí?

        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("bored.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 400, 400);
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.setTitle("Bored?");
        stage.setScene(scene);
        stage.show();


    }*/



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
        participants.setText(String.valueOf(activity.getParticipants()));
        if (activity.getPrice() == 0) gratis.setSelected(true);
        else gratis.setSelected(false);

        dificultat.setValue(activity.getAccessibility());
        tipus.setValue(activity.getType());

    }


}