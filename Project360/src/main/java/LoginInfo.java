/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author olipo
 */
public class LoginInfo {
    String createInfo() {
        String info = "CREATE TABLE IF NOT EXISTS LOGIN_INFOS "
                + "(ID INTEGER not NULL, "
                + " role VARCHAR(255), "
                + " username VARCHAR(255) not NULL, "
                + " PRIMARY KEY ( ID ));";
        return info;
    }
    String getID(String user){
        String id= "SELECT ID FROM LOGIN_INFOS where username ="+user;
        return id;
    }

}
