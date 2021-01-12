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
public class PatientsInShift {

    String createPatientsInShift() {
        String sql = "CREATE TABLE IF NOT EXISTS PATIENTS_IN_SHIFT "
                + "(patID INTEGER not NULL, "
                + " shiftID INTEGER not NULL, "
                + " FOREIGN KEY(shiftID) REFERENCES SHIFTS(shiftID), "
                + " FOREIGN KEY(patID) REFERENCES PATIENTS(patientID));";
        return sql;
    }

    public void insertPatientInShift(int pid, int sid) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String patInShift = "INSERT IGNORE INTO PATIENTS_IN_SHIFT VALUES (?,?)";
        PreparedStatement pstmt = con.prepareStatement(patInShift);
        try {

            pstmt.setInt(1, pid);
            pstmt.setInt(2, sid);
            pstmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(PatientsInShift.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String get_PatientsInShift() throws ClassNotFoundException, SQLException {
        //String id = "SELECT role FROM LOGIN_INFOS WHERE username=\"kate\" AND password=\"kate1234\"";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String patient = "SELECT PS.patID,P.firstname,P.lastname,PS.shiftID FROM PATIENTS P,PATIENTS_IN_SHIFT PS,SHIFTS S "
                + "WHERE P.patientID=PS.patID AND S.date=?;";
        PreparedStatement pstmt = con.prepareStatement(patient);
        int pid = 0;
        int sid = 0;

        String first = null;
        String last = null;
        String patients = null;
        String allPatients = null;
        // ResultSet rs=null;
        try {
pstmt.setString(1, String.valueOf(java.time.LocalDate.now()));
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                pid = rs.getInt("patID");
                sid = rs.getInt("shiftID");
                first = rs.getString("firstname");
                last = rs.getString("lastname");
                patients = (String.valueOf(pid) + " " + first + " " + last + " " + String.valueOf(sid) + ",");
                if (allPatients == null) {
                    allPatients = patients;
                } else {
                    allPatients = allPatients + patients;
                }
                //phone = rs.getString("phone");
                //System.out.println(id + " " + symp);
            }
            // System.out.println(r);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(PatientsInShift.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allPatients;
    }
}
