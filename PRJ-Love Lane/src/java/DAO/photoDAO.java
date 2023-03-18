/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBUtils.DBUtils;
import DTO.photoDTO;
import Query.Query;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
////            ps.setDate(3, new Date());
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
    
    public ArrayList<photoDTO> getUserPhotoList(int id){
        try {
            ArrayList<photoDTO> photoList = new ArrayList<>();
            String sql="SELECT photo_ID, link, time_added, status WHERE user_ID =?";
            
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                int photoID = rs.getInt(1);
                String link = rs.getString(2);
                Date time_added = rs.getDate(3);
//                String status = rs.getString(4);
                
                photoDTO PhotoDTO = new photoDTO(photoID, link, time_added);
                photoList.add(PhotoDTO);
                return photoList;
            }
        } catch (SQLException ex) {
            Logger.getLogger(photoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
}
