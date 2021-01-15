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
public class DocInShift {

    String createDocsInShift() {
        String sql = "CREATE TABLE IF NOT EXISTS DOCS_IN_SHIFT "
                + "(docID INTEGER not NULL, "
                + " shiftID INTEGER not NULL, "
                + " FOREIGN KEY(shiftID) REFERENCES SHIFTS(shiftID), "
                + " FOREIGN KEY(docID) REFERENCES DOCTORS(docID));";
        return sql;
    }

    public void insertDocInShift(int did, int sid) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String docInShift = "INSERT IGNORE INTO DOCS_IN_SHIFT VALUES (?,?)";
        PreparedStatement pstmt = con.prepareStatement(docInShift);
        try {

            pstmt.setInt(1, did);
            pstmt.setInt(2, sid);
            pstmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DocInShift.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
  
    public String get_DocsInShift() throws ClassNotFoundException, SQLException {
        //String id = "SELECT role FROM LOGIN_INFOS WHERE username=\"kate\" AND password=\"kate1234\"";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String doc = "SELECT DS.docID,D.firstname,D.lastname,DS.shiftID FROM DOCTORS D,DOCS_IN_SHIFT DS,SHIFTS S "
                + "WHERE D.docID=DS.docID AND DS.shiftID=S.shiftID AND S.date=?;";
        PreparedStatement pstmt = con.prepareStatement(doc);
        int did = 0;
        int sid = 0;

        String first = null;
        String last = null;
        String docs = null;
        String allDocs = null;
        // ResultSet rs=null;
        try {
pstmt.setString(1, String.valueOf(java.time.LocalDate.now()));
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                did = rs.getInt("docID");
                sid = rs.getInt("shiftID");
                first = rs.getString("firstname");
                last = rs.getString("lastname");
                docs = (String.valueOf(did) + " " + first + " " + last + " " + String.valueOf(sid) + ",");
                if (allDocs == null) {
                    allDocs = docs;
                } else {
                    allDocs = allDocs + docs;
                }
                //phone = rs.getString("phone");
                //System.out.println(id + " " + symp);
            }
            // System.out.println(r);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DocInShift.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allDocs;
    }
    public String get_DocShifts(int id,String date1,String date2) throws ClassNotFoundException, SQLException {
        //String id = "SELECT role FROM LOGIN_INFOS WHERE username=\"kate\" AND password=\"kate1234\"";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String shifts = "SELECT S.date FROM DOCS_IN_SHIFT DS,SHIFTS S "
                + "WHERE S.shiftID=DS.shiftID AND DS.docID=? AND S.date between ? AND ?;";
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
            Logger.getLogger(DocInShift.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allShifts;
    }
    public void deleteDocInShift(int sid ) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String delete = new String(
                "DELETE FROM DOCS_IN_SHIFT "
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
            Logger.getLogger(DocInShift.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
