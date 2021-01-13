/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.ChronicDiseases;
import database.ExamFromNurse;
import database.Examinations;
import database.ReExaminations;
import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kater
 */
public class get_history extends HttpServlet {

    private Examinations exd = new Examinations();
    private ReExaminations re = new ReExaminations();
    private ExamFromNurse exn = new ExamFromNurse();
    private ChronicDiseases cd = new ChronicDiseases();

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
        String id = "";
        id += request.getSession(false).getAttribute("id");
        //System.out.println("id: " + id);
        try {
            all += exd.get_Exams(Integer.parseInt(id));
            all += "|";
            all += exn.get_ExamsFromNurses(Integer.parseInt(id));
            all += "|";
            all += re.get_ReExams(Integer.parseInt(id));
            all += "|";
            all += cd.get_Cdiseases(Integer.parseInt(id));
            String arr = URLEncoder.encode(all, "utf-8");
            //System.out.println(all);
        } catch (Exception ex) {
            System.out.println(ex);
            ex.printStackTrace();
        }
        response.getOutputStream().println(all); //finish

    }
}
