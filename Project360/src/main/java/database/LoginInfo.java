package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author olipo
 */
public class LoginInfo {

    public String createInfo() {
        String info = "CREATE TABLE IF NOT EXISTS LOGIN_INFOS "
                + "(infoID INTEGER not NULL AUTO_INCREMENT , "
                + "userID INTEGER not NULL, "
                //+ "employeeID INTEGER, "
                //+ "patientID INTEGER, "
                + " role VARCHAR(255) not NULL, "
                + " username VARCHAR(255) not NULL, "
                + " password VARCHAR(255) not NULL,"
                + " UNIQUE (username), "
                //+ " FOREIGN KEY ( docID ) REFERENCES DOCTORS(docID), "
                 //+ " FOREIGN KEY ( nurseID ) REFERENCES NURSES(nurseID), "
                //+ " FOREIGN KEY ( employeeID ) REFERENCES EMPLOYEES(employeeID), "
                + " PRIMARY KEY (infoID));";

        return info;
    }

    public String get_role(String user, String pass) throws ClassNotFoundException, SQLException {
        //String id = "SELECT role FROM LOGIN_INFOS WHERE username=\"kate\" AND password=\"kate1234\"";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String info = "SELECT role FROM LOGIN_INFOS WHERE username=? AND password=?";
        PreparedStatement pstmt = con.prepareStatement(info);
        String r = null;
        // ResultSet rs=null;
        try {

            //pstmt.setInt(1,id );
            pstmt.setString(1, user);
            pstmt.setString(2, pass);
            // pstmt.setString(4, pass);
            //pstmt.executeUpdate();

            ResultSet rs = pstmt.executeQuery();
            if (rs == null) {
                return null;
            }
            while (rs.next()) {
                r = rs.getString("role");
            }
            // System.out.println(r);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(LoginInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public int insertLoginInfo(int userid, String role, String user, String pass) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String info = "INSERT IGNORE INTO LOGIN_INFOS VALUES (default,?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(info);
        int w = -1;
        try {

            //pstmt.setInt(1, infoid);
            pstmt.setInt(1, userid);
            //pstmt.setInt(3, employeeid);
            //pstmt.setInt(4, patientid);
            pstmt.setString(2, role);
            pstmt.setString(3, user);
            pstmt.setString(4, pass);
            w = pstmt.executeUpdate();

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(LoginInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return w;
    }

    public void get_Info() throws ClassNotFoundException, SQLException {
        //String id = "SELECT role FROM LOGIN_INFOS WHERE username=\"kate\" AND password=\"kate1234\"";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String info = "SELECT * FROM LOGIN_INFOS";
        PreparedStatement pstmt = con.prepareStatement(info);
        int id = 0;
        String role = null;
        String name = null;
        String pass = null;

        // ResultSet rs=null;
        try {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                id = rs.getInt("ID");
                role = rs.getString("role");
                name = rs.getString("username");
                pass = rs.getString("password");
                System.out.println(id + " " + role + " " + name + " " + pass);
            }
            // System.out.println(r);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Doctors.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteLoginInfo(String username) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String delete = new String(
                "DELETE FROM LOGIN_INFOS"
                + " WHERE username= ?");
        //String doc = "INSERT IGNORE INTO DOCTORS VALUES (?,?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(delete);
        try {
            pstmt.setString(1, username);

            pstmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(LoginInfo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int get_id(String user, String pass) throws ClassNotFoundException, SQLException {
        //String id = "SELECT role FROM LOGIN_INFOS WHERE username=\"kate\" AND password=\"kate1234\"";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String info = "SELECT userid FROM LOGIN_INFOS WHERE username=? AND password=?";
        PreparedStatement pstmt = con.prepareStatement(info);
        int r = -1;
        // ResultSet rs=null;
        try {

            //pstmt.setInt(1,id );
            pstmt.setString(1, user);
            pstmt.setString(2, pass);
            // pstmt.setString(4, pass);
            //pstmt.executeUpdate();
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                r = rs.getInt("userid");
            }
            // System.out.println(r);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(LoginInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    /* PreparedStatement insertSpecial(PreparedStatement pstmt, int id, String role, String username, String password) {
        try {
            pstmt.setInt(1, id);
            pstmt.setString(2, role);
            pstmt.setString(3, username);
            pstmt.setString(4, password);

        } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pstmt;
    }*/
}
