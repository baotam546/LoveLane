/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 *
 * @author ACER
 */
public class userAccountDTO {
    
    int account_ID;
    String first_name;
    String last_name;
    String email;
    String password;
    String description;
    int gender_ID;
    Date DOB;
    String location;


    public userAccountDTO() {
    }

    public userAccountDTO(int account_ID, String first_name, String last_name, String email, String password, String description, int gender_ID, Date DOB, String location) {
        this.account_ID = account_ID;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.description = description;
        this.gender_ID = gender_ID;
        this.DOB = DOB;
        this.location = location;

    }

    public userAccountDTO(String firstName, String lastName, String email, String pass, String description, String gender_ID, Date DOB, String phone, String location) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

    public int getAccount_ID() {
        return account_ID;
    }

    public void setAccount_ID(int account_ID) {
        this.account_ID = account_ID;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

 
    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public int getGender_ID() {
        return gender_ID;
    }

    public void setGender_ID(int gender_ID) {
        this.gender_ID = gender_ID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation_ID(String location_ID) {
        this.location = location;
    }

  

    

   
}
