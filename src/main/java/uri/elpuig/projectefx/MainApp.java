package uri.elpuig.projectefx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import uri.elpuig.projectefx.control.ControlDoSomething;

import java.io.IOException;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("bored.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 400);

        stage.setTitle("Bored?");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }



}
