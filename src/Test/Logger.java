package Test;

import java.awt.*;

public class Logger {
    Database Database = new Database();

    public void LogSamenstelling(int bak1, int bak2, int bak3, int bak4,String naam){
        Database.insertSamenstelling(naam,bak1,bak2,bak3,bak4);
    }


    public void LogRobot(int bak1, int bak2, int bak3, int bak4){
        Database.insertRobot(bak1,bak2,bak3,bak4);
    }

    public void Log(String bericht,int componentID){
        Database.insertLog(bericht,componentID);
    }
}
