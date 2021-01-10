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
public class ChronicDiseases {
    String createChronicDisease() {
        String dis = "CREATE TABLE IF NOT EXISTS CHRONIC_DISEASES "
                + "(patientID INTEGER not NULL, "
                + " disease VARCHAR(255), "
                + " FOREIGN KEY(patientID) REFERENCES PATIENTS(patientID));";
        return dis;
    }
}
