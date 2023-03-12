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
    int id;
    String name;
    int accountID;
    int hobbyID;

    public hobbyDTO() {
    }

    public hobbyDTO(int id, String name, int accountID ) {
        this.id = id;
        this.name = name;
        this.accountID = accountID;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getHobbyID() {
        return hobbyID;
    }

    public void setHobbyID(int hobbyID) {
        this.hobbyID = hobbyID;
    }

    

    
}
