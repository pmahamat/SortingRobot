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
//                            int typeInt = (int) Integer.parseInt(type);
                            System.out.println(jsonObj.toJSONString());
                            if(type.equals("robot1")){
                                System.out.println("last scanned");
                                String kleur = (String) jsonObj.get("kleur");
                                if(kleur.equals("rood")){
                                    controller.setLastScannedColor(Color.RED);
                                }else if (kleur.equals("groen")){
                                    controller.setLastScannedColor(Color.GREEN);
                                }else if (kleur.equals("blauw")) {
                                    controller.setLastScannedColor(Color.BLUE);
                                }else if (kleur.equals("paars")){
                                    controller.setLastScannedColor(Color.PURPLE);
                                }else if (kleur.equals("oranje")){
                                    controller.setLastScannedColor(Color.ORANGE);
                                }else if (kleur.equals("geel")){
                                    controller.setLastScannedColor(Color.YELLOW);
                                }





//                                controller.setScannedObjectsCounter(counter);
//                                controller.setLastScannedColor(kleur);
                            }else if(type.equals("statusRobot1")){
                                String status = (String) jsonObj.get("status");
                                if(status.equals("1")){
                                    //Aan
                                    System.out.println("on");
                                    controller.getSysteem().getSorteerRobot().setOn(Boolean.TRUE);
                                    controller.setStatusRobot1();
                                }else
                                {
                                    //Uit
                                    System.out.println("off");
                                    controller.getSysteem().getSorteerRobot().setOn(Boolean.FALSE);
                                    controller.setStatusRobot1();
                                }
                            }
                            if(type.equals("statusRobot2")){
                                System.out.println("statusRobot2");
                                String status = (String) jsonObj.get("status");
                                int statusInt = Integer.parseInt(status);
                                if (statusInt == 1){
                                    controller.statusRobot2.setFill(Color.GREEN);
                                    controller.getSysteem().getSamenstelRobot().setOn(true);
                                }else {
                                    controller.statusRobot2.setFill(Color.RED);
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
