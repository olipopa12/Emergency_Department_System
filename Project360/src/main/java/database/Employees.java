package database;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author olipo
 */
public class Employees {

    String createEmployee() {
        String employee = "CREATE TABLE IF NOT EXISTS EMPLOYEES "
                + "(employeeID INTEGER not NULL, "
                + " name VARCHAR(255), "
                + " phone INTEGER, "
                + " PRIMARY KEY ( employeeID ));";
        return employee;
    }
}
