/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.DocInShift;
import database.EmployeesInShift;
import database.LoginInfo;
import database.NursesInShift;
import database.Shift;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kater
 */
public class newFormShift extends HttpServlet {

    private LoginInfo user = new LoginInfo();
    private Shift shift = new Shift();
    private DocInShift docs = new DocInShift();
    private EmployeesInShift employees = new EmployeesInShift();
    private NursesInShift nurses = new NursesInShift();

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {

            // read form fields
            String d = request.getParameter("doctors");
            String n = request.getParameter("nurses");
            String e = request.getParameter("employees");
            String date = request.getParameter("date");
            String[] ds = d.split(",");
            String[] ns = n.split(",");
            String[] es = e.split(",");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EMERGENCY_DEPARTMENT", "root", "");
            Statement stmt = con.createStatement();

            shift.insertShift(date);
            for (int i = 0; i < ds.length; i++) {
                //System.out.println(visit.get_id( Integer.parseInt(pid), date));
                docs.insertDocInShift(Integer.parseInt(ds[i]), shift.get_id(date));
            }
            for (int i = 0; i < ns.length; i++) {
                //System.out.println(visit.get_id( Integer.parseInt(pid), date));
                nurses.insertNurseInShift(Integer.parseInt(ns[i]), shift.get_id(date));
            }
            for (int i = 0; i < es.length; i++) {
                //System.out.println(visit.get_id( Integer.parseInt(pid), date));
                employees.insertEmployeeInShift(Integer.parseInt(es[i]), shift.get_id(date));
            }
            request.getRequestDispatcher("employee.jsp").forward(request, response);

            //con.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
