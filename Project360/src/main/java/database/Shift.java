/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
                + " PRIMARY KEY ( shiftID ));";
        return shift;
    }
     public void insertShift( String date) throws ClassNotFoundException, SQLException {
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
