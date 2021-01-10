package database;

import java.sql.Connection;
import java.sql.DriverManager;
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

 public class Disease {
 String createDisease() {
        String dis = "CREATE TABLE IF NOT EXISTS DISEASES "
                + "(disID INTEGER not NULL, "
                + " kind VARCHAR(255), "
                + " PRIMARY KEY ( disID ));";
                //+ " FOREIGN KEY(medID) REFERENCES MEDICINES(medID));";
        return dis;
    }
 void insertDisease(int id, String kind) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String dis = "INSERT IGNORE INTO DISEASES VALUES (?,?)";
        PreparedStatement pstmt = con.prepareStatement(dis);
        try {

            pstmt.setInt(1, id);
            pstmt.setString(2, kind);
            pstmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Disease.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}


