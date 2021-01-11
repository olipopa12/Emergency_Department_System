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
public class Symptoms {

    String createSymptom() {
        String symptom = "CREATE TABLE IF NOT EXISTS SYMPTOMS "
                + "(visitID INTEGER not NULL, "
                + " symptom VARCHAR(255), "
                + " FOREIGN KEY ( visitID ) REFERENCES VISITS(visitID));";
        return symptom;
    }

    public void insertSymptom(int id, String sym) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String symptom = "INSERT IGNORE INTO SYMPTOMS VALUES (?,?)";
        PreparedStatement pstmt = con.prepareStatement(symptom);
        try {

            pstmt.setInt(1, id);
            pstmt.setString(2, sym);
            pstmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Symptoms.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     public void get_Symptoms() throws ClassNotFoundException, SQLException {
        //String id = "SELECT role FROM LOGIN_INFOS WHERE username=\"kate\" AND password=\"kate1234\"";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String symptom = "SELECT * FROM SYMPTOMS";
        PreparedStatement pstmt = con.prepareStatement(symptom);
        int id = 0;
        String symp = null;
        //String last = null;
        //String phone = null;

        // ResultSet rs=null;
        try {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                id = rs.getInt("visitID");
                symp = rs.getString("symptom");
                //last = rs.getString("lastname");
                //phone = rs.getString("phone");
                System.out.println(id + " " + symp);
            }
            // System.out.println(r);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Symptoms.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
