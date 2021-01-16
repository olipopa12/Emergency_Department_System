/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.ExamFromNurse;
import database.Nurses;
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
public class change_nurse_exams extends HttpServlet {

    private ExamFromNurse exam = new ExamFromNurse();
    private Nurses nurse = new Nurses();

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
            // read form fields
            String pid = request.getParameter("pid");
            String id = request.getParameter("id");
            String kind = request.getParameter("kind");
            String vid = request.getParameter("vid");
            exam.updateExamFromNurse(Integer.parseInt(id), nurse.get_id(firstname, lastname, telephone), Integer.parseInt(pid), kind, Integer.parseInt(vid));
            /*System.out.println("pid: " + pid);
            System.out.println("kind: " + kind);
            System.out.println("firstname: " + firstname);
            System.out.println("lastname: " + lastname);
            System.out.println("telephone: " + telephone);*/
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
            Statement stmt = con.createStatement();

            //int ID = doctor.get_id(firstname, lastname, telephone);
            HttpSession session = request.getSession(); //Creating a session

            session.setAttribute("firstname", firstname);
            session.setAttribute("lastname", lastname);
            session.setAttribute("telephone", telephone);
            request.getRequestDispatcher("nurse.jsp").forward(request, response);

            //con.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
