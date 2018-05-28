package HMI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import org.json.simple.JSONObject;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

// import static HMI.SorteerRobot.setKleur1;

public class MainController {

    private Database database = new Database();
    private Logger log = new Logger();

    Thread one;

    public void setSysteem(Systeem systeem) {
        this.systeem = systeem;
        ArrayList<String> alpha = database.SelectNaamSamenstelling();
        Collections.sort(alpha);
        samenstellingen.getItems().addAll(alpha);

        one = new Thread(() -> {
            try {
                while (true) {
                    if (serialConnector1.arduino.isOpen()) {
                        System.out.println("Works");
                        log.LogRobot(Integer.parseInt(totaal1.getText()), Integer.parseInt(totaal2.getText()), Integer.parseInt(totaal3.getText()), Integer.parseInt(totaal4.getText()));
                    }

                    Thread.sleep(60000);
                }
            } catch (InterruptedException v) {
                System.out.println(v);
            }
        });

        one.start();
    }

    private SerialConnector serialConnector1 = new SerialConnector(1, this);

    public SerialConnector getSerialConnector1() {
        return serialConnector1;
    }

    public SerialConnector getSerialConnector2() {
        return serialConnector2;
    }

    private SerialConnector serialConnector2 = new SerialConnector(2, this);

    private Systeem systeem;

    @FXML
    public Text totaal1;

    @FXML
    public Text totaal2;

    @FXML
    public Text totaal3;

    @FXML
    public Text totaal4;

    @FXML
    public Text totaal5;

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

    // zet de kleur van de bakjes in de HMI naar de juiste kleur
    public void setColor(int i, Circle circle) {
        String kleur = null;
        switch (i) {
            case 1:
                kleur = kleur1.getValue().toString();
                break;
            case 2:
                kleur = kleur2.getValue().toString();
                break;
            case 3:
                kleur = kleur3.getValue().toString();
                break;
            case 4:
                kleur = kleur4.getValue().toString();
                break;

        }
        switch (kleur) {
            case "Rood":
                circle.setFill(Color.RED);
                break;
            case "Groen":
                circle.setFill(Color.GREEN);
                break;
            case "Blauw":
                circle.setFill(Color.DODGERBLUE);
                break;
            case "Paars":
                circle.setFill(Color.PURPLE);
                break;
            case "Oranje":
                circle.setFill(Color.ORANGE);
                break;
            case "Geel":
                circle.setFill(Color.YELLOW);
                break;
        }
    }

    //als kleur 1 veranderd roep de Functie setColor aan
    @FXML
    void setColor1(ActionEvent event) {
        setColor(1, cirlceStatusBakje1);
    }

    //als kleur 2 veranderd roep de Functie setColor aan
    @FXML
    void setColor2(ActionEvent event) {
        setColor(2, circleStatusBakje2);
    }

    //als kleur 3 veranderd roep de Functie setColor aan
    @FXML
    void setColor3(ActionEvent event) {
        setColor(3, circleStatusBakje3);
    }

    //als kleur 4 veranderd roep de Functie setColor aan
    @FXML
    void setColor4(ActionEvent event) {
        setColor(4, circleStatusBakje4);
    }

    void setStatusRobot1(){
        if (systeem.getSamenstelRobot().getOn()) {
            statusRobot2.setFill(Color.GREEN);
        } else {
            statusRobot2.setFill(Color.RED);
        }
    }

    //switch de status van robot 2
    @FXML
    public void startRobot2(javafx.event.ActionEvent actionEvent) {
        systeem.getSamenstelRobot().switchPower();
        if (systeem.getSamenstelRobot().getOn()) {
            statusRobot2.setFill(Color.GREEN);
        } else {
            statusRobot2.setFill(Color.RED);
        }
        JSONObject obj = new JSONObject();
        obj.put("type", "SwitchPower2");
        serialConnector2.SendMessage(obj.toJSONString());
    }

    //switch de status van robot 1
    @FXML
    public void startRobot1() {
        systeem.getSorteerRobot().switchPower();
        if (systeem.getSorteerRobot().getOn()) {
            statusRobot1.setFill(Color.GREEN);
        } else {
            statusRobot1.setFill(Color.RED);
        }
        JSONObject obj = new JSONObject();
        obj.put("type", "SwitchPower1");
        serialConnector1.SendMessage(obj.toJSONString());
    }

    //sla de samenstelling op in de database
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

    // haal de samenstelling op in de database
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

    //open een nieuw scherm waar de log wordt getoont
    @FXML
    public void openLog1() {
        LogScreen logscreen1 = new LogScreen();

    }

