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

    public Boolean getOn() {
        return isOn;
    }

    public String getNaam()

    public void setOn(Boolean on) {
        isOn = on;
    }
}
