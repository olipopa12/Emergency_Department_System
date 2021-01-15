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
public class ExamFromNurse {

    String createExamFromNurse() {
        String exam = "CREATE TABLE IF NOT EXISTS EXAMINATIONS_FROM_NURSES "
                + "(examID INTEGER not NULL AUTO_INCREMENT, "
                + " nurseID INTEGER not NULL, "
                + " patientID INTEGER not NULL, "
                + " kindof VARCHAR(255), "
                + " visitID INTEGER not NULL, "
                + " PRIMARY KEY ( examID ), "
                + " FOREIGN KEY(visitID) REFERENCES VISITS(visitID), "
                //+ " FOREIGN KEY(docID) REFERENCES DOCTORS(docID), "
                + " FOREIGN KEY(patientID) REFERENCES PATIENTS(patientID), "
                + " FOREIGN KEY(nurseID) REFERENCES NURSES(nurseID))";
        return exam;
    }
    public void updateExamFromNurse(int id, int nid, int pid, String kind, int vid) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String update = new String(
                "UPDATE EXAMINATIONS_FROM_NURSES"
                + " SET nurseID= ?,"
                + " patientID= ?,"
                + " kindof= ?,"
                + " visitID= ?"
                + " WHERE examID= ?");
        //String doc = "INSERT IGNORE INTO DOCTORS VALUES (?,?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(update);
        try {

            pstmt.setInt(1, nid);
            pstmt.setInt(2, pid);
            pstmt.setString(3, kind);
            pstmt.setInt(4, vid);
           // pstmt.setString(7, exa);
            //  pstmt.setString(4, phone);
            pstmt.setInt(5, id);
            pstmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ExamFromNurse.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void insertExamFromNurse(int nid, int pid, String kind, int vid) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String exam = "INSERT IGNORE INTO EXAMINATIONS_FROM_NURSES VALUES (default,?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(exam);
        try {

            //pstmt.setInt(1, id);
            pstmt.setInt(1, nid);
            pstmt.setInt(2, pid);
            pstmt.setString(3, kind);
            pstmt.setInt(4, vid);
            //pstmt.setInt(5, nid);
            //pstmt.setInt(5, vid);
            pstmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ExamFromNurse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String get_ExamsFromNurses(int pid) throws ClassNotFoundException, SQLException {
        //String id = "SELECT role FROM LOGIN_INFOS WHERE username=\"kate\" AND password=\"kate1234\"";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String exam = "SELECT examID,kindof,N.firstname,N.lastname,V.date FROM NURSES N,EXAMINATIONS_FROM_NURSES E,VISITS V "
                + " WHERE E.nurseID=N.nurseID AND V.visitID=E.visitID AND E.patientID=?;";

        //String med = "SELECT * FROM MEDICINES";
        PreparedStatement pstmt = con.prepareStatement(exam);
       
        int id = 0;
        String kindof = null;
        String first = null;
        String last = null;

        String date = null;

        String allExams = null;
        String Exam = null;

        try {
            pstmt.setInt(1, pid);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                id = rs.getInt("examID");
                kindof = rs.getString("kindof");
                first = rs.getString("firstname");
                last = rs.getString("lastname");
                //      name = rs.getString("kind");
                date = rs.getString("date");
                //sub = rs.getInt("substance");
                Exam = (String.valueOf(id) + " " + kindof + " " + first + " " + last + " " + date + ",");
                if (allExams == null) {
                    allExams = Exam;
                } else {
                    allExams = allExams + Exam;
                }

            }

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ExamFromNurse.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allExams;
    }
    public String get_NursesExamsForMonth(int month,int year) throws ClassNotFoundException, SQLException {
        //String id = "SELECT role FROM LOGIN_INFOS WHERE username=\"kate\" AND password=\"kate1234\"";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String exam = "SELECT kindof,N.firstname,N.lastname,V.date FROM NURSES N,EXAMINATIONS_FROM_NURSES E,VISITS V "
                + " WHERE E.nurseID=N.nurseID AND E.visitID=V.visitID AND MONTH(V.date)=? AND YEAR(V.date)=?;";

        //String med = "SELECT * FROM MEDICINES";
        PreparedStatement pstmt = con.prepareStatement(exam);
        int i = 0;
        String kindof = null;
        String first = null;
        String last = null;
        String name = null;
        String date = null;
        // int sub = 0;
        String allExams = null;
        String Exam = null;
        // ResultSet rs=null;
        try {
            pstmt.setInt(1, month);
             pstmt.setInt(2, year);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                //id = rs.getInt("examID");
                kindof = rs.getString("kindof");
                first = rs.getString("firstname");
                last = rs.getString("lastname");
               // name = rs.getString("kind");
                date = rs.getString("date");
                //sub = rs.getInt("substance");
                Exam = ( kindof + " " + first + " " + last + " " + date + ",");
                //System.out.println(Exam);
                if (allExams == null) {
                    allExams = Exam;
                } else {
                    allExams = allExams + Exam;
                }
i++;
                // System.out.println(id + " " + did + " " + name + " " + kind + " " + sub);
            }
            //System.out.println(allMed);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ExamFromNurse.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allExams+i;
    }
}
