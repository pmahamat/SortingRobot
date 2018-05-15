package Test;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import javafx.event.ActionEvent;

public class MainController {

    public void setSysteem(Systeem systeem) {
        this.systeem = systeem;
    }

    private SerialConnector serialConnector = new SerialConnector();

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
    private ChoiceBox samenstellingen;

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
        systeem.getSorteerRobot().setKleur1(kleur1.getValue());

        serialConnector.SendMessage("{\n" +
                "  \"type\": \"kleur1\",\n" +
                "  \"red\":\"" + systeem.getSorteerRobot().getKleur1().getRed() + "\",\n" +
                "  \"green\" : \"" + systeem.getSorteerRobot().getKleur1().getGreen() + "\",\n" +
                "  \"blue\": \"" + systeem.getSorteerRobot().getKleur1().getBlue() + "\"\n" +
                "}");
    }

    @FXML
    void setColor2(ActionEvent event) {
        systeem.getSorteerRobot().setKleur2(kleur2.getValue());

        serialConnector.SendMessage("{\n" +
                "  \"type\": \"kleur2\",\n" +
                "  \"red\":\"" + systeem.getSorteerRobot().getKleur2().getRed() + "\",\n" +
                "  \"green\" : \"" + systeem.getSorteerRobot().getKleur2().getGreen() + "\",\n" +
                "  \"blue\": \"" + systeem.getSorteerRobot().getKleur2().getBlue() + "\"\n" +
                "}");
    }

    @FXML
    void setColor3(ActionEvent event) {
        systeem.getSorteerRobot().setKleur3(kleur3.getValue());

        serialConnector.SendMessage("{\n" +
                "  \"type\": \"kleur3\",\n" +
                "  \"red\":\"" + systeem.getSorteerRobot().getKleur3().getRed() + "\",\n" +
                "  \"green\" : \"" + systeem.getSorteerRobot().getKleur3().getGreen() + "\",\n" +
                "  \"blue\": \"" + systeem.getSorteerRobot().getKleur3().getBlue() + "\"\n" +
                "}");
    }

    @FXML
    void setColor4(ActionEvent event) {
        systeem.getSorteerRobot().setKleur4(kleur4.getValue());

        serialConnector.SendMessage("{\n" +
                "  \"type\": \"kleur4\",\n" +
                "  \"red\":\"" + systeem.getSorteerRobot().getKleur4().getRed() + "\",\n" +
                "  \"green\" : \"" + systeem.getSorteerRobot().getKleur4().getGreen() + "\",\n" +
                "  \"blue\": \"" + systeem.getSorteerRobot().getKleur4().getBlue() + "\"\n" +
                "}");
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

    @FXML
    public void slaOp() {

    }

    @FXML
    public void getSamenstellingen(){

    }

    @FXML
    public void openLog1(){

    }
    @FXML
    public void openLog2(){

    }

    @FXML
    public void verzend1() {

    }

    @FXML
    public void verzend2(){

    }

    public void setLastScannedColor(Rectangle lastScannedColor) {
        this.lastScannedColor = lastScannedColor;
    }

    public void setCirlceStatusBakje1(Circle cirlceStatusBakje1) {
        this.cirlceStatusBakje1 = cirlceStatusBakje1;
    }

    public void setCircleStatusBakje2(Circle circleStatusBakje2) {
        this.circleStatusBakje2 = circleStatusBakje2;
    }

    public void setCircleStatusBakje3(Circle circleStatusBakje3) {
        this.circleStatusBakje3 = circleStatusBakje3;
    }

    public void setCircleStatusBakje4(Circle circleStatusBakje4) {
        this.circleStatusBakje4 = circleStatusBakje4;
    }

    public void setCircleStatusBakje5(Circle circleStatusBakje5) {
        this.circleStatusBakje5 = circleStatusBakje5;
    }

    public void setTextStatusBakje1(Text textStatusBakje1) {
        this.textStatusBakje1 = textStatusBakje1;
    }

    public void setTextStatusBakje3(Text textStatusBakje3) {
        this.textStatusBakje3 = textStatusBakje3;
    }

    public void setTextStatusBakje4(Text textStatusBakje4) {
        this.textStatusBakje4 = textStatusBakje4;
    }

    public void setTextStatusBakje5(Text textStatusBakje5) {
        this.textStatusBakje5 = textStatusBakje5;
    }

    public void setScannedObjectsCounter(Text scannedObjectsCounter) {
        this.scannedObjectsCounter = scannedObjectsCounter;
    }

    public void setStatusRobot2Bakje1(Label statusRobot2Bakje1) {
        this.statusRobot2Bakje1 = statusRobot2Bakje1;
    }

    public void setStatusRobot2Bakje2(Label statusRobot2Bakje2) {
        this.statusRobot2Bakje2 = statusRobot2Bakje2;
    }

    public void setStatusRobot2Bakje3(Label statusRobot2Bakje3) {
        this.statusRobot2Bakje3 = statusRobot2Bakje3;
    }

    public void setStatusRobot2Bakje4(Label statusRobot2Bakje4) {
        this.statusRobot2Bakje4 = statusRobot2Bakje4;
    }

    public void setStatusRobot2Batch(Label statusRobot2Batch) {
        this.statusRobot2Batch = statusRobot2Batch;
    }

}
