package Test;

import java.sql.*;
import java.util.ArrayList;

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
    public ArrayList<Integer> SelectSamenstelling(String naam){
        try (
                // Step 1: Allocate a database 'Connection' object
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://den1.mysql2.gear.host:3306/kbs?useSSL=false", "kbs", "Zn7OG-6fJ!4M");
                // MySQL: "jdbc:mysql://hostname:port/databaseName", "username", "password"
        ) {
            ArrayList<Integer> waardeBakken = new ArrayList<>();
            Statement stmt = (Statement) conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from samenstelling where naam = '" + naam +"'");
            while (rs.next()) {
                int bak1 = rs.getInt("Bak1");
                int bak2 = rs.getInt("Bak2");
                int bak3 = rs.getInt("Bak3");
                int bak4 = rs.getInt("Bak4");
                waardeBakken.add(bak1);
                waardeBakken.add(bak2);
                waardeBakken.add(bak3);
                waardeBakken.add(bak4);
                return waardeBakken;
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public ArrayList<String> SelectNaamSamenstelling(){
        try (
                // Step 1: Allocate a database 'Connection' object
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://den1.mysql2.gear.host:3306/kbs?useSSL=false", "kbs", "Zn7OG-6fJ!4M");
                // MySQL: "jdbc:mysql://hostname:port/databaseName", "username", "password"
        ) {
            ArrayList<String> namen = new ArrayList<>();
            Statement stmt = (Statement) conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select naam from samenstelling");
            while (rs.next()) {
                String naam = rs.getString("naam");
                namen.add(naam);
            }
            return namen;
        } catch(SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public static String selectLog() {
        try (
                // Step 1: Allocate a database 'Connection' object
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://den1.mysql2.gear.host:3306/kbs?useSSL=false", "kbs", "Zn7OG-6fJ!4M");
                // MySQL: "jdbc:mysql://hostname:port/databaseName", "username", "password"
        ) {
            String result = "";
            int logID = 0;
            Statement stmt = (Statement) conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select Bericht, Tijd, Naam from log l JOIN component c ON l.ComponentID = c.ComponentID");
            while (rs.next()) {
                String naam = rs.getString("naam");
                String bericht = rs.getString("Bericht");
                Timestamp tijd = rs.getTimestamp("tijd");

//                System.out.format("%s, %s, %s\n", naam, bericht, tijd);
                result += tijd.toString() + " \t " +  naam + " " + bericht + "\n";

            }
            return result;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}