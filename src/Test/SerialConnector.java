package Test;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;

public class SerialConnector {
    private static SerialPort[] serialPorts = SerialPort.getCommPorts();
    private static SerialPort arduino;

    SerialConnector() {
        arduino = serialPorts[0];

        arduino.openPort();
        arduino.setBaudRate(9600);

        arduino.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 100, 0);

        arduino.addDataListener(new SerialPortDataListener() {
            @Override
            public int getListeningEvents() {
                return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
            }

            @Override
            public void serialEvent(SerialPortEvent event) {
                if (event.getEventType() != SerialPort.LISTENING_EVENT_DATA_AVAILABLE)
                    return;
                byte[] newData = new byte[arduino.bytesAvailable()];
                int numRead = arduino.readBytes(newData, newData.length);
                for (byte aNewData : newData) System.out.print((char) aNewData);
//                System.out.println("Read " + numRead + " bytes.");
            }
        });

    }

    public void SendMessage(String s) {
        byte[] buffer = s.getBytes();
        arduino.writeBytes(buffer, buffer.length);
    }
}