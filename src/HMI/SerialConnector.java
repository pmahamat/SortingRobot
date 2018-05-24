package HMI;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SerialConnector {

    //Defining vars
    String test = "";
    String Stringaf = "";
    private static SerialPort[] serialPorts = SerialPort.getCommPorts();
    public SerialPort arduino;
    boolean done = false;
    MainController controller;

    SerialConnector(int port, MainController controller) {

        //Try catch for when arduino is not connected
        try {
            //Setting up serial connection
            this.controller = controller;
            arduino = serialPorts[port - 1];

            arduino.openPort();
            arduino.setBaudRate(9600);

            arduino.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 100, 0);

            //Adding serial listener to do things when it receives a package
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

                            if(type.equals("huidig_aantal")) {
                                System.out.println(json);
                                controller.totaal1.setText(jsonObj.get("bak1").toString());
                                controller.totaal2.setText(jsonObj.get("bak2").toString());
                                controller.totaal3.setText(jsonObj.get("bak3").toString());
                                controller.totaal4.setText(jsonObj.get("bak4").toString());
                                controller.totaal5.setText(jsonObj.get("bak5").toString());
                            }

                            if(type.equals("robot1")){
                                //Counter
                                Long counter = (Long) jsonObj.get("counter");
                                System.out.println(counter);
                                controller.setScannedObjectsCounter(counter);

                                //kleur
                                String kleur = (String) jsonObj.get("kleur");
                                switch (kleur) {
                                    case "rood":
                                        controller.setLastScannedColor(Color.RED);
                                        break;
                                    case "groen":
                                        controller.setLastScannedColor(Color.GREEN);
                                        break;
                                    case "blauw":
                                        controller.setLastScannedColor(Color.BLUE);
                                        break;
                                    case "paars":
                                        controller.setLastScannedColor(Color.PURPLE);
                                        break;
                                    case "oranje":
                                        controller.setLastScannedColor(Color.ORANGE);
                                        break;
                                    case "geel":
                                        controller.setLastScannedColor(Color.YELLOW);
                                        break;
                                }

                                //Arm
                                Long bakje = (Long) jsonObj.get("bakje");
                                switch (bakje.intValue()) {
                                    case 1:
                                        controller.setTextStatusBakje1("*");
                                        break;
                                    case 2:
                                        controller.setTextStatusBakje2("*");
                                        break;
                                    case 3:
                                        controller.setTextStatusBakje3("*");
                                        break;
                                    case 4:
                                        controller.setTextStatusBakje4("*");
                                        break;
                                    case 5:
                                        controller.setTextStatusBakje5("*");
                                        break;
                                }
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
                            } else if (type.equals("Robot2")) {
                                String statusbak1 = (String) jsonObj.get("statusbak1");
                                String statusbak2 = (String) jsonObj.get("statusbak2");
                                String statusbak3 = (String) jsonObj.get("statusbak3");
                                String statusbak4 = (String) jsonObj.get("statusbak4");
                                String statusbatch = (String) jsonObj.get("statusbatch");
                                Platform.runLater(() -> {
                                    controller.statusRobot2Bakje1.setText(statusbak1);
                                    controller.statusRobot2Bakje2.setText(statusbak2);
                                    controller.statusRobot2Bakje3.setText(statusbak3);
                                    controller.statusRobot2Bakje4.setText(statusbak4);
                                    controller.statusRobot2Batch.setText(statusbatch);
                                });

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


    //Class for writing strings to the serial device
    public void SendMessage(String s) {
        try {
            byte[] buffer = s.getBytes();
            arduino.writeBytes(buffer, buffer.length);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
