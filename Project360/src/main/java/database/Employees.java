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
public class Employees {

    String createEmployee() {
        String employee = "CREATE TABLE IF NOT EXISTS EMPLOYEES "
                + "(employeeID INTEGER not NULL, "
                + " name VARCHAR(255), "
                + " phone VARCHAR(255), "
                + " PRIMARY KEY ( employeeID ));";
        return employee;
    }

  
    void insertEmployee(int id, String name, String phone) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String empl = "INSERT IGNORE INTO EMPLOYEES VALUES (?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(empl);
        try {

            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, phone);
            pstmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Employees.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String get_name(int id) throws ClassNotFoundException, SQLException {
        //String id = "SELECT role FROM LOGIN_INFOS WHERE username=\"kate\" AND password=\"kate1234\"";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String name = "SELECT name FROM EMPLOYEES WHERE employeeID=?";
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
            Logger.getLogger(Employees.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public String get_telephone(int id) throws ClassNotFoundException, SQLException {
        //String id = "SELECT role FROM LOGIN_INFOS WHERE username=\"kate\" AND password=\"kate1234\"";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String telephone = "SELECT phone FROM EMPLOYEES WHERE employeeID=?";
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
            Logger.getLogger(Employees.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
}
