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
public class Examinations {

    String createExam() {
        String exam = "CREATE TABLE IF NOT EXISTS EXAMINATIONS "
                + "(examID INTEGER not NULL AUTO_INCREMENT, "
                + " docID INTEGER not NULL, "
                + " patientID INTEGER not NULL, "
                + " kindof VARCHAR(255), "
                + " diseaseID INTEGER not NULL, "
                + " nurseID INTEGER not NULL, "
                + " visitID INTEGER not NULL, "
                + " orderexam VARCHAR(255), "
                + " PRIMARY KEY ( examID ), "
                + " FOREIGN KEY(visitID) REFERENCES VISITS(visitID), "
                + " FOREIGN KEY(diseaseID) REFERENCES DISEASES(disID), "
                + " FOREIGN KEY(nurseID) REFERENCES NURSES(nurseID), "
                + " FOREIGN KEY(patientID) REFERENCES PATIENTS(patientID), "
                + " FOREIGN KEY(docID) REFERENCES DOCTORS(docID))";
        return exam;
    }

    public void insertExam(int did, int pid, String kind, int disID, int nid, int vid, String exa) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String exam = "INSERT IGNORE INTO EXAMINATIONS VALUES (default,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(exam);
        try {
            //pstmt.setInt(1, id);
            pstmt.setInt(1, did);
            pstmt.setInt(2, pid);
            pstmt.setString(3, kind);
            pstmt.setInt(4, disID);
            pstmt.setInt(5, nid);
            pstmt.setInt(6, vid);
            pstmt.setString(7, exa);
            pstmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Examinations.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String get_Exams(int pid) throws ClassNotFoundException, SQLException {
        //String id = "SELECT role FROM LOGIN_INFOS WHERE username=\"kate\" AND password=\"kate1234\"";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String exam = "SELECT examID,kindof,D.firstname,D.lastname,DIS.kind,V.date FROM DOCTORS D,EXAMINATIONS E,VISITS V, "
                + "DISEASES DIS WHERE E.docID=D.docID AND E.diseaseID=DIS.disID AND E.patientID=?;";

        //String med = "SELECT * FROM MEDICINES";
        PreparedStatement pstmt = con.prepareStatement(exam);
        int id = 0;
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
            pstmt.setInt(1, pid);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                id = rs.getInt("examID");
                kindof = rs.getString("kindof");
                first = rs.getString("firstname");
                last = rs.getString("lastname");
                name = rs.getString("kind");
                date = rs.getString("date");
                //sub = rs.getInt("substance");
                Exam = (String.valueOf(id) + " " + kindof + " " + first + " " + last + " " + name + " " + date + ",");
                if (allExams == null) {
                    allExams = Exam;
                } else {
                    allExams = allExams + Exam;
                }

                // System.out.println(id + " " + did + " " + name + " " + kind + " " + sub);
            }
            //System.out.println(allMed);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Medicines.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allExams;
    }

}
