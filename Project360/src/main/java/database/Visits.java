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
public class Visits {

    String createVisit() {
        String visit = "CREATE TABLE IF NOT EXISTS VISITS "
                + "(visitID INTEGER not NULL AUTO_INCREMENT, "
                + " patientID INTEGER not NULL, "
                + " date VARCHAR(255), "
                + " PRIMARY KEY ( visitID ), "
                + " FOREIGN KEY(patientID) REFERENCES PATIENTS(patientID));";
        return visit;
    }

    public void insertVisit( int pid, String date) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String visit = "INSERT IGNORE INTO VISITS VALUES (default,?,?)";
        PreparedStatement pstmt = con.prepareStatement(visit);
        try {

            //pstmt.setInt(1, id);
            pstmt.setInt(1, pid);
            pstmt.setString(2, date);
            pstmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Visits.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
