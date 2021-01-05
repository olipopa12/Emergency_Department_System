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
public class Nurses {
    String createNurse() {
        String nurse = "CREATE TABLE IF NOT EXISTS NURSES "
                + "(nurseID INTEGER not NULL, "
                + " name VARCHAR(255), "
                + " phone VARCHAR(255) , "
                + " PRIMARY KEY ( nurseID ));";
        return nurse;
    }
     void insertNurse( int id, String name, String phone) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
            //stmt = con.createStatement();
            String nurse = "INSERT IGNORE INTO NURSES VALUES (?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(nurse);
        try {
            
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, phone);
            pstmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
