package uri.elpuig.projectefx;

import com.sun.javafx.menu.MenuItemBase;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import uri.elpuig.projectefx.control.ControlDoSomething;
import uri.elpuig.projectefx.model.DoSomething;

import java.io.IOException;

public class MainApp extends Application {

    Scene sceneBored, sceneAbout;

    public MainApp() {


        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("bored.fxml"));
            sceneBored = new Scene(fxmlLoader.load(), 400, 400);
            fxmlLoader = new FXMLLoader(MainApp.class.getResource("aboutBored.fxml"));
            sceneAbout = new Scene(fxmlLoader.load(), 400, 400);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Bored?");
        stage.getIcons().add(new Image("aburrido.png"));
        stage.setScene(sceneAbout);



        /*about.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                stage.setScene(sceneAbout);
            }
        });*/
        stage.setScene(sceneBored);

        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }


}
