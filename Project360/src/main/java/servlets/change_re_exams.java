/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.Doctors;
import database.ReExaminations;
import database.LoginInfo;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kater
 */
public class change_re_exams extends HttpServlet {

    private ReExaminations exam = new ReExaminations();
    private Doctors doc = new Doctors();

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {
            String firstname = "";
            String lastname = "";
            String telephone = "";
            String specialty = "";
            firstname += request.getSession(false).getAttribute("firstname");
            lastname += request.getSession(false).getAttribute("lastname");
            telephone += request.getSession(false).getAttribute("telephone");
            specialty += request.getSession(false).getAttribute("specialty");
            // read form fields
            String pid = request.getParameter("pid");
            String id = request.getParameter("id");
            String vid = request.getParameter("vid");
            String did = request.getParameter("did");
            String kind = request.getParameter("kind");
            String mid = request.getParameter("mid");
            String hosp = request.getParameter("hosp");

            exam.updateReExam(Integer.parseInt(id), doc.get_id(firstname, lastname, telephone), Integer.parseInt(pid), kind, Integer.parseInt(did), Integer.parseInt(mid), Integer.parseInt(vid), Boolean.parseBoolean(hosp));
            /*System.out.println("pid: " + pid);
            System.out.println("did: " + did);
            System.out.println("kind: " + kind);
            System.out.println("hosp: " + hosp);
            System.out.println("mid: " + mid);
            System.out.println("firstname: " + firstname);
            System.out.println("lastname: " + lastname);
            System.out.println("telephone: " + telephone);
            System.out.println("specialty: " + specialty);*/
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
            Statement stmt = con.createStatement();

            //int ID = doctor.get_id(firstname, lastname, telephone);
            HttpSession session = request.getSession(); //Creating a session

            session.setAttribute("firstname", firstname);
            session.setAttribute("lastname", lastname);
            session.setAttribute("specialty", specialty);
            session.setAttribute("telephone", telephone);
            request.getRequestDispatcher("doctor.jsp").forward(request, response);

            //con.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
