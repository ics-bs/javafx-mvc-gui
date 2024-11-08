package se.lu.ics.controllers;

import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import se.lu.ics.models.AppModel;

public class AppController {
    private final Stage primaryStage;
    private final AppModel appModel;

    public AppController(Stage primaryStage, AppModel appModel) {
        this.primaryStage = primaryStage;
        this.appModel = appModel;
    }

    public void showMainView() {
        try {
            // Get the location of the MainView.fxml file which defines the layout of the
            // GUI
            // The location is relative to the root of the classpath (target/classes)
            URL location = getClass().getResource("/fxml/MainView.fxml");

            // Create a new FXMLLoader with the location of the FXML file
            FXMLLoader fxmlLoader = new FXMLLoader(location);

            // Load the FXML file to create the UI layout as defined in MainView.fxml
            AnchorPane root = fxmlLoader.load();

            // Get the controller associated with the FXML file
            // that has been automatically instantiated by the FXMLLoader
            MainViewController controller = fxmlLoader.getController();

            controller.setAppController(this);
            controller.setAppModel(appModel);

            // Create a scene with the root node and set it on the primary stage
            Scene scene = new Scene(root);
            
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}