package Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {

    private JTextField message;
    private JButton sendMessage;

    private SerialConnector serialConnector = new SerialConnector();

    public GUI() {
        this.setTitle("HMI");

        this.setLayout(new FlowLayout());
        this.setSize(300, 100);
        message = new JTextField();
        message.setText("Voer hier in.");
        message.setSize(250, 75);
        sendMessage = new JButton("Send");

        sendMessage.addActionListener(this);
        message.addActionListener(this);

        this.add(message);
        this.add(sendMessage);
        this.show();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sendMessage) {

            serialConnector.SendMessage(message.getText());
        }
        if (e.getSource() == message) {
            serialConnector.SendMessage(message.getText());
        }
    }
}
