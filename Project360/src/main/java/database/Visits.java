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
public class Visits {
    String createVisit() {
        String visit = "CREATE TABLE IF NOT EXISTS VISITS "
                + "(visitID INTEGER not NULL, "
                + " patientID INTEGER not NULL, "
                + " date VARCHAR(255), "
                + " symtoms VARCHAR(255), "
                + " PRIMARY KEY ( visitID ), "
                + " FOREIGN KEY(patientID) REFERENCES PATIENTS(patientID));";
        return visit;
    }
}