    //verzend de kleuren voor de bakken naar robot 1
    //(met een paar checks zodat er geen dubbele of lege code wordt gestuurdt)
    @FXML
    public void verzend1() {
        boolean hasValues = true;

        ArrayList<ComboBox> kleuren = new ArrayList<ComboBox>();
        kleuren.add(kleur1);
        kleuren.add(kleur2);
        kleuren.add(kleur3);
        kleuren.add(kleur4);
        HashSet<String> set = new HashSet<>();
        ArrayList<String> check = new ArrayList<>();
        for (ComboBox kleur : kleuren) {
            if (kleur.getValue() == null) {
                hasValues = false;
                break;
            }
        }
        if(hasValues){
            for(ComboBox box: kleuren){
                String string = box.getValue().toString();
                if (!set.contains(string)) {
                    check.add(string);
                    set.add(string);
                }
            }
        }
        if (systeem.getSorteerRobot().getOn() == true) {
            JOptionPane.showMessageDialog(null, "De robot moet uit zijn om te kunnen verzenden.");
        } else if (!hasValues) {
            JOptionPane.showMessageDialog(null, "Elke kleur moet een waarde hebben");
        } else if(check.size() < 4){
            JOptionPane.showMessageDialog(null, "Een kleur mag maar een keer voorkomen");
        } else {
//            serialConnector2.SendMessage(
//                    "{\"type\":\"SorteerRobot\"," +
//                            "\"kleur1\":\"" + kleur1.getValue() + "\"," +
//                            "\"kleur2\":\"" + kleur2.getValue() + "\"," +
//                            "\"kleur3\":\"" + kleur3.getValue() + "\"," +
//                            "\"kleur4\":\"" + kleur4.getValue() + "\"}");
            JSONObject obj = new JSONObject();
            obj.put("kleur1", kleur1.getValue());
            obj.put("kleur2", kleur2.getValue());
            obj.put("kleur3", kleur3.getValue());
            obj.put("kleur4", kleur4.getValue());
            serialConnector1.SendMessage(obj.toJSONString());

            Logger.Log("Kleuren verzonden: " + kleur1.getValue() + ", " + kleur2.getValue() + ", "
                    + kleur3.getValue() + ", " + kleur4.getValue(), 3);
            JOptionPane.showMessageDialog(null, "Kleuren verzonden.");
        }
    }

    //verzend de aantalen die robot 2 uit de machine moet halen
    @FXML
    public void verzend2() {
        if (systeem.getSamenstelRobot().getOn() == true) {
            JOptionPane.showMessageDialog(null, "De robot moet uit zijn om te kunnen verzenden.");
        } else {
//            serialConnector1.SendMessage(
//                    "{\"type\":\"samenstelling\"," +
//                            "\"kleur1\":\"" + aantalKleur1.getValue() + "\"," +
//                            "\"kleur2\":\"" + aantalKleur2.getValue() + "\"," +
//                            "\"kleur3\":\"" + aantalKleur3.getValue() + "\"," +
//                            "\"kleur4\":\"" + aantalKleur4.getValue() + "\"," +
//                            "\"batches\":\"" + aantalBatches.getValue() + "\"}");
            JSONObject obj = new JSONObject();
            obj.put("type", "samenstelling");
            obj.put("kleur1", aantalKleur1.getValue());
            obj.put("kleur2", aantalKleur2.getValue());
            obj.put("kleur3", aantalKleur3.getValue());
            obj.put("kleur4", aantalKleur4.getValue());
            obj.put("activator", 1);
            obj.put("batches", aantalBatches.getValue());
            serialConnector2.SendMessage(obj.toJSONString());
            Logger.Log("Aantallen verzonden: " + aantalKleur1.getValue() + "->kleur1, " + aantalKleur2.getValue() + "->kleur2, "
                    + aantalKleur3.getValue() + "->kleur3, " + aantalKleur4.getValue() + "->kleur4, " + aantalBatches.getValue() + "->batches", 3);
        }
    }

    //veranderd de box LastScannedColor
    public void setLastScannedColor(Color kleur) {
        lastScannedColor.setFill(kleur);
    }

    //een mothode zodat we het systeem door kunnen geven
    public Systeem getSysteem() {
        return systeem;
    }

    //zorgt voor visuele weergave van de snoepjes glijbaan
    public void setTextStatusBakje1(String textStatusBakje1) {
        clearBakjes();
        this.textStatusBakje1.setText(textStatusBakje1);
    }

    //zorgt voor visuele weergave van de snoepjes glijbaan
    public void setTextStatusBakje2(String textStatusBakje2) {
        clearBakjes();
        this.textStatusBakje2.setText(textStatusBakje2);
    }

    //zorgt voor visuele weergave van de snoepjes glijbaan
    public void setTextStatusBakje3(String textStatusBakje3) {
        clearBakjes();
        this.textStatusBakje3.setText(textStatusBakje3);
    }

    //zorgt voor visuele weergave van de snoepjes glijbaan
    public void setTextStatusBakje4(String textStatusBakje4) {
        clearBakjes();
        this.textStatusBakje4.setText(textStatusBakje4);
    }

    //zorgt voor visuele weergave van de snoepjes glijbaan
    public void setTextStatusBakje5(String textStatusBakje5) {
        clearBakjes();
        this.textStatusBakje5.setText(textStatusBakje5);
    }

    //verandert de counter
    public void setScannedObjectsCounter(Long counter) {
        this.scannedObjectsCounter.setText(Long.toString(counter));
    }

    //zorgt voor visuele weergave van de snoepjes glijbaan wordt gereset
    private void clearBakjes() {
        textStatusBakje1.setText("-");
        textStatusBakje2.setText("-");
        textStatusBakje3.setText("-");
        textStatusBakje4.setText("-");
        textStatusBakje5.setText("-");
    }
}
