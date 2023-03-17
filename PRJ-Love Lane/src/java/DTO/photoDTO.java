/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 *
 * @author ACER
 */
public class photoDTO {
    int photoID;
    int accountID;
    String link;
    Date time_added;

    public photoDTO() {
    }

    public photoDTO( int accountID, String link, Date time_added) {
        
        this.accountID = accountID;
        this.link = link;
        this.time_added = time_added;
    }

    public int getPhotoID() {
        return photoID;
    }

    public void setPhotoID(int photoID) {
        this.photoID = photoID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Date getTime_added() {
        return time_added;
    }

    public void setTime_added(Date time_added) {
        this.time_added = time_added;
    }
    
}
