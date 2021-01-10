/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.LoginInfo;
import database.Main;
import database.Symptoms;
import database.Visits;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {

            // read form fields
            String pid = request.getParameter("pid");
            String date = request.getParameter("date");
            String symptoms = request.getParameter("symptoms");
            String[] symps = symptoms.split(",");
            /*List<String> kati = Arrays.asList(symps);
            ArrayList<String> Symps = new ArrayList<String>(kati);*/
            for (int i = 0; i < symps.length; i++) {
                symptom.insertSymptom(Main.id_visit, symps[i]);
            }
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
            Statement stmt = con.createStatement();

            visit.insertVisit(Main.id_visit, Integer.parseInt(pid), date);
            Main.id_visit++;

            request.getRequestDispatcher("index.jsp").forward(request, response);

            //con.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
