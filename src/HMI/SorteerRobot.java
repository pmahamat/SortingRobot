package HMI;

import java.awt.*;


//Defining sorting robot by extending it from robot
public class SorteerRobot extends HMI.Robot {

    private int standArm;
    private static Color kleur1 = Color.blue;
    private static Color kleur2 = Color.blue;
    private static Color kleur3 = Color.blue;
    private static Color kleur4 = Color.blue;
    private int bakje1;
    private int bakje2;
    private int bakje3;
    private int bakje4;
    private int bakje5;
    private static Color lastScannedColor;

    public int getStandArm() {
        return standArm;
    }

    public int getBakje1() {
        return bakje1;
    }

    public void setBakje1() {
        this.bakje1++;
    }

    public int getBakje2() {
        return bakje2;
    }

    public void setBakje2() {
        this.bakje2++;
    }

    public int getBakje3() {
        return bakje3;
    }

    public void setBakje3() {
        this.bakje3++;
    }

    public int getBakje4() {
        return bakje4;
    }

    public void setBakje4() {
        this.bakje4++;
    }

    public int getBakje5() {
        return bakje5;
    }

    public void setBakje5() {
        this.bakje5++;
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
