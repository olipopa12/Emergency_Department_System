/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.ExamFromNurse;
import database.Examinations;
import database.ReExaminations;
import database.Visits;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kater
 */
public class see_dates extends HttpServlet {

    private Examinations exd = new Examinations();
    private ExamFromNurse exn = new ExamFromNurse();
    private ReExaminations re = new ReExaminations();
    private Visits v = new Visits();

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        HttpSession session = request.getSession(); //Creating a session
        //System.out.println(pat.get_id(firstname, lastname, telephone));
        session.setAttribute("year", year);
        session.setAttribute("month", month);
        System.out.println(year + month);
        request.getRequestDispatcher("statistics.jsp").forward(request, response);
    }
}
