package Test;

import java.awt.*;

public class SorteerRobot extends Robot {

    private int standArm;
    private Color kleur1 = Color.blue;
    private Color kleur2 = Color.blue;
    private Color kleur3 = Color.blue;
    private Color kleur4 = Color.blue;
    private Color lastScannedColor;
    private int objectCounter;

    public SorteerRobot(String naam){
        super(naam);
    }

}
