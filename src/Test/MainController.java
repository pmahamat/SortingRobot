package Test;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import sun.applet.Main;

import java.awt.event.ActionEvent;

public class MainController {



    @FXML
    private Rectangle lastScannedColor;

    @FXML
    private Circle cirlceStatusBakje1;

    @FXML
    private Circle circleStatusBakje2;

    @FXML
    private Circle circleStatusBakje3;

    @FXML
    private Circle circleStatusBakje4;

    @FXML
    private Circle circleStatusBakje5;

    @FXML
    private Text textStatusBakje1;

    @FXML
    private Text textStatusBakje3;

    @FXML
    private Text textStatusBakje4;

    @FXML
    private Text textStatusBakje5;

    @FXML
    private Text scannedObjectsCounter;

    @FXML
    private Button StartStop1;

    @FXML
    private Circle statusRobot1;

    @FXML
    private ColorPicker kleur1;

    @FXML
    private ColorPicker kleur2;

    @FXML
    private ColorPicker kleur3;

    @FXML
    private ColorPicker kleur4;

    @FXML
    private Label statusRobot2Bakje1;

    @FXML
    private Label statusRobot2Bakje2;

    @FXML
    private Label statusRobot2Bakje3;

    @FXML
    private Label statusRobot2Bakje4;

    @FXML
    private Label statusRobot2Batch;

    @FXML
    private Spinner<?> aantalKleur1;

    @FXML
    private Spinner<?> aantalKleur2;

    @FXML
    private Spinner<?> aantalKleur3;

    @FXML
    private Spinner<?> aantalKleur4;

    @FXML
    private Spinner<?> aantalBatches;

    @FXML
    private Button startStop2;

    @FXML
    private Circle statusRobot2;

    public void startRobot2(javafx.event.ActionEvent actionEvent) {
        statusRobot2.setFill(Color.GREEN);
    }

    public void startRobot1(javafx.event.ActionEvent actionEvent) {
        statusRobot1.setFill(Color.GREEN);
    }
}
