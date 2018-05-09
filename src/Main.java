import Test.GUI;
import Test.MainController;
import Test.SorteerRobot;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//import Test.SchermHMI;

import javax.swing.*;
import java.io.IOException;

import static javafx.application.Application.launch;

public class Main extends Application {
    public static SorteerRobot sorteerRobot = new SorteerRobot("Sorteerrobot");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Test/HMI.fxml"));
        primaryStage.setTitle("HMI");
        primaryStage.setScene(new Scene(root, 650, 450));
        primaryStage.show();
    }
}
