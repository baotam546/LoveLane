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
public class likeDTO {
    int likeID;
    int accountID_send;
    int accountID_receive;

    public likeDTO() {
    }

    public likeDTO( int accountID_send, int accountID_receive) {
        
        this.accountID_send = accountID_send;
        this.accountID_receive = accountID_receive;
    }

    public int getLikeID() {
        return likeID;
    }

    public void setLikeID(int likeID) {
        this.likeID = likeID;
    }

    public int getAccountID_send() {
        return accountID_send;
    }

    public void setAccountID_send(int accountID_send) {
        this.accountID_send = accountID_send;
    }

    public int getAccountID_receive() {
        return accountID_receive;
    }

    public void setAccountID_receive(int accountID_receive) {
        this.accountID_receive = accountID_receive;
    }
    
    
    
}
