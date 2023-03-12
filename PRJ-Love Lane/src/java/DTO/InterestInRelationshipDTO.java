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
public class InterestInRelationshipDTO {
    int relationshipID;
    int accountID;
    String relationName;

    public InterestInRelationshipDTO() {
    }

    public InterestInRelationshipDTO(int relationshipID, int accountID, String relationName) {
        this.relationshipID = relationshipID;
        this.accountID = accountID;
        this.relationName = relationName;
    }

   

    public int getRelationshipID() {
        return relationshipID;
    }

    public void setRelationshipID(int relationshipID) {
        this.relationshipID = relationshipID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getRelationName() {
        return relationName;
    }

    public void setRelationName(String relationName) {
        this.relationName = relationName;
    }

    
}
