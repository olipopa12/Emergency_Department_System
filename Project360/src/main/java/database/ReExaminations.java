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
 * @author kater
 */
public class ReExaminations {

    String createReExam() {
        String exam = "CREATE TABLE IF NOT EXISTS RE_EXAMINATIONS "
                + "(examID INTEGER not NULL AUTO_INCREMENT, "
                + " docID INTEGER not NULL, "
                + " patientID INTEGER not NULL, "
                + " kindof VARCHAR(255), "
                + " diseaseID INTEGER not NULL, "
                + " medID INTEGER not NULL, "
                + " visitID INTEGER not NULL, "
                + " hospitalization BOOLEAN, "
                + " PRIMARY KEY ( examID ), "
                + " FOREIGN KEY(visitID) REFERENCES VISITS(visitID), "
                + " FOREIGN KEY(diseaseID) REFERENCES DISEASES(disID), "
                + " FOREIGN KEY(medID) REFERENCES MEDICINES(medID), "
                + " FOREIGN KEY(patientID) REFERENCES PATIENTS(patientID), "
                + " FOREIGN KEY(docID) REFERENCES DOCTORS(docID))";
        return exam;
    }

    public void insertReExam(int did, int pid, String kind, int disID, int mid, int vid, boolean hospital) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String exam = "INSERT IGNORE INTO RE_EXAMINATIONS VALUES (default,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(exam);
        try {

            //pstmt.setInt(1, id);
            pstmt.setInt(1, did);
            pstmt.setInt(2, pid);
            pstmt.setString(3, kind);
            pstmt.setInt(4, disID);
            pstmt.setInt(5, mid);
            pstmt.setInt(6, vid);
            pstmt.setBoolean(7, hospital);
            pstmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ReExaminations.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String get_ReExams(int pid) throws ClassNotFoundException, SQLException {
        //String id = "SELECT role FROM LOGIN_INFOS WHERE username=\"kate\" AND password=\"kate1234\"";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String exam = "SELECT examID,E.kindof,D.firstname,D.lastname,DIS.kind,M.name,hospitalization,V.date FROM DOCTORS D,RE_EXAMINATIONS E,VISITS V, "
                + "DISEASES DIS,MEDICINES M WHERE E.docID=D.docID AND V.visitID=E.visitID AND E.diseaseID=DIS.disID AND E.medID=M.medID AND E.patientID=?;";

        //String med = "SELECT * FROM MEDICINES";
        PreparedStatement pstmt = con.prepareStatement(exam);
       
        int id = 0;
        String kindof = null;
        String first = null;
        String last = null;
        String dis = null;
        String med = null;
        boolean hospital = false;
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
                dis = rs.getString("kind");
                med = rs.getString("name");
                hospital = rs.getBoolean("hospitalization");
                date = rs.getString("date");
                //sub = rs.getInt("substance");
                Exam = (String.valueOf(id) + " " +kindof+ " " + first + " " + last + " " + dis +" "+med+" "+String.valueOf(hospital)+" "+date + ",");
                if (allExams == null) {
                    allExams = Exam;
                } else {
                    allExams = allExams + Exam;
                }

            }

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ReExaminations.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allExams;
    }
    public String get_Covid() throws ClassNotFoundException, SQLException {
        //String id = "SELECT role FROM LOGIN_INFOS WHERE username=\"kate\" AND password=\"kate1234\"";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
        //stmt = con.createStatement();
        String exam = "SELECT P.patientID,P.firstname,P.lastname FROM PATIENTS P,RE_EXAMINATIONS E, "
                + "DISEASES D WHERE P.patientID=E.patientID AND E.diseaseID=D.disID AND D.kind=\"COVID-19\";";

        //String med = "SELECT * FROM MEDICINES";
        PreparedStatement pstmt = con.prepareStatement(exam);
        ChronicDiseases cd=new ChronicDiseases();
        int id = 0;
        //String kindof = null;
        String first = null;
        String last = null;
        String dis = null;
        //String med = null;
        //boolean hospital = false;
        //String date = null;

        String allExams = null;
        String Exam = null;

        try {
            //pstmt.setInt(1, pid);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                id = rs.getInt("patientID");
                //kindof = rs.getString("kindof");
                first = rs.getString("firstname");
                last = rs.getString("lastname");
                //dis = rs.getString("kind");
                //med = rs.getString("name");
                //hospital = rs.getBoolean("hospitalization");
                //date = rs.getString("date");
                //sub = rs.getInt("substance");
                Exam = (String.valueOf(id) + " " + " " + first + " " + last + " " + cd.get_Cdiseases(id) + " " + ",");
                if (allExams == null) {
                    allExams = Exam;
                } else {
                    allExams = allExams + Exam;
                }

            }

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ReExaminations.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allExams;
    }
}
