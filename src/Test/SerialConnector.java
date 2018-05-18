package Test;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;
import com.mysql.cj.xdevapi.JsonString;
import javafx.scene.paint.Color;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import javafx.scene.paint.*;

import java.awt.*;

public class SerialConnector {
    String test = "";
    String Stringaf = "";
    private static SerialPort[] serialPorts = SerialPort.getCommPorts();
    private SerialPort arduino;
    boolean done = false;
    MainController controller;

    SerialConnector(int port, MainController controller) {
        try {
            this.controller = controller;
            arduino = serialPorts[port - 1];

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
                        json += ((char) aNewData);
                    }
                    if (!json.contains("\n")) {
                        test += json;
                    } else {
                        int n = json.indexOf("\n");
                        test += json.substring(0, n);
                        test.replace("\n", "");
//                        System.out.println(test);
                        Stringaf = test;
                        test = "";
                        done = true;
                        test += json.substring(n + 1);
                    }
                    if (done) {
                      JSONParser parser = new JSONParser();
                        try {
                            JSONObject jsonObj = (JSONObject) parser.parse(Stringaf);
                            String type = (String) jsonObj.get("type");
                            System.out.println(jsonObj.toJSONString());
                            if(type.equals("lastscannedColor")){
                                System.out.println("last scanned");
                                String rood = (String) jsonObj.get("rood");
                                int roodInt = Integer.parseInt(rood);
                                String groen = (String) jsonObj.get("groen");
                                int groenInt = Integer.parseInt(groen);
                                String blauw = (String) jsonObj.get("blauw");
                                int blauwInt = Integer.parseInt(blauw);
                                Color kleur = Color.rgb(roodInt, groenInt, blauwInt);
                                controller.setLastScannedColor(kleur);
                            }
                            if(type.equals("statusRobot2")){
                                System.out.println("statusRobot2");
                                String status = (String) jsonObj.get("status");
                                int statusInt = Integer.parseInt(status);
                                if (statusInt == 1){
                                    controller.statusRobot1.setFill(Color.GREEN);
                                    controller.getSysteem().getSamenstelRobot().setOn(true);
                                }else {
                                    controller.statusRobot1.setFill(Color.RED);
                                    controller.getSysteem().getSamenstelRobot().setOn(false);
                                }
                            }
                        } catch (ParseException e) {
                            e.printStackTrace();
                            System.out.println("mislukt");
                        }
                        Stringaf = "";
                        done = false;
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
