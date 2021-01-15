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
            pstmt.setInt(2, sid);
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
        String nurse = "SELECT NS.nurseID,N.firstname,N.lastname,NS.shiftID FROM NURSES N,NURSES_IN_SHIFT NS,SHIFTS S "
                + "WHERE N.nurseID=NS.nurseID AND NS.shiftID=S.shiftID AND S.date=?;";
        PreparedStatement pstmt = con.prepareStatement(nurse);
        int nid = 0;
        int sid = 0;

        String first = null;
        String last = null;
        String nurses = null;
        String allNurses = null;
        // ResultSet rs=null;
        try {
pstmt.setString(1, String.valueOf(java.time.LocalDate.now()));
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                nid = rs.getInt("nurseID");
                sid = rs.getInt("shiftID");
                first = rs.getString("firstname");
                last = rs.getString("lastname");
                nurses = (String.valueOf(nid) + " " + first + " " + last + " " + String.valueOf(sid) + ",");
                if (allNurses == null) {
                    allNurses = nurses;
                } else {
                    allNurses = allNurses + nurses;
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
    public String get_NurseShifts(int id,String date1,String date2) throws ClassNotFoundException, SQLException {
        //String id = "SELECT role FROM LOGIN_INFOS WHERE username=\"kate\" AND password=\"kate1234\"";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String shifts = "SELECT S.date FROM NURSES_IN_SHIFT NS,SHIFTS S "
                + "WHERE S.shiftID=NS.shiftID AND NS.docID=? AND S.date between ? AND ?;";
        PreparedStatement pstmt = con.prepareStatement(shifts);
        //int did = 0;
        //int sid = 0;

        String date = null;
        String allShifts = null;
        // ResultSet rs=null;
        try {
pstmt.setInt(1, id);
pstmt.setString(2, date1);
pstmt.setString(3, date2);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                date = rs.getString("date");
                if (allShifts == null) {
                    allShifts = date+",";
                } else {
                    allShifts = allShifts + date+",";
                }
            }
            // System.out.println(r);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(NursesInShift.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allShifts;
    }
    
     public void deleteNurseInShift(int sid ) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String delete = new String(
                "DELETE FROM NURSES_IN_SHIFT "
                + " WHERE shiftID=?;");
        //String doc = "INSERT IGNORE INTO DOCTORS VALUES (?,?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(delete);
        try {
            //pstmt.setInt(1, id);
            pstmt.setInt(1, sid);
            //pstmt.setString(3, lname);

            pstmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(NursesInShift.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
