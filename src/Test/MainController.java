package Test;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import javafx.event.ActionEvent;

public class MainController {

//    public MainController(Systeem systeem){
//        this.systeem =systeem;
//    }

    public void setSysteem(Systeem systeem) {
        this.systeem = systeem;
    }

    private Systeem systeem;

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

    @FXML
    void setAantal1(javafx.scene.input.InputMethodEvent event) {

    }

    @FXML
    void setAantal2(InputMethodEvent event) {
        System.out.println("hoi");
    }

    @FXML
    void setAantal3(InputMethodEvent event) {

    }
    @FXML
    void setAantal4(InputMethodEvent event){

    }

    @FXML
    void setAantalBatches(InputMethodEvent event) {

    }

    @FXML
    void setColor1(ActionEvent event) {
        System.out.println("hoi");
    }

    @FXML
    void setColor2(ActionEvent event) {

    }

    @FXML
    void setColor3(ActionEvent event) {

    }

    @FXML
    void setColor4(ActionEvent event) {

    }

    @FXML
    public void startRobot2(javafx.event.ActionEvent actionEvent) {
        systeem.getSamenstelRobot().switchPower();
        if(systeem.getSamenstelRobot().getOn())
        {
            statusRobot2.setFill(Color.GREEN);
        }else
        {
            statusRobot2.setFill(Color.RED);
        }
    }

    @FXML
    public  void  startRobot1(){
        systeem.getSorteerRobot().switchPower();
        if(systeem.getSorteerRobot().getOn())
        {
            statusRobot1.setFill(Color.GREEN);
        }else
        {
            statusRobot1.setFill(Color.RED);
        }
    }
}
