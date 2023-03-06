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
public class sexOrientedDTO {
    int soID;
    int accountID;
    int genderID;

    public sexOrientedDTO() {
    }

    public sexOrientedDTO( int accountID, int genderID) {
        
        this.accountID = accountID;
        this.genderID = genderID;
    }

    public int getSoID() {
        return soID;
    }

    public void setSoID(int soID) {
        this.soID = soID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getGenderID() {
        return genderID;
    }

    public void setGenderID(int genderID) {
        this.genderID = genderID;
    }

   

    
}
