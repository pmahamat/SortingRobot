package Test;

import javafx.scene.control.Alert;

import javax.swing.*;
import java.awt.*;

public class LogScreen extends JDialog {
    private JTextArea logTekst;

    public LogScreen(){
        setSize(480, 700);
        setTitle("Log");
        setLayout(new FlowLayout());

        logTekst = new JTextArea(40,40);
        logTekst.setEditable(false);
        logTekst.setText(Database.selectLog());
        add(logTekst);
        setVisible(true);
    }
}
