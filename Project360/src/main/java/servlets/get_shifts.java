/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.DocInShift;
import database.EmployeesInShift;
import database.NursesInShift;
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
public class get_shifts extends HttpServlet {

    private DocInShift doc = new DocInShift();
    private NursesInShift nur = new NursesInShift();
    private EmployeesInShift emp = new EmployeesInShift();

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
        String start = "";
        start += request.getSession(false).getAttribute("start");
        //System.out.println(start);
        String end = "";
        end += request.getSession(false).getAttribute("end");
        //System.out.println(end);
        String id = "";
        id += request.getSession(false).getAttribute("id");
        //System.out.println(id);
        String all = "";
        try {
            if (emp.get_EmpShifts(Integer.parseInt(id), start, end) != null) {
                all += emp.get_EmpShifts(Integer.parseInt(id), start, end);
            } else if (nur.get_NurseShifts(Integer.parseInt(id), start, end) != null) {
                all += nur.get_NurseShifts(Integer.parseInt(id), start, end);
            } else {
                all += doc.get_DocShifts(Integer.parseInt(id), start, end);
            }
            String arr = URLEncoder.encode(all, "utf-8");
            //System.out.println(all);
        } catch (Exception ex) {
            System.out.println(ex);
            ex.printStackTrace();
        }
        response.getOutputStream().println(all); //finish

    }
}
