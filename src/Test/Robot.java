package Test;

public class Robot {
    private String naam;
    private Boolean isOn = false;

    public Robot(String naam){

    }

    public void turnOn(){
        isOn = true;
    }

    public void turnOff(){
        isOn = false;
    }
}
