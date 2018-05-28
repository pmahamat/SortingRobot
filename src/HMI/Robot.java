package HMI;

//Robot klasse
public class Robot {
    private String naam;
    private Boolean isOn = false;

    //Zet robot aan
    public void setOn(Boolean on) {
        isOn = on;
    }

    //Een naam geven aan de robot
    public Robot(String naam) {
        this.naam = naam;
    }

//    Zet robot aan of uit
    public void switchPower() {
        isOn = !isOn;
    }

    // kijk of robot aan of uit is
    public Boolean getOn() {
        return isOn;
    }

}
