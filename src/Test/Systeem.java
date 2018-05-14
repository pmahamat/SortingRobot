package Test;

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
