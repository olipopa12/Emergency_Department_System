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
            Disease dis = new Disease();
            ExamFromNurse nexam = new ExamFromNurse();
            DocInShift docInShift = new DocInShift();
            Shift shift = new Shift();
            EmployeesInShift empInShift = new EmployeesInShift();
            NursesInShift nurseInShift = new NursesInShift();
            ChronicDiseases chronicDis = new ChronicDiseases();

            String createDoc = doc.createDoctor();
            stmt.executeUpdate(createDoc);
            String createNurse = nurse.createNurse();
            stmt.executeUpdate(createNurse);
            String createPatient = patient.createPatient();
            stmt.executeUpdate(createPatient);
            String createEmployee = employee.createEmployee();
            stmt.executeUpdate(createEmployee);
            String createVisit = visit.createVisit();
            stmt.executeUpdate(createVisit);
            String createLogin = user.createInfo();
            stmt.executeUpdate(createLogin);
            String createSym = sym.createSymptom();
            stmt.executeUpdate(createSym);
            String createDis = dis.createDisease();
            stmt.executeUpdate(createDis);
            String createMed = med.createMedicine();
            stmt.executeUpdate(createMed);
            String createNExam = nexam.createExamFromNurse();
            stmt.executeUpdate(createNExam);
            String createShift = shift.createShift();
            stmt.executeUpdate(createShift);
            String createDocInShift = docInShift.createDocsInShift();
            stmt.executeUpdate(createDocInShift);
            String createEmpInShift = empInShift.createEmployeesInShift();
            stmt.executeUpdate(createEmpInShift);
            String createNurseInShift = nurseInShift.createNursesInShift();
            stmt.executeUpdate(createNurseInShift);
            String createCdisease = chronicDis.createChronicDisease();
            stmt.executeUpdate(createCdisease);

            patient.insertPatient(1, "12119912345", "Kwstas", "Papadopoylos", "IKA", "Knosoy", 56, 21346, "6987453290");
            patient.insertPatient(2, "28019812945", "Mixalis", "Sifakis", "OGA", "Smyrnis", 34, 16100, "6987883670");
            patient.insertPatient(3, "19017912348", "Anastasia", "Fanoyraki", "IKA", "Mesologgioy", 78, 56789, "6935456790");
            patient.insertPatient(4, "09081012325", "Grigoris", "Spyroy", "IKA", "Eirinis", 90, 25604, "6997477294");
            patient.insertPatient(5, "18070012341", "Natasa", "Polaki", "OGA", "Papandreoy", 2, 81347, "6987422299");

            nurse.insertNurse(6, "Giannis", "Xristoy", "6958907643");
            nurse.insertNurse(7, "Kwstantina", "Papa", "6925907673");
            nurse.insertNurse(8, "Afroditi", "Dimoy", "6969990640");
            nurse.insertNurse(9, "Lazaros", "Dimitriadis", "6900907993");
            nurse.insertNurse(10, "Andreas", "Melas", "6932907743");
            nurse.insertNurse(11, "Ilias", "Georgioy", "6958897699");
            nurse.insertNurse(12, "Ermioni", "Anastasopoyloy", "6958557644");
            nurse.insertNurse(13, "Vasilis", "Vasileioy", "6933900643");
            nurse.insertNurse(14, "Manolis", "Koyridakis", "6989904443");
            nurse.insertNurse(15, "Iwanna", "Metaxa", "6958987543");

            employee.insertEmployee(16, "Katerina", "Diamanti", "6985888585");
            employee.insertEmployee(17, "Paylos", "Athanasioy", "6985678580");
            employee.insertEmployee(18, "Stratos", "Papadakis", "6995845590");
            employee.insertEmployee(19, "Alexis", "Nikiforoy", "6989088545");
            employee.insertEmployee(20, "Pelagia", "Dimitrioy", "6985558576");

            doc.insertDoctor(21, "Olimpia", "Popa", "Cardiologist", "6980765432");
            doc.insertDoctor(22, "George", "Papadakis", "Dermatologist", "6967543212");
            doc.insertDoctor(23, "John", "Papadopoylos", "Gastroenterologist", "6967903213");
            doc.insertDoctor(24, "Manos", "Aggelidakis", "Neurologist", "6950543234");
            doc.insertDoctor(25, "Katerina", "Petraki", "Pathologist", "6967543212");
            doc.insertDoctor(26, "Petros", "Dimitrioy", "Surgeon", "6969544517");
            doc.insertDoctor(27, "Aggeliki", "Nikolaoy", "Pulmonologist", "6965443172");
            doc.insertDoctor(28, "Dimitris", "Papadakos", "Neurologist", "6968943902");
            doc.insertDoctor(29, "Maria", "Spyropoyloy", "Dermatologist", "6965693632");
            doc.insertDoctor(30, "Eleni", "Nomikoy", "Pulmonologist", "6965421169");
            doc.insertDoctor(31, "Kwstantinos", "Paylidis", "Cardiologist", "6965003152");
            doc.insertDoctor(32, "Nikolaos", "Panagiwtakis", "Gastroenterologist", "6969443145");
            doc.insertDoctor(33, "Leyteris", "Papapetroy", "Surgeon", "6965446869");
            doc.insertDoctor(34, "Dimitra", "Diakatoy", "Pathologist", "6965673175");
            doc.insertDoctor(35, "Anna", "Alexioy", "Cardiologist", "6962343170");

            user.insertLoginInfo(1, "patient", "kwstas", "kwstas123");
            user.insertLoginInfo(2, "patient", "mixalis", "mixalis123");
            user.insertLoginInfo(3, "patient", "anastasia", "anastasia123");
            user.insertLoginInfo(4, "patient", "grogoris", "grogoris123");
            user.insertLoginInfo(5, "patient", "natasa", "natasa123");

            user.insertLoginInfo(6, "nurse", "giannis", "giannis123");
            user.insertLoginInfo(7, "nurse", "kwstantina", "kwstantina123");
            user.insertLoginInfo(8, "nurse", "afroditi", "afroditi123");
            user.insertLoginInfo(9, "nurse", "lazaros", "lazaros123");
            user.insertLoginInfo(10, "nurse", "andreas", "andreas123");
            user.insertLoginInfo(11, "nurse", "ilias", "ilias123");
            user.insertLoginInfo(12, "nurse", "ermioni", "ermioni123");
            user.insertLoginInfo(13, "nurse", "vasilis", "vasilis123");
            user.insertLoginInfo(14, "nurse", "manolis", "manolis123");
            user.insertLoginInfo(15, "nurse", "iwanna", "iwanna123");

            user.insertLoginInfo(16, "employee", "katerina", "katerina123");
            user.insertLoginInfo(17, "employee", "paylos", "paylos123");
            user.insertLoginInfo(18, "employee", "stratos", "stratos123");
            user.insertLoginInfo(19, "employee", "alexis", "alexis123");
            user.insertLoginInfo(20, "employee", "pelagia", "pelagia123");

            user.insertLoginInfo(21, "doctor", "oli", "oli123");
            user.insertLoginInfo(22, "doctor", "george", "george123");
            user.insertLoginInfo(23, "doctor", "john", "john123");
            user.insertLoginInfo(24, "doctor", "manos", "manos123");
            user.insertLoginInfo(25, "doctor", "katerina", "katerina123");
            user.insertLoginInfo(26, "doctor", "petros", "petros123");
            user.insertLoginInfo(27, "doctor", "aggeliki", "aggeliki123");
            user.insertLoginInfo(28, "doctor", "dimitris", "dimitris123");
            user.insertLoginInfo(29, "doctor", "maria", "maria123");
            user.insertLoginInfo(30, "doctor", "eleni", "eleni123");
            user.insertLoginInfo(31, "doctor", "kwstantinos", "kwstantinos123");
            user.insertLoginInfo(32, "doctor", "nikos", "nikos123");
            user.insertLoginInfo(33, "doctor", "leyteris", "leyteris123");
            user.insertLoginInfo(34, "doctor", "dimitra", "dimitra123");
            user.insertLoginInfo(35, "doctor", "anna", "anna123");

           // user.get_Info();
            employee.get_Employees();
            dis.insertDisease(1, "Stroke");
            dis.insertDisease(2, "Covid-19");
            dis.insertDisease(3, "Pneumonia");
            dis.insertDisease(4, "Asthma");
            dis.insertDisease(5, "Fracture");
            dis.insertDisease(6, "Burn");
            // med.insertMedicine(8, "ntepon", "hapi", 135, 23);
            med.insertMedicine(1, 2, "Depon", "Pill", 500);
            med.insertMedicine(2, 3, "Hydroxyzine", "Pill", 135);
            med.insertMedicine(3, 5, "Voltaren", "Gel", 75);
            med.insertMedicine(4, 1, "Aspirin", "Pill", 125);
            med.insertMedicine(5, 6, "Betadine", "Gel", 150);
            med.insertMedicine(6, 4, "Alamycin", "Injectable", 100);

            //med.get_Medicines();
            //doc.updateDoctor(3, "oli", "popa", "odontiatros", "6946942351");
            //patient.insertPatient(5, "008855223366", "nikolaos", "papadakis", "ika", "hraklio", 56, 2134, "854125698562");
            //patient.insertPatient(1, "301100000000000000", "katerina", "petraki", "ika", "avyeniki", 34, 9876, "6953456789");
            //pstmt.executeUpdate();
            //System.out.println(doc.get_id("oli"));
            //doc.deleteDoctor(3, "oli", "popa");
            sym.insertSymptom(5, "bhxas");
            sym.insertSymptom(3, "pyretos");
            //nurse.insertNurse(4, "giorgos", "kokolakis", "6958907643");
            //employee.insertEmployee(6, "manolhs", "chatzakis", "6985888585466");
            //med.insertMedicine(8, "ntepon", "hapi", 135, 23);
            visit.insertVisit(7, 1, "25/1/2020", "ponokoilos,pyretos,zalada");
            //nurse.updateNurse(4, "giorgos", "papadakis", "6969696969");
            //employee.deleteEmployee(6, "manolhs", "chatzakis");
            //nurse.deleteNurse(4, "giorgos", "kokolakis");
            // patient.updatePatient(5, "66666666", "nikos", "pap", "ika", "hraklio", 56, 2134, "6969696969");
            //employee.updateEmployee(6, "manos", "chatzakis", "6969696969");
            //user.insertLoginInfo(1, "patient", "kate", "kate123");
            //user.insertLoginInfo(2, "doctor", "geo", "geof");
            //user.insertLoginInfo(3, "doctor", "oli", "oli12");
            //user.insertLoginInfo(4, "nurse", "geok", "kokol");
            //user.insertLoginInfo(5, "patient", "nikos", "fanou");
            //user.insertLoginInfo(7, "employee", "manos", "chatz");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
