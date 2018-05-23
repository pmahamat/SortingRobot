import HMI.MainController;
import HMI.SamenstelRobot;
import HMI.SorteerRobot;
import HMI.Systeem;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//import Test.SchermHMI;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        SorteerRobot sorteerRobot = new SorteerRobot("sorteerRobot");
        SamenstelRobot samenstelRobot = new SamenstelRobot("samenstelrobot");
        Systeem systeem = new Systeem(sorteerRobot, samenstelRobot);


        FXMLLoader loader = new FXMLLoader(getClass().getResource("HMI/HMI.fxml"));
        Parent root = loader.load();
        MainController controller = loader.getController();
        controller.setSysteem(systeem);

        primaryStage.setTitle("HMI");
        primaryStage.setScene(new Scene(root, 650, 500));
        primaryStage.show();
    }
}
