package Test;

import javafx.scene.control.Alert;

import javax.swing.*;
import java.awt.*;

public class LogScreen extends JDialog {
    private JTextField jtfWachtwoord;

    public LogScreen(){
        setSize(220, 100);
        setTitle("Log");
        setLayout(new GridLayout(3, 2));

        jtfWachtwoord = new JTextField(10);
        add(jtfWachtwoord);
        setVisible(true);
    }
}
