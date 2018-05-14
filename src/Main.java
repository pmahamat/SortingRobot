import Test.*;
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


    public static void main(String[] args) {
//        SorteerRobot sorteerRobot = new SorteerRobot("sorteerRobot");
//        SamenstelRobot samenstelRobot = new SamenstelRobot("samenstelrobot");
//        Systeem systeem = new Systeem(sorteerRobot, samenstelRobot);
//        MainController mainController = new MainController(systeem);
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        SorteerRobot sorteerRobot = new SorteerRobot("sorteerRobot");
        SamenstelRobot samenstelRobot = new SamenstelRobot("samenstelrobot");
        Systeem systeem = new Systeem(sorteerRobot, samenstelRobot);
//        MainController controller = new MainController(systeem);
//
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Test/HMI.fxml"));
//        loader.setController(controller);
//
        Parent root = loader.load();
        MainController controller = loader.getController();
        controller.setSysteem(systeem);

        primaryStage.setTitle("HMI");
        primaryStage.setScene(new Scene(root, 650, 450));
        primaryStage.show();
    }
}
