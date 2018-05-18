package Test;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;
import com.mysql.cj.xdevapi.JsonString;


public class SerialConnector {
    String test = "";
    String Stringaf = "";
    private static SerialPort[] serialPorts = SerialPort.getCommPorts();
    private SerialPort arduino;
    boolean done = false;

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
                        int n = json.indexOf("\n");
                        test += json.substring(0, n);
                        test.replace("\n","");
                        System.out.println(test);
                        Stringaf = test;
                        test = "";
                        test += json.substring(n+1);


                    }
                    if (Stringaf.contains("lastscannedColor")){
//                        System.out.println("test");
                        int y = Stringaf.indexOf("rood");
                        System.out.println(Stringaf.substring(y+6,y+9).replaceAll("[^0-9]",""));
                        y = Stringaf.indexOf("blauw");
                        System.out.println(Stringaf.substring(y+7,y+10).replaceAll("[^0-9]",""));
                        y = Stringaf.indexOf("groen");
                        System.out.println(Stringaf.substring(y+7,y+10).replaceAll("[^0-9]",""));
//                        System.out.println(y);
                        Stringaf = "";
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
