/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.ExamFromNurse;
import database.Nurses;
import database.Visits;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kater
 */
public class newFormExamNurse extends HttpServlet {

    private ExamFromNurse exam = new ExamFromNurse();
    private Nurses nurse = new Nurses();
    private Visits visit = new Visits();

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {
            // read form fields
            String pid = request.getParameter("pid");
            String kind = request.getParameter("kind");
            String telephone = (String) request.getSession(false).getAttribute("telephone");
            String firstname = (String) request.getSession(false).getAttribute("firstname");
            String lastname = (String) request.getSession(false).getAttribute("lastname");
          /*System.out.println(telephone);
            System.out.println(firstname);
            System.out.println(lastname);
            System.out.println(pid);
            System.out.println(kind);*/
            int ID = nurse.get_id(firstname, lastname, telephone);
            int vid = visit.get_id(Integer.parseInt(pid), String.valueOf(java.time.LocalDate.now()));
            exam.insertExamFromNurse(ID, Integer.parseInt(pid), kind, vid);

            request.getRequestDispatcher("nurse.jsp").forward(request, response);

            //con.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
