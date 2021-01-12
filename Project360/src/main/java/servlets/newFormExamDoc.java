/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.Doctors;
import database.Examinations;
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
public class newFormExamDoc extends HttpServlet {

    private Examinations exam = new Examinations();
    private Doctors doc = new Doctors();
    private Visits visit = new Visits();

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {
            // read form fields
            String pid = request.getParameter("pid");
            String kind = request.getParameter("kind");
            String did = request.getParameter("did");
            String nid = request.getParameter("nid");
            String exa = request.getParameter("ex");
            String telephone = (String) request.getSession(false).getAttribute("telephone");
            String firstname = (String) request.getSession(false).getAttribute("firstname");
            String lastname = (String) request.getSession(false).getAttribute("lastname");
            System.out.println(telephone);
            System.out.println(firstname);
            System.out.println(lastname);
            System.out.println(pid);
            System.out.println(kind);
            System.out.println(did);
            System.out.println(nid);
            System.out.println(exa);
            int ID = doc.get_id(firstname, lastname, telephone);
            int vid = visit.get_id(Integer.parseInt(pid), String.valueOf(java.time.LocalDate.now()));
            exam.insertExam(ID, Integer.parseInt(pid), kind, Integer.parseInt(did), Integer.parseInt(nid), vid, exa);

            request.getRequestDispatcher("doctor.jsp").forward(request, response);

            //con.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
