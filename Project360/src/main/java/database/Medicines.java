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
public class Medicines {

    String createMedicine() {
        String med = "CREATE TABLE IF NOT EXISTS MEDICINES "
                + "(medID INTEGER not NULL, "
                + " name VARCHAR(255), "
                + " kindof VARCHAR(255), "
                + " substance INTEGER, "
                + " PRIMARY KEY ( medID ));";
        return med;
    }
    void insertMedicine(int id, String name, String kindof, int substance) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String med = "INSERT IGNORE INTO MEDICINES VALUES (?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(med);
        try {

            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, kindof);
            pstmt.setInt(4, substance);
            pstmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Medicines.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
