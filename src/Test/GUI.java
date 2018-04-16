package Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {

    JTextField message;
    JButton sendMessage;

    SerialConnector serialConnector = new SerialConnector();

    public GUI(){
        this.setTitle("HMI");

        this.setLayout(new FlowLayout());
        this.setSize(300,100);
        message = new JTextField();
        message.setText("Voer hier in.");
        message.setSize(250, 75);
        sendMessage = new JButton("Send");

        sendMessage.addActionListener(this);
        message.addActionListener(this);

        this.add(message);
        this.add(sendMessage);
        this.show();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == sendMessage) {
            serialConnector.SendMessage(message.getText());
        }
        if(e.getSource() == message) {
            serialConnector.SendMessage(message.getText());
        }
    }
}
