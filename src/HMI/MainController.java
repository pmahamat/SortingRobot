package HMI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class MainController {

    private Database database = new Database();
    private Logger log = new Logger();

    public void setSysteem(Systeem systeem) {
        this.systeem = systeem;
        ArrayList<String> alpha = database.SelectNaamSamenstelling();
        Collections.sort(alpha);
        samenstellingen.getItems().addAll(alpha);
    }

    private SerialConnector serialConnector1 = new SerialConnector(1, this);
    private SerialConnector serialConnector2 = new SerialConnector(2, this);

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
    private Text textStatusBakje2;

    @FXML
    private Text textStatusBakje3;

    @FXML
    private Text textStatusBakje4;

    @FXML
    private Text textStatusBakje5;

    @FXML
    private Text scannedObjectsCounter;

    @FXML
    private TextField opslaanText;

    @FXML
    private Button StartStop1;

    @FXML
    private Circle statusRobot1;

    @FXML
    private ComboBox kleur1;

    @FXML
    private ComboBox kleur2;

    @FXML
    private ComboBox kleur3;

    @FXML
    private ComboBox kleur4;

    @FXML
    public Label statusRobot2Bakje1;

    @FXML
    public Label statusRobot2Bakje2;

    @FXML
    public Label statusRobot2Bakje3;

    @FXML
    public Label statusRobot2Bakje4;

    @FXML
    public Label statusRobot2Batch;

    @FXML
    private Spinner<Integer> aantalKleur1;

    @FXML
    private Spinner<Integer> aantalKleur2;

    @FXML
    private Spinner<Integer> aantalKleur3;

    @FXML
    private Spinner<Integer> aantalKleur4;

    @FXML
    private Spinner<Integer> aantalBatches;

    @FXML
    private Button startStop2;

    @FXML
    public Circle statusRobot2;

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
    void setAantal4(InputMethodEvent event) {

    }

    @FXML
    void setAantalBatches(InputMethodEvent event) {

    }

    @FXML
    void setColor1(ActionEvent event) {
//        systeem.getSorteerRobot().setKleur1(kleur1.getValue());

        serialConnector1.SendMessage("{\n" +
                "\"type\": \"kleur1\",\n" +
                "\"red\":\"" + SorteerRobot.getKleur1().getRed() + "\",\n" +
                "\"green\" : \"" + SorteerRobot.getKleur1().getGreen() + "\",\n" +
                "\"blue\": \"" + SorteerRobot.getKleur1().getBlue() + "\"\n" +
                "}");
    }

    @FXML
    void setColor2(ActionEvent event) {
//        systeem.getSorteerRobot().setKleur2(kleur2.getValue());

        serialConnector1.SendMessage("{\n" +
                "\"type\": \"kleur2\",\n" +
                "\"red\":\"" + SorteerRobot.getKleur2().getRed() + "\",\n" +
                "\"green\" : \"" + SorteerRobot.getKleur2().getGreen() + "\",\n" +
                "\"blue\": \"" + SorteerRobot.getKleur2().getBlue() + "\"\n" +
                "}");
    }

    @FXML
    void setColor3(ActionEvent event) {
//        systeem.getSorteerRobot().setKleur3(kleur3.getValue());

        serialConnector1.SendMessage("{\n" +
                "\"type\": \"kleur3\",\n" +
                "\"red\":\"" + SorteerRobot.getKleur3().getRed() + "\",\n" +
                "\"green\" : \"" + SorteerRobot.getKleur3().getGreen() + "\",\n" +
                "\"blue\": \"" + SorteerRobot.getKleur3().getBlue() + "\"\n" +
                "}");
    }

    @FXML
    void setColor4(ActionEvent event) {
//        systeem.getSorteerRobot().setKleur4(kleur4.getValue());

        serialConnector1.SendMessage("{\n" +
                "\"type\": \"kleur4\",\n" +
                "\"red\":\"" + SorteerRobot.getKleur4().getRed() + "\",\n" +
                "\"green\" : \"" + SorteerRobot.getKleur4().getGreen() + "\",\n" +
                "\"blue\": \"" + SorteerRobot.getKleur4().getBlue() + "\"\n" +
                "}");
    }

    public void setStatusRobot1() {
        if (systeem.getSorteerRobot().getOn()) {
            statusRobot1.setFill(Color.GREEN);
        } else {
            statusRobot1.setFill(Color.RED);
        }
    }

    @FXML
    public void startRobot2(javafx.event.ActionEvent actionEvent) {
        systeem.getSamenstelRobot().switchPower();
        if (systeem.getSamenstelRobot().getOn()) {
            statusRobot2.setFill(Color.GREEN);
        } else {
            statusRobot2.setFill(Color.RED);
        }
    }

    @FXML
    public void startRobot1() {
        systeem.getSorteerRobot().switchPower();
        if (systeem.getSorteerRobot().getOn()) {
            statusRobot1.setFill(Color.GREEN);
        } else {
            statusRobot1.setFill(Color.RED);
        }
    }

    @FXML
    public void slaOp() {
        boolean Naambestaad = false;
        ArrayList<String> namen = database.SelectNaamSamenstelling();
        System.out.println(opslaanText.getText());
        for (String naam : namen) {
            if (naam.equals(opslaanText.getText())) {
                Naambestaad = true;
            }
            System.out.println(naam);
        }
        if (Naambestaad) {
            log.Log("samenstelling opslaan mistukt: naam bestaat al", 2);
        } else {
            int kleur1aantal = aantalKleur1.getValue();
            int kleur2aantal = aantalKleur2.getValue();
            int kleur3aantal = aantalKleur3.getValue();
            int kleur4aantal = aantalKleur4.getValue();
            database.insertSamenstelling(opslaanText.getText(), kleur1aantal, kleur2aantal, kleur3aantal, kleur4aantal, kleur1.getValue().toString(), kleur2.getValue().toString(), kleur3.getValue().toString(), kleur4.getValue().toString());
            samenstellingen.getItems().addAll(opslaanText.getText());
        }
    }

    @FXML
    public void getSamenstellingen() {
        ArrayList<Integer> waardeBakken;
        ArrayList<String> kleuren;
        waardeBakken = database.SelectSamenstelling(samenstellingen.getValue().toString());
        kleuren = database.SelectSamenstellingKleuren(samenstellingen.getValue().toString());
        aantalKleur1.getValueFactory().setValue(waardeBakken.get(0));
        aantalKleur2.getValueFactory().setValue(waardeBakken.get(1));
        aantalKleur3.getValueFactory().setValue(waardeBakken.get(2));
        aantalKleur4.getValueFactory().setValue(waardeBakken.get(3));
        kleur1.setValue(kleuren.get(0));
        kleur2.setValue(kleuren.get(1));
        kleur3.setValue(kleuren.get(2));
        kleur4.setValue(kleuren.get(3));
    }


    @FXML
    public void openLog1() {
        LogScreen logscreen1 = new LogScreen();

    }

    @FXML
    public void verzend1() {
        boolean hasValues = true;

        ArrayList<ComboBox> kleuren = new ArrayList<ComboBox>();
        kleuren.add(kleur1);
        kleuren.add(kleur2);
        kleuren.add(kleur3);
        kleuren.add(kleur4);

        for (ComboBox kleur:kleuren) {
            if (kleur.getValue() == null){
                hasValues = false;
                break;
            }
        }

        if(systeem.getSorteerRobot().getOn() == true)
        {
            JOptionPane.showMessageDialog(null, "De robot moet uit zijn om te kunnen verzenden.");
        } else if(!hasValues){
            JOptionPane.showMessageDialog(null, "Elke kleur moet een waarde hebben");
        } else {
            serialConnector2.SendMessage(
                    "{\"type\":\"SorteerRobot\"," +
                            "\"kleur1\":\"" + kleur1.getValue() + "\"," +
                            "\"kleur2\":\"" + kleur2.getValue() + "\"," +
                            "\"kleur3\":\"" + kleur3.getValue() + "\"," +
                            "\"kleur4\":\"" + kleur4.getValue() + "\"}");
            Logger.Log("Kleuren verzonden: " + kleur1.getValue() + ", " + kleur2.getValue() + ", "
                    + kleur3.getValue() + ", " + kleur4.getValue(), 3);
            JOptionPane.showMessageDialog(null, "Kleuren verzonden.");
        }
    }

    @FXML
    public void verzend2() {
        if(systeem.getSamenstelRobot().getOn() == true){
            JOptionPane.showMessageDialog(null, "De robot moet uit zijn om te kunnen verzenden.");
        }else {
            serialConnector2.SendMessage(
                    "{\"type\":\"samenstelling\"," +
                            "\"kleur1\":\"" + aantalKleur1.getValue() + "\"," +
                            "\"kleur2\":\"" + aantalKleur2.getValue() + "\"," +
                            "\"kleur3\":\"" + aantalKleur3.getValue() + "\"," +
                            "\"kleur4\":\"" + aantalKleur4.getValue() + "\"," +
                            "\"batches\":\"" + aantalBatches.getValue() + "\"}");
            Logger.Log("Aantallen verzonden: "+ aantalKleur1.getValue() + "->kleur1, " + aantalKleur2.getValue() + "->kleur2, "
                    + aantalKleur3.getValue() + "->kleur3, " + aantalKleur4.getValue() + "->kleur4, " + aantalBatches.getValue() + "->batches", 3);
        }
    }

    public void setLastScannedColor(Color kleur) {
        lastScannedColor.setFill(kleur);
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

    public Systeem getSysteem() {
        return systeem;
    }

    public void setCircleStatusBakje4(Circle circleStatusBakje4) {
        this.circleStatusBakje4 = circleStatusBakje4;
    }

    public void setCircleStatusBakje5(Circle circleStatusBakje5) {
        this.circleStatusBakje5 = circleStatusBakje5;
    }

    public void setTextStatusBakje1(String textStatusBakje1) {
        clearBakjes();
        this.textStatusBakje1.setText(textStatusBakje1);
    }

    public void setTextStatusBakje2(String textStatusBakje2) {
        clearBakjes();
        this.textStatusBakje2.setText(textStatusBakje2);
    }
    public void setTextStatusBakje3(String textStatusBakje3) {
        clearBakjes();
        this.textStatusBakje3.setText(textStatusBakje3);
    }
    public void setTextStatusBakje4(String textStatusBakje4) {
        clearBakjes();
        this.textStatusBakje4.setText(textStatusBakje4);
    }
    public void setTextStatusBakje5(String textStatusBakje5) {
        clearBakjes();
        this.textStatusBakje5.setText(textStatusBakje5);
    }

    public void setScannedObjectsCounter(Long counter) {
        this.scannedObjectsCounter.setText(Long.toString(counter));
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

    private void clearBakjes(){
        textStatusBakje1.setText("-");
        textStatusBakje2.setText("-");
        textStatusBakje3.setText("-");
        textStatusBakje4.setText("-");
        textStatusBakje5.setText("-");
    }
}
