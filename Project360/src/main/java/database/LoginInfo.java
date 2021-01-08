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
public class LoginInfo {

    public String createInfo() {
        String info = "CREATE TABLE IF NOT EXISTS LOGIN_INFOS "
                + "(ID INTEGER not NULL, "
                + " role VARCHAR(255) not NULL, "
                + " username VARCHAR(255) not NULL, "
                + " password VARCHAR(255) not NULL,"
                + " UNIQUE (username),"
                + " PRIMARY KEY ( ID ));";

        return info;
    }

    public String get_role(String user, String pass) throws ClassNotFoundException, SQLException {
        //String id = "SELECT role FROM LOGIN_INFOS WHERE username=\"kate\" AND password=\"kate1234\"";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String info = "SELECT role FROM LOGIN_INFOS WHERE username=? AND password=?";
        PreparedStatement pstmt = con.prepareStatement(info);
        String r = null;
        // ResultSet rs=null;
        try {

            //pstmt.setInt(1,id );
            pstmt.setString(1, user);
            pstmt.setString(2, pass);
            // pstmt.setString(4, pass);
            //pstmt.executeUpdate();

            ResultSet rs = pstmt.executeQuery();
            if (rs == null) {
                return null;
            }
            while (rs.next()) {
                r = rs.getString("role");
            }
            // System.out.println(r);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(LoginInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public int insertLoginInfo(int id, String role, String user, String pass) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String info = "INSERT IGNORE INTO LOGIN_INFOS VALUES (?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(info);
        int w = -1;
        try {

            pstmt.setInt(1, id);
            pstmt.setString(2, role);
            pstmt.setString(3, user);
            pstmt.setString(4, pass);
            w = pstmt.executeUpdate();

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(LoginInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return w;
    }

    public int get_id(String user, String pass) throws ClassNotFoundException, SQLException {
        //String id = "SELECT role FROM LOGIN_INFOS WHERE username=\"kate\" AND password=\"kate1234\"";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String info = "SELECT id FROM LOGIN_INFOS WHERE username=? AND password=?";
        PreparedStatement pstmt = con.prepareStatement(info);
        int r = -1;
        // ResultSet rs=null;
        try {

            //pstmt.setInt(1,id );
            pstmt.setString(1, user);
            pstmt.setString(2, pass);
            // pstmt.setString(4, pass);
            //pstmt.executeUpdate();
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                r = rs.getInt("id");
            }
            // System.out.println(r);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(LoginInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    /* PreparedStatement insertSpecial(PreparedStatement pstmt, int id, String role, String username, String password) {
        try {
            pstmt.setInt(1, id);
            pstmt.setString(2, role);
            pstmt.setString(3, username);
            pstmt.setString(4, password);

        } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pstmt;
    }*/
}
