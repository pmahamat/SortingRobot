package Test;

//Class to combine multiple robots for easy access
public class Systeem {
    public SorteerRobot getSorteerRobot() {
        return sorteerRobot;
    }

    public SamenstelRobot getSamenstelRobot() {
        return samenstelRobot;
    }

    private SorteerRobot sorteerRobot;
    private SamenstelRobot samenstelRobot;

    public Systeem(SorteerRobot sorteerRobot, SamenstelRobot samenstelRobot){
        this.sorteerRobot = sorteerRobot;
        this.samenstelRobot = samenstelRobot;
    }
}
