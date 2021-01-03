/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author olipo
 */
public class Patients {
    String createPatient() {
        String patient = "CREATE TABLE IF NOT EXISTS PATIENTS "
                + "(patientID INTEGER not NULL, "
                + " AMKA INTEGER not NULL, "
                + " name VARCHAR(255), "
                + " insurance VARCHAR(255), "
                + " address VARCHAR(255), "
                + " phone INTEGER, "
                + " PRIMARY KEY ( patientID ));";
        return patient;
    }
}
