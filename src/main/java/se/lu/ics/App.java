package se.lu.ics;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import se.lu.ics.controllers.MainViewController;
import se.lu.ics.models.CustomerRegister;

public class Main extends Application {

    // The main method is the entry point of any Java application. For JavaFX applications, 
    // it should call the launch() method, which in turn calls the start() method
    public static void main(String[] args) {
        launch();
    }

    // The start method is the main entry point for all JavaFX applications. 
    @Override
    public void start(Stage primaryStage) throws Exception {

        // Create an instance of the CustomerRegister class which will be used to store customers
        CustomerRegister customerRegister = new CustomerRegister();

        // Get the location of the MainView.fxml file which defines the layout of the GUI
        // The location is relative to the root of the classpath (target/classes)
        URL location = getClass().getResource("/fxml/MainView.fxml");

        // Create a new FXMLLoader with the location of the FXML file
        FXMLLoader fxmlLoader = new FXMLLoader(location);

        // Load the FXML file to create the UI layout as defined in MainView.fxml
        AnchorPane root = fxmlLoader.load();


        // Get the controller associated with the FXML file
        // that has been automatically instantiated by the FXMLLoader
        MainViewController controller = fxmlLoader.getController();

        // Set the customer register in the controller to link the UI with the customer registration logic
        controller.setCustomerRegister(customerRegister);
        
        // Create a scene with the root node and set it on the primary stage
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        // Set the title of the primary stage (window title) and display the stage
        primaryStage.setTitle("Customers and Credit Cards");
        primaryStage.show();
    }
}
