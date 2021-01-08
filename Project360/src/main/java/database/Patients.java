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
public class Patients {

    public String createPatient() {
        String patient = "CREATE TABLE IF NOT EXISTS PATIENTS "
                + "(patientID INTEGER not NULL, "
                + " AMKA VARCHAR(255) not NULL, "
                + " firstname VARCHAR(255), "
                + " lastname VARCHAR(255), "
                + " insurance VARCHAR(255), "
                + " road VARCHAR(255), "
                + " number INTEGER, "
                + " tk INTEGER, "
                + " phone VARCHAR(255), "
                + " UNIQUE (phone),"
                + " UNIQUE (amka),"
                + " PRIMARY KEY ( patientID ));";
        return patient;
    }

    public void updatePatient(int id, String amka, String fname, String lname, String ins, String road, int num, int TK, String phone) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String update = new String(
                "UPDATE PATIENTS"
                + " SET AMKA= ?,"
                + " firstname= ?,"
                + " lastname= ?,"
                + " insurance= ?,"
                + " road= ?,"
                + " number= ?,"
                + " TK= ?,"
                + " phone= ?"
                + " WHERE patientID= ?");
        //String doc = "INSERT IGNORE INTO DOCTORS VALUES (?,?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(update);
        try {
            pstmt.setString(1, amka);
            pstmt.setString(2, fname);
            pstmt.setString(3, lname);
            pstmt.setString(4, ins);
            pstmt.setString(5, road);
            pstmt.setInt(6, num);
            pstmt.setInt(7, TK);
            pstmt.setString(8, phone);
            pstmt.setInt(9, id);
            pstmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Patients.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void insertPatient(int id, String amka, String fname, String lname, String ins, String road, int num, int TK, String phone) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String patient = "INSERT IGNORE INTO PATIENTS VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(patient);
        try {

            pstmt.setInt(1, id);
            pstmt.setString(2, amka);
            pstmt.setString(3, fname);
            pstmt.setString(4, lname);
            pstmt.setString(5, ins);
            pstmt.setString(6, road);
            pstmt.setInt(7, num);
            pstmt.setInt(8, TK);
            pstmt.setString(9, phone);
            pstmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Patients.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String get_firstname(int id) throws ClassNotFoundException, SQLException {
        //String id = "SELECT role FROM LOGIN_INFOS WHERE username=\"kate\" AND password=\"kate1234\"";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String name = "SELECT firstname FROM PATIENTS WHERE patientID=?";
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
                r = rs.getString("firstname");
            }
            // System.out.println(r);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Patients.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public String get_lastname(int id) throws ClassNotFoundException, SQLException {
        //String id = "SELECT role FROM LOGIN_INFOS WHERE username=\"kate\" AND password=\"kate1234\"";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String name = "SELECT lastname FROM PATIENTS WHERE patientID=?";
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
                r = rs.getString("lastname");
            }
            // System.out.println(r);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Patients.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public String get_telephone(int id) throws ClassNotFoundException, SQLException {
        //String id = "SELECT role FROM LOGIN_INFOS WHERE username=\"kate\" AND password=\"kate1234\"";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String telephone = "SELECT phone FROM PATIENTS WHERE patientID=?";
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
            Logger.getLogger(Patients.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public String get_amka(int id) throws ClassNotFoundException, SQLException {
        //String id = "SELECT role FROM LOGIN_INFOS WHERE username=\"kate\" AND password=\"kate1234\"";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String amka = "SELECT AMKA FROM PATIENTS WHERE patientID=?";
        PreparedStatement pstmt = con.prepareStatement(amka);
        String r = null;
        // ResultSet rs=null;
        try {

            pstmt.setInt(1, id);
            // pstmt.setString(1, name);
            // pstmt.setString(4, pass);
            //pstmt.executeUpdate();
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                r = rs.getString("AMKA");
            }
            // System.out.println(r);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Patients.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public String get_road(int id) throws ClassNotFoundException, SQLException {
        //String id = "SELECT role FROM LOGIN_INFOS WHERE username=\"kate\" AND password=\"kate1234\"";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String road = "SELECT road FROM PATIENTS WHERE patientID=?";
        PreparedStatement pstmt = con.prepareStatement(road);
        String r = null;
        // ResultSet rs=null;
        try {

            pstmt.setInt(1, id);
            // pstmt.setString(1, name);
            // pstmt.setString(4, pass);
            //pstmt.executeUpdate();
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                r = rs.getString("road");
            }
            // System.out.println(r);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Patients.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public int get_tk(int id) throws ClassNotFoundException, SQLException {
        //String id = "SELECT role FROM LOGIN_INFOS WHERE username=\"kate\" AND password=\"kate1234\"";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String tk = "SELECT tk FROM PATIENTS WHERE patientID=?";
        PreparedStatement pstmt = con.prepareStatement(tk);
        int r = -1;
        // ResultSet rs=null;
        try {

            pstmt.setInt(1, id);
            // pstmt.setString(1, name);
            // pstmt.setString(4, pass);
            //pstmt.executeUpdate();
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                r = rs.getInt("tk");
            }
            // System.out.println(r);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Patients.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public int get_id(String first, String last, String telephone) throws ClassNotFoundException, SQLException {
        //String id = "SELECT role FROM LOGIN_INFOS WHERE username=\"kate\" AND password=\"kate1234\"";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String id_ = "SELECT patientID FROM PATIENTS WHERE firstname=? AND lastname=? AND phone=?";
        PreparedStatement pstmt = con.prepareStatement(id_);
        int r = -1;
        // ResultSet rs=null;
        try {

            pstmt.setString(1, first);
            pstmt.setString(2, last);
            pstmt.setString(3, telephone);
            // pstmt.setString(1, name);
            // pstmt.setString(4, pass);
            //pstmt.executeUpdate();
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                r = rs.getInt("patientID");
            }
            // System.out.println(r);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Patients.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public int get_number(int id) throws ClassNotFoundException, SQLException {
        //String id = "SELECT role FROM LOGIN_INFOS WHERE username=\"kate\" AND password=\"kate1234\"";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String number = "SELECT number FROM PATIENTS WHERE patientID=?";
        PreparedStatement pstmt = con.prepareStatement(number);
        int r = -1;
        // ResultSet rs=null;
        try {

            pstmt.setInt(1, id);
            // pstmt.setString(1, name);
            // pstmt.setString(4, pass);
            //pstmt.executeUpdate();
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                r = rs.getInt("number");
            }
            // System.out.println(r);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Patients.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public String get_insurance(int id) throws ClassNotFoundException, SQLException {
        //String id = "SELECT role FROM LOGIN_INFOS WHERE username=\"kate\" AND password=\"kate1234\"";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String insurance = "SELECT insurance FROM PATIENTS WHERE patientID=?";
        PreparedStatement pstmt = con.prepareStatement(insurance);
        String r = null;
        // ResultSet rs=null;
        try {

            pstmt.setInt(1, id);
            // pstmt.setString(1, name);
            // pstmt.setString(4, pass);
            //pstmt.executeUpdate();
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                r = rs.getString("insurance");
            }
            // System.out.println(r);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Patients.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
}
