package HMI;

public class Robot {
    private String naam;
    private Boolean isOn = false;

    public void setOn(Boolean on) {
        isOn = on;
    }

    public Robot(String naam) {
        this.naam = naam;
    }

    public void switchPower() {
        isOn = !isOn;
    }

    public Boolean getOn() {
        return isOn;
    }

}
