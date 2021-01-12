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
import static java.sql.JDBCType.NULL;

public class Main {

    public static int id_visit = 2;

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
            PatientsInShift patientInShift = new PatientsInShift();
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
            String createPatientInShift = patientInShift.createPatientsInShift();
            stmt.executeUpdate(createPatientInShift);
            String createCdisease = chronicDis.createChronicDisease();
            stmt.executeUpdate(createCdisease);

            patient.insertPatient("12119912345", "Kwstas", "Papadopoylos", "IKA", "Knosoy", 56, 21346, "6987453290");
            patient.insertPatient("28019812945", "Mixalis", "Sifakis", "OGA", "Smyrnis", 34, 16100, "6987883670");
            patient.insertPatient("19017912348", "Anastasia", "Fanoyraki", "IKA", "Mesologgioy", 78, 56789, "6935456790");
            patient.insertPatient("09081012325", "Grigoris", "Spyroy", "IKA", "Eirinis", 90, 25604, "6997477294");
            patient.insertPatient("18070012341", "Natasa", "Polaki", "OGA", "Papandreoy", 2, 81347, "6987422299");

            //  patient.insertPatient(NULL create, create, create, create, create, id, id, create);
            nurse.insertNurse("Giannis", "Xristoy", "6958907643");
            nurse.insertNurse("Kwstantina", "Papa", "6925907673");
            nurse.insertNurse("Afroditi", "Dimoy", "6969990640");
            nurse.insertNurse("Lazaros", "Dimitriadis", "6900907993");
            nurse.insertNurse("Andreas", "Melas", "6932907743");
            nurse.insertNurse("Ilias", "Georgioy", "6958897699");
            nurse.insertNurse("Ermioni", "Anastasopoyloy", "6958557644");
            nurse.insertNurse("Vasilis", "Vasileioy", "6933900643");
            nurse.insertNurse("Manolis", "Koyridakis", "6989904443");
            nurse.insertNurse("Iwanna", "Metaxa", "6958987543");

            employee.insertEmployee("Lina", "Diamanti", "6985888585");
            employee.insertEmployee("Paylos", "Athanasioy", "6985678580");
            employee.insertEmployee("Stratos", "Papadakis", "6995845590");
            employee.insertEmployee("Alexis", "Nikiforoy", "6989088545");
            employee.insertEmployee("Pelagia", "Dimitrioy", "6985558576");

            doc.insertDoctor("Olimpia", "Popa", "Cardiologist", "6980765432");
            doc.insertDoctor("George", "Papadakis", "Dermatologist", "6967543212");
            doc.insertDoctor("John", "Papadopoylos", "Gastroenterologist", "6967903213");
            doc.insertDoctor("Manos", "Aggelidakis", "Neurologist", "6950543234");
            doc.insertDoctor("Katerina", "Petraki", "Pathologist", "6967543213");
            doc.insertDoctor("Petros", "Dimitrioy", "Surgeon", "6969544517");
            doc.insertDoctor("Aggeliki", "Nikolaoy", "Pulmonologist", "6965443172");
            doc.insertDoctor("Dimitris", "Papadakos", "Neurologist", "6968943902");
            doc.insertDoctor("Maria", "Spyropoyloy", "Dermatologist", "6965693632");
            doc.insertDoctor("Eleni", "Nomikoy", "Pulmonologist", "6965421169");
            doc.insertDoctor("Kwstantinos", "Paylidis", "Cardiologist", "6965003152");
            doc.insertDoctor("Nikolaos", "Panagiwtakis", "Gastroenterologist", "6969443145");
            doc.insertDoctor("Leyteris", "Papapetroy", "Surgeon", "6965446869");
            doc.insertDoctor("Dimitra", "Diakatoy", "Pathologist", "6965673175");
            doc.insertDoctor("Anna", "Alexioy", "Cardiologist", "6962343170");

            user.insertLoginInfo(1, "patient", "kwstas", "kwstas123");
            user.insertLoginInfo(2, "patient", "mixalis", "mixalis123");
            user.insertLoginInfo(3, "patient", "anastasia", "anastasia123");
            user.insertLoginInfo(4, "patient", "grigoris", "grigoris123");
            user.insertLoginInfo(5, "patient", "natasa", "natasa123");

