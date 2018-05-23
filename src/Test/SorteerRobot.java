package Test;

import java.awt.*;


//Defining sorting robot by extending it from robot
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

    //Sets color for the first color
    public void setKleur1(javafx.scene.paint.Color kleur1) {
        javafx.scene.paint.Color fx = kleur1;
        java.awt.Color awtColor = new java.awt.Color((float) fx.getRed(),
                (float) fx.getGreen(),
                (float) fx.getBlue(),
                (float) fx.getOpacity());
        SorteerRobot.kleur1 = awtColor;
    }

    //Sets color for the second color
    public void setKleur2(javafx.scene.paint.Color kleur2) {
        javafx.scene.paint.Color fx = kleur2;
        java.awt.Color awtColor = new java.awt.Color((float) fx.getRed(),
                (float) fx.getGreen(),
                (float) fx.getBlue(),
                (float) fx.getOpacity());
        SorteerRobot.kleur2 = awtColor;
    }

    //Sets color for the third color
    public void setKleur3(javafx.scene.paint.Color kleur3) {
        javafx.scene.paint.Color fx = kleur3;
        java.awt.Color awtColor = new java.awt.Color((float) fx.getRed(),
                (float) fx.getGreen(),
                (float) fx.getBlue(),
                (float) fx.getOpacity());
        SorteerRobot.kleur3 = awtColor;
    }

    //Sets color for the fourth color
    public void setKleur4(javafx.scene.paint.Color kleur4) {
        javafx.scene.paint.Color fx = kleur4;
        java.awt.Color awtColor = new java.awt.Color((float) fx.getRed(),
                (float) fx.getGreen(),
                (float) fx.getBlue(),
                (float) fx.getOpacity());
        SorteerRobot.kleur4 = awtColor;
    }

    public static void setLastScannedColor(Color lastScannedColor) {
        SorteerRobot.lastScannedColor = lastScannedColor;
    }

    public static void setObjectCounter(int objectCounter) {
        SorteerRobot.objectCounter = objectCounter;
    }

    public SorteerRobot(String naam) {
        super(naam);
    }

    public static void setKleur1(Color kleur1) {
        SorteerRobot.kleur1 = kleur1;
    }
}
