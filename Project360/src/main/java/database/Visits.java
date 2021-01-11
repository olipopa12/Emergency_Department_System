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
    public int get_id(int pid, String date) throws ClassNotFoundException, SQLException {
        //String id = "SELECT role FROM LOGIN_INFOS WHERE username=\"kate\" AND password=\"kate1234\"";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String id_ = "SELECT visitID FROM VISITS WHERE patientID=? AND date=?";
        PreparedStatement pstmt = con.prepareStatement(id_);
        int r = -1;
        // ResultSet rs=null;
        try {

            pstmt.setInt(1, pid);
            pstmt.setString(2, date);
            //pstmt.setString(3, telephone);
            // pstmt.setString(1, name);
            // pstmt.setString(4, pass);
            //pstmt.executeUpdate();
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                r = rs.getInt("visitID");
            }
            // System.out.println(r);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Visits.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

}
