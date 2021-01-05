package database;


import java.sql.PreparedStatement;
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

    String createInfo() {
        String info = "CREATE TABLE IF NOT EXISTS LOGIN_INFOS "
                + "(ID INTEGER not NULL, "
                + " role VARCHAR(255), "
                + " username VARCHAR(255) not NULL, "
                + " password VARCHAR(255) not NULL,"
                + " PRIMARY KEY ( ID ));";
        return info;
    }

    String check_username_password(String user) {
        String id = "SELECT password FROM LOGIN_INFOS where username=" + user;
        return id;
    }

    String insertLoginInfo() {
        String kapoios = "INSERT IGNORE INTO LOGIN_INFOS VALUES (?,?,?,?)";
        return kapoios;
    }

    PreparedStatement insertSpecial(PreparedStatement pstmt, int id, String role, String username, String password) {
        try {
            pstmt.setInt(1, id);
            pstmt.setString(2, role);
            pstmt.setString(3, username);
            pstmt.setString(4, password);

        } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pstmt;
    }
}
