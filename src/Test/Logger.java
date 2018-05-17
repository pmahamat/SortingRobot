package Test;

public class Logger {
    private Database database = new Database();

    public void LogSamenstelling(int bak1, int bak2, int bak3, int bak4,String naam){
        database.insertSamenstelling(naam,bak1,bak2,bak3,bak4);
    }


    public void LogRobot(int bak1, int bak2, int bak3, int bak4){
        database.insertRobot(bak1,bak2,bak3,bak4);
    }

    public void Log(String bericht,int componentID){
        database.insertLog(bericht,componentID);
    }
}
