/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBUtils.DBUtils;
import Query.Query;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class photoDAO {
    public void insertPhoto(int account_ID, String link){
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(Query.INSERT_PHOTO);
            
            ps.setInt(1, account_ID);
            ps.setString(2, link);
            ps.executeUpdate();
            
            conn.close();
            ps.close();
        } catch (Exception e) {
        }
    }
    
    public void deletePhoto(String link){
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(Query.DELETE_PHOTO);
            
            ps.setString(1,link);
            conn.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(photoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void updatePhoto(String time_added, String status, String link){
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(Query.UPDATE_PHOTO);
            
            ps.setString(1, time_added);
            ps.setString(2, status);
            ps.setString(3, link);
            
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(photoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
}
