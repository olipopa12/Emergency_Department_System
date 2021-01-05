package database;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author olipo
 */
import database.Examinations;
import java.sql.*;

public class Main {

    public static void main(String args[]) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/", "root", "");
            Statement stmt = con.createStatement();
            String create = "CREATE DATABASE IF NOT EXISTS EMERGENCY_DEPARTMENT";
//here sonoo is database name, root is username and password  
            stmt.executeUpdate(create);
            con.close();
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
            stmt = con.createStatement();
            Doctor doc = new Doctor();
            Nurses nurse = new Nurses();
            Patients patient = new Patients();
            Employees employee = new Employees();
            Examinations exam = new Examinations();
            Medicines med = new Medicines();
            Visits visit = new Visits();
            LoginInfo kapoios = new LoginInfo();

            String createDoc = doc.createDoctor();
            stmt.executeUpdate(createDoc);
            String createNurse = nurse.createNurse();
            stmt.executeUpdate(createNurse);
            String createPatient = patient.createPatient();
            stmt.executeUpdate(createPatient);
            String createEmployee = employee.createEmployee();
            stmt.executeUpdate(createEmployee);
            String createExam = exam.createExam();
            stmt.executeUpdate(createExam);
            String createMed = med.createMedicine();
            stmt.executeUpdate(createMed);
            String createVisit = visit.createVisit();
            stmt.executeUpdate(createVisit);
            String createLogin = kapoios.createInfo();
            stmt.executeUpdate(createLogin);

            String insertDoc = doc.insertDoctor();
            PreparedStatement pstmt = con.prepareStatement(insertDoc);
            pstmt = doc.insertSpecial(pstmt, 2, "oli", "kati", 355);
            pstmt.executeUpdate();

            String insertKapoion = kapoios.insertLoginInfo();
            pstmt = con.prepareStatement(insertKapoion);
            pstmt = kapoios.insertSpecial(pstmt, 3, "patient", "kate", "kate1234");
            pstmt.executeUpdate();
            //stmt.executeUpdate(insertDoc);

            // ResultSet rs = stmt.executeQuery("select * from persons");
            //while (rs.next()) {
            //  System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            //}
            String delete = "DROP DATABASE EMERGENCY_DEPARTMENT";
            //stmt.executeUpdate(delete);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
