/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.Visits;
import database.ExamFromNurse;
import database.Examinations;
import database.ReExaminations;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kater
 */
public class get_statistics extends HttpServlet {

    private Examinations exd = new Examinations();
    private ReExaminations re = new ReExaminations();
    private ExamFromNurse exn = new ExamFromNurse();
    private Visits v = new Visits();

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String all = "";
        String month = "";
        month += request.getSession(false).getAttribute("month");
        String year = "";
        year += request.getSession(false).getAttribute("year");
        System.out.println(month + year);
        try {
            all += exd.get_ExamsForMonth(Integer.parseInt(month), Integer.parseInt(year));
            all += "|";
            all += exn.get_NursesExamsForMonth(Integer.parseInt(month), Integer.parseInt(year));
            all += "|";
            all += re.get_ReExamsForMonth(Integer.parseInt(month), Integer.parseInt(year));
            all += "|";
            all += v.get_Visits(Integer.parseInt(month), Integer.parseInt(year));
            String arr = URLEncoder.encode(all, "utf-8");
            System.out.println(all);
        } catch (Exception ex) {
            System.out.println(ex);
            ex.printStackTrace();
        }
        response.getOutputStream().println(all); //finish

    }
}