            user.insertLoginInfo(1, "employee", "lina", "lina123");
            user.insertLoginInfo(2, "employee", "paylos", "paylos123");
            user.insertLoginInfo(3, "employee", "stratos", "stratos123");
            user.insertLoginInfo(4, "employee", "alexis", "alexis123");
            user.insertLoginInfo(5, "employee", "pelagia", "pelagia123");

            user.insertLoginInfo(1, "doctor", "oli", "oli123");
            user.insertLoginInfo(2, "doctor", "george", "george123");
            user.insertLoginInfo(3, "doctor", "john", "john123");
            user.insertLoginInfo(4, "doctor", "manos", "manos123");
            user.insertLoginInfo(5, "doctor", "katerina", "katerina123");
            user.insertLoginInfo(6, "doctor", "petros", "petros123");
            user.insertLoginInfo(7, "doctor", "aggeliki", "aggeliki123");
            user.insertLoginInfo(8, "doctor", "dimitris", "dimitris123");
            user.insertLoginInfo(9, "doctor", "maria", "maria123");
            user.insertLoginInfo(10, "doctor", "eleni", "eleni123");
            user.insertLoginInfo(11, "doctor", "kwstantinos", "kwstantinos123");
            user.insertLoginInfo(12, "doctor", "nikos", "nikos123");
            user.insertLoginInfo(13, "doctor", "leyteris", "leyteris123");
            user.insertLoginInfo(14, "doctor", "dimitra", "dimitra123");
            user.insertLoginInfo(15, "doctor", "anna", "anna123");

            user.insertLoginInfo(1, "nurse", "giannis", "giannis123");
            user.insertLoginInfo(2, "nurse", "kwstantina", "kwstantina123");
            user.insertLoginInfo(3, "nurse", "afroditi", "afroditi123");
            user.insertLoginInfo(4, "nurse", "lazaros", "lazaros123");
            user.insertLoginInfo(5, "nurse", "andreas", "andreas123");
            user.insertLoginInfo(6, "nurse", "ilias", "ilias123");
            user.insertLoginInfo(7, "nurse", "ermioni", "ermioni123");
            user.insertLoginInfo(8, "nurse", "vasilis", "vasilis123");
            user.insertLoginInfo(9, "nurse", "manolis", "manolis123");
            user.insertLoginInfo(10, "nurse", "iwanna", "iwanna123");

            //user.get_Info();
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

            visit.insertVisit(1, "2020-01-12");

            //sym.insertSymptom(1, "vixas");
            //sym.insertSymptom(1, "pyretos");
            //sym.insertSymptom(1, "ponolaimos");
            shift.insertShift();
            docInShift.insertDocInShift(3, 1);
            docInShift.insertDocInShift(5, 1);
            docInShift.insertDocInShift(8, 1);
            empInShift.insertEmployeeInShift(3, 1);
            nurseInShift.insertNurseInShift(8, 1);
            nurseInShift.insertNurseInShift(10, 1);
            nurseInShift.insertNurseInShift(4, 1);
            patientInShift.insertPatientInShift(3, 1);
            patientInShift.insertPatientInShift(5, 1);

            chronicDis.insertCdisease(2, "Asthma");
            chronicDis.insertCdisease(2, "Diabetes");
            chronicDis.insertCdisease(3, "Osteoarthritis");
            System.out.println(shift.get_id("13/1/21"));
            //chronicDis.get_Cdiseases();
            //sym.get_Symptoms();
            //patient.get_Patients();
            //med.get_Medicines();
            //doc.updateDoctor(3, "oli", "popa", "odontiatros", "6946942351");
            //patient.insertPatient(5, "008855223366", "nikolaos", "papadakis", "ika", "hraklio", 56, 2134, "854125698562");
            //patient.insertPatient(1, "301100000000000000", "katerina", "petraki", "ika", "avyeniki", 34, 9876, "6953456789");
            //pstmt.executeUpdate();
            //System.out.println(doc.get_id("oli"));
            //doc.deleteDoctor(3, "oli", "popa");
            //sym.insertSymptom(5, "bhxas");
            //sym.insertSymptom(3, "pyretos");
            //nurse.insertNurse(4, "giorgos", "kokolakis", "6958907643");
            //employee.insertEmployee(6, "manolhs", "chatzakis", "6985888585466");
            //med.insertMedicine(8, "ntepon", "hapi", 135, 23);

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
