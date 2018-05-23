package HMI;

import javax.swing.*;
import java.awt.*;


//Screen for showing the logs
public class LogScreen extends JDialog {
    private JTextArea logTekst;

    public LogScreen(){
        setSize(550, 700);
        setTitle("Log");
        setLayout(new FlowLayout());

        logTekst = new JTextArea(40,50);
        JScrollPane scroll = new JScrollPane ( logTekst );
        scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
        logTekst.setEditable(false);
        logTekst.setText(Database.selectLog());
        add(scroll);
        setVisible(true);
    }
}
