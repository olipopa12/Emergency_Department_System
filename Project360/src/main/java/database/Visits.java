package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
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

    public void insertVisit(int pid, String date) throws ClassNotFoundException, SQLException {
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

    public String get_Visits() throws ClassNotFoundException, SQLException {
        //String id = "SELECT role FROM LOGIN_INFOS WHERE username=\"kate\" AND password=\"kate1234\"";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String visits = "SELECT visitID,P.firstname,P.lastname FROM PATIENTS P,VISITS V WHERE "
                + "P.patientID=V.patientID AND V.date=?;";
        PreparedStatement pstmt = con.prepareStatement(visits);
        int id = 0;
        String first = null;
        String last = null;
        String allVisits = null;
        String visit = null;
        int records = 0;
        // ResultSet rs=null;
        try {
            pstmt.setString(1, String.valueOf(java.time.LocalDate.now()));
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                records++;
                id = rs.getInt("visitID");
                first = rs.getString("firstname");
                last = rs.getString("lastname");
                //  disease = rs.getString("disease");
                visit = (String.valueOf(id) + " " + first + " " + last + ",");
                // System.out.println(visit);
                if (allVisits == null) {
                    allVisits = visit;
                } else {
                    allVisits = allVisits + visit;
                }
            }
            // System.out.println(r);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Symptoms.class.getName()).log(Level.SEVERE, null, ex);
        }
        allVisits = allVisits + String.valueOf(records);
        return allVisits;
    }

    public String get_Visits(int month, int year) throws ClassNotFoundException, SQLException {
        //String id = "SELECT role FROM LOGIN_INFOS WHERE username=\"kate\" AND password=\"kate1234\"";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String visits = "SELECT V.date,P.firstname,P.lastname FROM PATIENTS P,VISITS V WHERE "
                + "P.patientID=V.patientID AND MONTH(V.date)=? AND YEAR(V.date)=?;";
        PreparedStatement pstmt = con.prepareStatement(visits);
        int i = 0;
        String date=null;
        String first = null;
        String last = null;
        String allVisits = null;
        String visit = null;
        int records = 0;

        try {
            pstmt.setInt(1, month);
            pstmt.setInt(2, year);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                records++;
                date = rs.getString("date");
                first = rs.getString("firstname");
                last = rs.getString("lastname");
                //  disease = rs.getString("disease");
                visit = (date + " " + first + " " + last + ",");
                // System.out.println(visit);
                if (allVisits == null) {
                    allVisits = visit;
                } else {
                    allVisits = allVisits + visit;
                }
                i++;
            }
            // System.out.println(r);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Symptoms.class.getName()).log(Level.SEVERE, null, ex);
        }
        //allVisits=allVisits+String.valueOf(records);
        return allVisits+i;
    }

}
