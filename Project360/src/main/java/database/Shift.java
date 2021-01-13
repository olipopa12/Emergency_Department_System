/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author olipo
 */
public class Shift {
     String createShift() {
        String shift = "CREATE TABLE IF NOT EXISTS SHIFTS "
                + "(shiftID INTEGER not NULL AUTO_INCREMENT, "
                + " date VARCHAR(255), "
                
               + " UNIQUE(date), "
                + " PRIMARY KEY ( shiftID ));";
        return shift;
    }
     public void insertShift() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String shift = "INSERT IGNORE INTO SHIFTS VALUES (default,?)";
        PreparedStatement pstmt = con.prepareStatement(shift);
        try {

           // pstmt.setInt(1, id);
            pstmt.setString(1, String.valueOf(java.time.LocalDate.now()));
            pstmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Shift.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     
     public int get_id(String date) throws ClassNotFoundException, SQLException {
        //String id = "SELECT role FROM LOGIN_INFOS WHERE username=\"kate\" AND password=\"kate1234\"";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String id_ = "SELECT shiftID FROM SHIFTS WHERE date=?";
        PreparedStatement pstmt = con.prepareStatement(id_);
        int r = -1;
        // ResultSet rs=null;
        try {

            pstmt.setString(1, date);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                r = rs.getInt("shiftID");
            }
            // System.out.println(r);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Doctors.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
 public void insertShift(String date) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String shift = "INSERT IGNORE INTO SHIFTS VALUES (default,?)";
        PreparedStatement pstmt = con.prepareStatement(shift);
        try {

           // pstmt.setInt(1, id);
            pstmt.setString(1, date);
            pstmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Shift.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
