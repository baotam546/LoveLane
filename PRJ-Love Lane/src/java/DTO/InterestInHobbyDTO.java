/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author ACER
 */
public class InterestInHobbyDTO {
    int id;

    int accountID;
    String hobbyName;
    
    public InterestInHobbyDTO() {
    }

    public InterestInHobbyDTO(int id, int accountID, String hobbyName) {
        this.id = id;
        this.accountID = accountID;
        this.hobbyName = hobbyName;
    }





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getHobbyName() {
        return hobbyName;
    }

    public void setHobbyName(String hobbyName) {
        this.hobbyName = hobbyName;
    }



}
