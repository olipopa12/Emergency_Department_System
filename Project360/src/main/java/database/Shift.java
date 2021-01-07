/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author olipo
 */
public class Shift {
     String createShift() {
        String shift = "CREATE TABLE IF NOT EXISTS SHIFTS "
                + "(shiftID INTEGER not NULL, "
                + " date VARCHAR(255), "
                + " PRIMARY KEY ( shiftID ));";
        return shift;
    }
}
