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

    public static int id = 7;

    public static void main(String args[]) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/", "root", "");
            Statement stmt = con.createStatement();
            String delete = "DROP DATABASE IF EXISTS EMERGENCY_DEPARTMENT";
            stmt.executeUpdate(delete);
            String create = "CREATE DATABASE IF NOT EXISTS EMERGENCY_DEPARTMENT";
//here sonoo is database name, root is username and password  
            stmt.executeUpdate(create);
            con.close();
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
            stmt = con.createStatement();
            Doctors doc = new Doctors();
            Nurses nurse = new Nurses();
            Patients patient = new Patients();
            Employees employee = new Employees();
            Examinations exam = new Examinations();
            Medicines med = new Medicines();
            Visits visit = new Visits();
            LoginInfo user = new LoginInfo();
            Symptoms sym = new Symptoms();

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
            String createLogin = user.createInfo();
            stmt.executeUpdate(createLogin);
            String createSym = sym.createSymptom();
            stmt.executeUpdate(createSym);

            //String insertDoc = doc.insertDoctor();
            // PreparedStatement pstmt = con.prepareStatement(insertDoc);
            sym.insertSymptom(5, "bhxas");
            sym.insertSymptom(3, "pyretos");
            doc.insertDoctor(3, "olimpia", "popa", "odontiatros", "3553558970");
            doc.insertDoctor(2, "giorgos", "kati", "kardiologos", "5675437865");
            doc.updateDoctor(3, "oli", "popa", "odontiatros", "6946942351");
            patient.insertPatient(5, "008855223366", "nikolaos", "papadakis", "ika", "hraklio", 56, 2134, "854125698562");
            patient.insertPatient(1, "301100000000000000", "katerina", "petraki", "ika", "avyeniki", 34, 9876, "6953456789");
            //pstmt.executeUpdate();
            //System.out.println(doc.get_id("oli"));
            //doc.deleteDoctor(3, "oli", "popa");
            nurse.insertNurse(4, "giorgos", "kokolakis", "6958907643");
            employee.insertEmployee(6, "manolhs", "chatzakis", "6985888585466");
            med.insertMedicine(8, "ntepon", "hapi", 135);
            visit.insertVisit(7, 1, "25/1/2020", "ponokoilos,pyretos,zalada");
            //nurse.updateNurse(4, "giorgos", "papadakis", "6969696969");
            //employee.deleteEmployee(6, "manolhs", "chatzakis");
            //nurse.deleteNurse(4, "giorgos", "kokolakis");
            patient.updatePatient(5, "66666666", "nikos", "pap", "ika", "hraklio", 56, 2134, "6969696969");
            employee.updateEmployee(6, "manos", "chatzakis", "6969696969");
            user.insertLoginInfo(1, "patient", "kate", "kate123");
            user.insertLoginInfo(2, "doctor", "geo", "geof");
            user.insertLoginInfo(3, "doctor", "oli", "oli12");
            user.insertLoginInfo(4, "nurse", "geok", "kokol");
            user.insertLoginInfo(5, "patient", "nikos", "fanou");
            user.insertLoginInfo(6, "employee", "manos", "chatz");
            //user.deleteLoginInfo("kate");
            //user.deleteLoginInfo("oli");
            //PreparedStatement pstmt = con.prepareStatement(insertKapoion);
            //pstmt = kapoios.insertSpecial(pstmt, 3, "patient", "kate", "kate1234");
            //pstmt.executeUpdate();
            //stmt.executeUpdate(insertDoc);
            // ResultSet rs = stmt.executeQuery("select * from persons");
            //while (rs.next()) {
            //  System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            //}
            con.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
