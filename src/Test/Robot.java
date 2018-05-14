package Test;

public class Robot {
    private String naam;
    private Boolean isOn = false;

    public Robot(String naam){
        this.naam = naam;
    }

    public void switchPower(){
        isOn = !isOn;
    }

    public void turnOff(){
        isOn = false;
    }

    public Boolean getOn() {
        return isOn;
    }

    public String getNaam() {
        return naam;
    }
}
