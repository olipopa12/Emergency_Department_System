/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.Doctors;
import database.Examinations;
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
public class change_exams extends HttpServlet {

    private Examinations exam = new Examinations();
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
            String id = request.getParameter("eid");
            String pid = request.getParameter("pid");
            String did = request.getParameter("did");
            String vid = request.getParameter("vid");
            String kind = request.getParameter("kind");
            String ex = request.getParameter("ex");
            String nid = request.getParameter("nid");

            exam.updateExam(Integer.parseInt(id), doc.get_id(firstname, lastname, telephone), Integer.parseInt(pid), kind, Integer.parseInt(did), Integer.parseInt(nid), Integer.parseInt(vid), ex);

            /*System.out.println("pid: " + pid);
            System.out.println("did: " + did);
            System.out.println("kind: " + kind);
            System.out.println("ex: " + ex);
            System.out.println("nid: " + nid);
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
