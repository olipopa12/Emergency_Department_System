package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
public class Patients {
    String createPatient() {
        String patient = "CREATE TABLE IF NOT EXISTS PATIENTS "
                + "(patientID INTEGER not NULL, "
                + " AMKA VARCHAR(255) not NULL, "
                + " name VARCHAR(255), "
                + " insurance VARCHAR(255), "
                + " address VARCHAR(255), "
                + " phone VARCHAR(255), "
                + " PRIMARY KEY ( patientID ));";
        return patient;
    }
    void insertPatient( int id,String amka , String name,String ins,String address, String phone) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
            //stmt = con.createStatement();
            String patient = "INSERT IGNORE INTO PATIENTS VALUES (?,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(patient);
        try {
            
            pstmt.setInt(1, id);
            pstmt.setString(2, amka);
            pstmt.setString(3, name);
            pstmt.setString(4, ins);
            pstmt.setString(5, address);
            pstmt.setString(6, phone);
            pstmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
