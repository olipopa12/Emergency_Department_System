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
public class ChronicDiseases {
    String createChronicDisease() {
        String dis = "CREATE TABLE IF NOT EXISTS CHRONIC_DISEASES "
                + "(patientID INTEGER not NULL, "
                + " disease VARCHAR(255), "
                + " FOREIGN KEY(patientID) REFERENCES PATIENTS(patientID));";
        return dis;
    }
     public void insertCdisease(int id, String dis) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String disease = "INSERT IGNORE INTO CHRONIC_DISEASES VALUES (?,?)";
        PreparedStatement pstmt = con.prepareStatement(disease);
        try {

            pstmt.setInt(1, id);
            pstmt.setString(2, dis);
            pstmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ChronicDiseases.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     public String get_Cdiseases(int pid) throws ClassNotFoundException, SQLException {
        //String id = "SELECT role FROM LOGIN_INFOS WHERE username=\"kate\" AND password=\"kate1234\"";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String dis = "SELECT disease FROM CHRONIC_DISEASES "
                +"WHERE patientID=?;";
        PreparedStatement pstmt = con.prepareStatement(dis);
        //int id = 0;
        //String first=null;
        //String last=null;
        String disease = null;
        String allDis=null;
        try {
            pstmt.setInt(1, pid);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
          //      id = rs.getInt("patientID");
            //    first = rs.getString("firstname");
              //  last = rs.getString("lastname");
                disease = rs.getString("disease");
                if(allDis==null){
                    allDis=disease+",";
                }else{
                    allDis=allDis+disease+",";
                }
                //System.out.println(id +" "+first+" "+last+ " " + disease);
            }
            // System.out.println(r);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ChronicDiseases.class.getName()).log(Level.SEVERE, null, ex);
        }
return allDis;
    }

}
