package Test;

import java.awt.*;

public class SorteerRobot extends Robot {

    private int standArm;
    private static Color kleur1 = Color.blue;
    private static Color kleur2 = Color.blue;
    private static Color kleur3 = Color.blue;
    private static Color kleur4 = Color.blue;
    private static Color lastScannedColor;

    public int getStandArm() {
        return standArm;
    }

    public static Color getKleur1() {
        return kleur1;
    }

    public static Color getKleur2() {
        return kleur2;
    }

    public static Color getKleur3() {
        return kleur3;
    }

    public static Color getKleur4() {
        return kleur4;
    }

    public static Color getLastScannedColor() {
        return lastScannedColor;
    }

    public static int getObjectCounter() {
        return objectCounter;
    }

    private static int objectCounter;

    public void setStandArm(int standArm) {
        this.standArm = standArm;
    }

    public static void setKleur2(Color kleur2) {
        SorteerRobot.kleur2 = kleur2;
    }

    public static void setKleur3(Color kleur3) {
        SorteerRobot.kleur3 = kleur3;
    }

    public static void setKleur4(Color kleur4) {
        SorteerRobot.kleur4 = kleur4;
    }

    public static void setLastScannedColor(Color lastScannedColor) {
        SorteerRobot.lastScannedColor = lastScannedColor;
    }

    public static void setObjectCounter(int objectCounter) {
        SorteerRobot.objectCounter = objectCounter;
    }

    public SorteerRobot(String naam){
        super(naam);
    }

    public static void setKleur1(Color kleur1) {
        SorteerRobot.kleur1 = kleur1;
    }
}
