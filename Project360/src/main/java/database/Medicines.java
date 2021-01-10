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
public class Medicines {

    String createMedicine() {
        String med = "CREATE TABLE IF NOT EXISTS MEDICINES "
                + "(medID INTEGER not NULL, "
                + "diseaseID INTEGER not NULL, "
                + " name VARCHAR(255), "
                + " kindof VARCHAR(255), "
                + " substance INTEGER, "
                + " PRIMARY KEY ( medID ), "
                + " FOREIGN KEY(diseaseID) REFERENCES DISEASES(disID)); ";
        return med;
    }

    void insertMedicine(int id, int disease, String name, String kindof, int substance) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String med = "INSERT IGNORE INTO MEDICINES VALUES (?,?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(med);
        try {

            pstmt.setInt(1, id);
            pstmt.setInt(2, disease);
            pstmt.setString(3, name);
            pstmt.setString(4, kindof);
            pstmt.setInt(5, substance);

            pstmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Medicines.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void get_Medicines() throws ClassNotFoundException, SQLException {
        //String id = "SELECT role FROM LOGIN_INFOS WHERE username=\"kate\" AND password=\"kate1234\"";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String med = "SELECT * FROM MEDICINES";
        PreparedStatement pstmt = con.prepareStatement(med);
        int id = 0;
        int did = 0;
        String name = null;
        String kind = null;
        int sub = 0;

        // ResultSet rs=null;
        try {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                id = rs.getInt("medID");
                did = rs.getInt("diseaseID");
                name = rs.getString("name");
                kind = rs.getString("kindof");
                sub = rs.getInt("substance");
                System.out.println(id + " " + did + " " + name + " " + kind + " " + sub);
            }
            // System.out.println(r);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Doctors.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
