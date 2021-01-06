package database;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author olipo
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Doctor {

    String createDoctor() {
        String doc = "CREATE TABLE IF NOT EXISTS DOCTORS "
                + "(docID INTEGER not NULL, "
                + " name VARCHAR(255), "
                + " specialty VARCHAR(255), "
                + " phone VARCHAR(255), "
                + " PRIMARY KEY ( docID ));";
        return doc;
    }

    /* String insertDoctor() {
        String doc = "INSERT IGNORE INTO DOCTORS VALUES (?,?,?,?)";
        return doc;
    }*/
    void insertDoctor(int id, String name, String specialty, String phone) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String doc = "INSERT IGNORE INTO DOCTORS VALUES (?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(doc);
        try {

            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, specialty);
            pstmt.setString(4, phone);
            pstmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String get_name(int id) throws ClassNotFoundException, SQLException {
        //String id = "SELECT role FROM LOGIN_INFOS WHERE username=\"kate\" AND password=\"kate1234\"";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String name = "SELECT name FROM DOCTORS WHERE docID=?";
        PreparedStatement pstmt = con.prepareStatement(name);
        String r = null;
        // ResultSet rs=null;
        try {

            pstmt.setInt(1, id);
            // pstmt.setString(1, name);
            // pstmt.setString(4, pass);
            //pstmt.executeUpdate();
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                r = rs.getString("name");
            }
            // System.out.println(r);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public String get_specialty(int id) throws ClassNotFoundException, SQLException {
        //String id = "SELECT role FROM LOGIN_INFOS WHERE username=\"kate\" AND password=\"kate1234\"";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String specialty = "SELECT specialty FROM DOCTORS WHERE docID=?";
        PreparedStatement pstmt = con.prepareStatement(specialty);
        String r = null;
        // ResultSet rs=null;
        try {

            pstmt.setInt(1, id);
            // pstmt.setString(1, name);
            // pstmt.setString(4, pass);
            //pstmt.executeUpdate();
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                r = rs.getString("specialty");
            }
            // System.out.println(r);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public String get_telephone(int id) throws ClassNotFoundException, SQLException {
        //String id = "SELECT role FROM LOGIN_INFOS WHERE username=\"kate\" AND password=\"kate1234\"";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String telephone = "SELECT phone FROM DOCTORS WHERE docID=?";
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
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
}
