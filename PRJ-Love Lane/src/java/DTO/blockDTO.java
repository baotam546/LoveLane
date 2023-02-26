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
    String blockID;
    String accountID;
    String accountID_block;

    public blockDTO() {
    }

    public blockDTO(String blockID, String accountID, String accountID_block) {
        this.blockID = blockID;
        this.accountID = accountID;
        this.accountID_block = accountID_block;
    }

    public String getBlockID() {
        return blockID;
    }

    public void setBlockID(String blockID) {
        this.blockID = blockID;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getAccountID_block() {
        return accountID_block;
    }

    public void setAccountID_block(String accountID_block) {
        this.accountID_block = accountID_block;
    }
    
}
