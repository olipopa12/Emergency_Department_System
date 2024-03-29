/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.LoginInfo;
import database.PatientsInShift;
import database.Shift;
import database.Symptoms;
import database.Visits;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kater
 */
public class newFormVisit extends HttpServlet {

    private LoginInfo user = new LoginInfo();
    private Visits visit = new Visits();
    private Symptoms symptom = new Symptoms();
    private PatientsInShift pat = new PatientsInShift();
    private Shift shift = new Shift();

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {

            // read form fields
            String pid = request.getParameter("pid");
            String symptoms = request.getParameter("symptoms");
            String[] symps = symptoms.split(",");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
            Statement stmt = con.createStatement();

            visit.insertVisit(Integer.parseInt(pid), String.valueOf(java.time.LocalDate.now()));
            for (int i = 0; i < symps.length; i++) {
                //System.out.println(visit.get_id( Integer.parseInt(pid), date));
                //System.out.println(visit.get_id(Integer.parseInt(pid), String.valueOf(java.time.LocalDate.now())));
                symptom.insertSymptom(visit.get_id(Integer.parseInt(pid), String.valueOf(java.time.LocalDate.now())), symps[i]);
                System.out.println("shift: " + shift.get_id(String.valueOf(java.time.LocalDate.now())));
            }
            pat.insertPatientInShift(Integer.parseInt(pid), shift.get_id(String.valueOf(java.time.LocalDate.now())));
            // Main.id_visit++;

            request.getRequestDispatcher("employee.jsp").forward(request, response);

            //con.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
