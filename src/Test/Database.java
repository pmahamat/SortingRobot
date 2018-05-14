package Test;

import java.sql.*;

public class Database {

    private PreparedStatement update = null;
    private PreparedStatement delete = null;
    private PreparedStatement insert = null;

    public Database() {

    }

    public void update(String table,String column1,String column2,String index1,String index2 ){
        try (
                // Step 1: Allocate a database 'Connection' object
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://den1.mysql2.gear.host:3306/kbs?useSSL=false", "kbs", "Zn7OG-6fJ!4M");
                // MySQL: "jdbc:mysql://hostname:port/databaseName", "username", "password"
        ) {
            String updateString = "update "+ table + " set " + column1 + " = ? where "+ column2 + " = ?";
            conn.setAutoCommit(false);
            update = conn.prepareStatement(updateString);
            update.setString(1, index1);
            update.setString(2, index2);
            update.executeUpdate();
            conn.commit();
            update.close();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void update(){
        this.update("component","Naam","naam","test", "test2");
    }

    public void delete(String table,String column1,String index1){
        try (
                // Step 1: Allocate a database 'Connection' object
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://den1.mysql2.gear.host:3306/kbs?useSSL=false", "kbs", "Zn7OG-6fJ!4M");
                // MySQL: "jdbc:mysql://hostname:port/databaseName", "username", "password"
        ) {
            String deleteString = "delete from " + table + " where " + column1 + " = ? " ;
            conn.setAutoCommit(false);
            delete = conn.prepareStatement(deleteString);
            delete.setString(1, index1);
            delete.executeUpdate();
            conn.commit();
            delete.close();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void insertComponent(String index1){
        try (
                // Step 1: Allocate a database 'Connection' object
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://den1.mysql2.gear.host:3306/kbs?useSSL=false", "kbs", "Zn7OG-6fJ!4M");
                // MySQL: "jdbc:mysql://hostname:port/databaseName", "username", "password"
        ) {
            String insertString = "insert into component(Naam) values (?)" ;
            conn.setAutoCommit(false);
            insert = conn.prepareStatement(insertString);
            insert.setString(1, index1);
            insert.executeUpdate();
            conn.commit();
            insert.close();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void insertLog(String bericht, int componentID){
        try (
                // Step 1: Allocate a database 'Connection' object
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://den1.mysql2.gear.host:3306/kbs?useSSL=false", "kbs", "Zn7OG-6fJ!4M");
                // MySQL: "jdbc:mysql://hostname:port/databaseName", "username", "password"
        ) {
            String insertString = "insert into log(Bericht,ComponentID) values (?,?)" ;
            conn.setAutoCommit(false);
            insert = conn.prepareStatement(insertString);
            insert.setString(1, bericht);
            insert.setInt(2,componentID);
            insert.executeUpdate();
            conn.commit();
            insert.close();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void insertRobot(int Bak1, int Bak2, int Bak3, int Bak4){
        try (
                // Step 1: Allocate a database 'Connection' object
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://den1.mysql2.gear.host:3306/kbs?useSSL=false", "kbs", "Zn7OG-6fJ!4M");
                // MySQL: "jdbc:mysql://hostname:port/databaseName", "username", "password"
        ) {
            int logID = 0;
            Statement stmt = (Statement) conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select MAX(LogID) AS LogID from log");
            if(rs.next()){
                logID = rs.getInt("LogID");
            }
            logID++;
            insertLog("Log robot is aangemaakt ",1);
            String insertString = "insert into robot1log(bak1,bak2,bak3,bak4,LogID) values (?,?,?,?,"+ logID +")" ;
            conn.setAutoCommit(false);
            insert = conn.prepareStatement(insertString);
            insert.setInt(1,Bak1);
            insert.setInt(2,Bak2);
            insert.setInt(3,Bak3);
            insert.setInt(4,Bak4);
            insert.executeUpdate();
            conn.commit();
            insert.close();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void insertSamenstelling(String naam, int Bak1, int Bak2, int Bak3, int Bak4){
        try (
                // Step 1: Allocate a database 'Connection' object
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://den1.mysql2.gear.host:3306/kbs?useSSL=false", "kbs", "Zn7OG-6fJ!4M");
                // MySQL: "jdbc:mysql://hostname:port/databaseName", "username", "password"
        ) {
            int logID = 0;
            Statement stmt = (Statement) conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select MAX(LogID) AS LogID from log");
            if(rs.next()){
                logID = rs.getInt("LogID");
            }
            logID++;
            insertLog("samenstelling " + naam + " is aangemaakt ",1);
            String insertString = "insert into samenstelling(naam,bak1,bak2,bak3,bak4,LogID) values (?,?,?,?,?,"+ logID + ")" ;
            conn.setAutoCommit(false);
            insert = conn.prepareStatement(insertString);
            insert.setString(1,naam);
            insert.setInt(2,Bak1);
            insert.setInt(3,Bak2);
            insert.setInt(4,Bak3);
            insert.setInt(5,Bak4);
            insert.executeUpdate();
            conn.commit();
            insert.close();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
}