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
public class hobbyDTO {
    String name;
    String accountID;
    String hobbyID;

    public hobbyDTO(String name, String accountID, String hobbyID) {
        this.name = name;
        this.accountID = accountID;
        this.hobbyID = hobbyID;
    }

    public hobbyDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getHobbyID() {
        return hobbyID;
    }

    public void setHobbyID(String hobbyID) {
        this.hobbyID = hobbyID;
    }

    
}
