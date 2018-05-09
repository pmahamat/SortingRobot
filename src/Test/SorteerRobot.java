package Test;

import java.awt.*;

public class SorteerRobot extends Robot {

    private int standArm;
    private static Color kleur1 = Color.blue;
    private static Color kleur2 = Color.blue;
    private static Color kleur3 = Color.blue;
    private static Color kleur4 = Color.blue;
    private static Color lastScannedColor;
    private static int objectCounter;

    public SorteerRobot(String naam){
        super(naam);
    }

    @Override
    public void turnOn() {

    }
}
