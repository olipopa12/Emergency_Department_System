/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author olipo
 */
public class Nurses {
    String createNurse() {
        String nurse = "CREATE TABLE IF NOT EXISTS NURSES "
                + "(nurseID INTEGER not NULL, "
                + " name VARCHAR(255), "
                + " phone INTEGER, "
                + " PRIMARY KEY ( nurseID ));";
        return nurse;
    }
}
