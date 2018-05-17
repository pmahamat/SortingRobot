package Test;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;



public class SerialConnector {
    String test = "";
    private static SerialPort[] serialPorts = SerialPort.getCommPorts();
    private SerialPort arduino;

    SerialConnector(int port) {
        try {

            arduino = serialPorts[port -1];

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
                    arduino.readBytes(newData, newData.length);
                    String json = "";

                    for (byte aNewData : newData) {
                        json+=((char) aNewData);
                    }
                    if (!json.contains("\n")){
                        test += json;
                    }else{
                    System.out.println(test);
                    test = "";
                    }
                }
            });

        } catch (Exception error) {
            System.out.println("Arduino not connected");
        }

    }

    public void SendMessage(String s) {
        try {
            byte[] buffer = s.getBytes();
            arduino.writeBytes(buffer, buffer.length);
        } catch (Exception e) {
            System.out.println("Arduino not connected make sure to connect it first.");
        }
    }
}
