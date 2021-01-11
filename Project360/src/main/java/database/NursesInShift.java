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
public class NursesInShift {
     String createNursesInShift() {
        String sql = "CREATE TABLE IF NOT EXISTS NURSES_IN_SHIFT "
                + "(nurseID INTEGER not NULL, "
                + " shiftID INTEGER not NULL, "
                + " FOREIGN KEY(shiftID) REFERENCES SHIFTS(shiftID), "
                + " FOREIGN KEY(nurseID) REFERENCES NURSES(nurseID));";
        return sql;
    }
     public void insertNurseInShift(int nid, int sid) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String nurseInShift = "INSERT IGNORE INTO NURSES_IN_SHIFT VALUES (?,?)";
        PreparedStatement pstmt = con.prepareStatement(nurseInShift);
        try {

            pstmt.setInt(1, nid);
            pstmt.setInt(2,sid);
            pstmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(NursesInShift.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     public String get_NursesInShift() throws ClassNotFoundException, SQLException {
        //String id = "SELECT role FROM LOGIN_INFOS WHERE username=\"kate\" AND password=\"kate1234\"";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String nurse= "SELECT NS.nurseID,N.firstname,N.lastname,shiftID FROM NURSES N,NURSES_IN_SHIFT NS "
                +"WHERE N.nurseID=NS.nurseID;";
        PreparedStatement pstmt = con.prepareStatement(nurse);
        int nid = 0;
        int sid=0;
        
        String first = null;
        String last = null;
        String nurses = null;
String allNurses=null;
        // ResultSet rs=null;
        try {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                nid = rs.getInt("nurseID");
                sid = rs.getInt("shiftID");
                first = rs.getString("firstname");
                last = rs.getString("lastname");
                nurses=(String.valueOf(nid)+" "+first+" "+last+" "+String.valueOf(sid)+",");
                if(allNurses==null){
                    allNurses=nurses;
                }else{
                    allNurses=allNurses+nurses;
                }
                //phone = rs.getString("phone");
                //System.out.println(id + " " + symp);
            }
            // System.out.println(r);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(NursesInShift.class.getName()).log(Level.SEVERE, null, ex);
        }
return allNurses;
    }
}
