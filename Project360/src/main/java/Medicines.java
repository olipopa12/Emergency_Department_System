/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author olipo
 */
public class Medicines {
    String createMedicine() {
        String med = "CREATE TABLE IF NOT EXISTS MEDICINES "
                + "(medID INTEGER not NULL, "
                + " name VARCHAR(255), "
                + " kindof VARCHAR(255), "
                + " substance INTEGER, "
                + " PRIMARY KEY ( medID ));";
        return med;
    }
}
