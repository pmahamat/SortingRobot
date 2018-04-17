package Test;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;

public class SerialConnector implements SerialPortDataListener {
    static SerialPort[] portNames = SerialPort.getCommPorts();
    static SerialPort arduino;

     SerialConnector() {
        for (SerialPort serialPort: portNames
             ) {
            System.out.println(serialPort.getSystemPortName());
            arduino = serialPort;
        }

        arduino.openPort();
        arduino.setBaudRate(9600);
    }

    public void SendMessage(String s) {

        byte[] buffer = s.getBytes();
        arduino.writeBytes(buffer, buffer.length);
    }

    @Override
    public int getListeningEvents() {
        return 0;
    }

    @Override
    public void serialEvent(SerialPortEvent serialPortEvent) {
        serialPortEvent.getReceivedData();
    }
}
