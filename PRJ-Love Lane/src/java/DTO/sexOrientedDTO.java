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
    String soID;
    String accountID;
    String genderID;

    public sexOrientedDTO(String soID, String accountID, String genderID) {
        this.soID = soID;
        this.accountID = accountID;
        this.genderID = genderID;
    }

    public sexOrientedDTO() {
    }

    public String getSoID() {
        return soID;
    }

    public void setSoID(String soID) {
        this.soID = soID;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getGenderID() {
        return genderID;
    }

    public void setGenderID(String genderID) {
        this.genderID = genderID;
    }

    
}
