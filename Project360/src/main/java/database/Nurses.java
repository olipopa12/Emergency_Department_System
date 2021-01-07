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
public class Nurses {

    String createNurse() {
        String nurse = "CREATE TABLE IF NOT EXISTS NURSES "
                + "(nurseID INTEGER not NULL, "
                + " firstname VARCHAR(255), "
                + " lastname VARCHAR(255), "
                + " phone VARCHAR(255) , "
                + " PRIMARY KEY ( nurseID ));";
        return nurse;
    }

    void insertNurse(int id, String firstname, String lastname, String phone) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String nurse = "INSERT IGNORE INTO NURSES VALUES (?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(nurse);
        try {

            pstmt.setInt(1, id);
            pstmt.setString(2, firstname);
            pstmt.setString(3, lastname);
            pstmt.setString(4, phone);
            pstmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Nurses.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String get_firstname(int id) throws ClassNotFoundException, SQLException {
        //String id = "SELECT role FROM LOGIN_INFOS WHERE username=\"kate\" AND password=\"kate1234\"";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String firstname = "SELECT firstname FROM NURSES WHERE nurseID=?";
        PreparedStatement pstmt = con.prepareStatement(firstname);
        String r = null;
        // ResultSet rs=null;
        try {

            pstmt.setInt(1, id);
            // pstmt.setString(1, name);
            // pstmt.setString(4, pass);
            //pstmt.executeUpdate();
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                r = rs.getString("firstname");
            }
            // System.out.println(r);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Nurses.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public String get_lastname(int id) throws ClassNotFoundException, SQLException {
        //String id = "SELECT role FROM LOGIN_INFOS WHERE username=\"kate\" AND password=\"kate1234\"";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String lastname = "SELECT lastname FROM NURSES WHERE nurseID=?";
        PreparedStatement pstmt = con.prepareStatement(lastname);
        String r = null;
        // ResultSet rs=null;
        try {

            pstmt.setInt(1, id);
            // pstmt.setString(1, name);
            // pstmt.setString(4, pass);
            //pstmt.executeUpdate();
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                r = rs.getString("firstname");
            }
            // System.out.println(r);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Nurses.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public String get_telephone(int id) throws ClassNotFoundException, SQLException {
        //String id = "SELECT role FROM LOGIN_INFOS WHERE username=\"kate\" AND password=\"kate1234\"";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String telephone = "SELECT phone FROM NURSES WHERE nurseID=?";
        PreparedStatement pstmt = con.prepareStatement(telephone);
        String r = null;
        // ResultSet rs=null;
        try {

            pstmt.setInt(1, id);
            // pstmt.setString(1, name);
            // pstmt.setString(4, pass);
            //pstmt.executeUpdate();
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                r = rs.getString("phone");
            }
            // System.out.println(r);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Nurses.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
}
