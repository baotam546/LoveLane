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
    String likeID;
    String accountID_send;
    String accountID_receive;

    public likeDTO() {
    }
    
    public likeDTO(String likeID, String accountID_send, String accountID_receive) {
        this.likeID = likeID;
        this.accountID_send = accountID_send;
        this.accountID_receive = accountID_receive;
    }

    public String getLikeID() {
        return likeID;
    }

    public void setLikeID(String likeID) {
        this.likeID = likeID;
    }

    public String getAccountID_send() {
        return accountID_send;
    }

    public void setAccountID_send(String accountID_send) {
        this.accountID_send = accountID_send;
    }

    public String getAccountID_receive() {
        return accountID_receive;
    }

    public void setAccountID_receive(String accountID_receive) {
        this.accountID_receive = accountID_receive;
    }
    
}
