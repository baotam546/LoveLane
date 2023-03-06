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
public class blockDTO {
    int blockID;
    int accountID;
    int accountID_block;

    public blockDTO() {
    }

    public blockDTO( int accountID, int accountID_block) {
        
        this.accountID = accountID;
        this.accountID_block = accountID_block;
    }

    public int getBlockID() {
        return blockID;
    }

    public void setBlockID(int blockID) {
        this.blockID = blockID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getAccountID_block() {
        return accountID_block;
    }

    public void setAccountID_block(int accountID_block) {
        this.accountID_block = accountID_block;
    }

    
    
}
