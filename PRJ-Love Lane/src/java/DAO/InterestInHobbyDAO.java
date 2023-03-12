/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBUtils.DBUtils;
import DTO.InterestInHobbyDTO;
import Query.Query;
import java.sql.Connection;
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
public class InterestInHobbyDAO {
    public void insertHobby(String hobbyName,int accountID){
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(Query.INSERT_IIH);
            
            ps.setString(1, hobbyName);
            ps.setInt(2, accountID);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (Exception e) {
        }
    }
//    public ArrayList<InterestInHobbyDTO> getUserListHobby(){
//        ArrayList<InterestInHobbyDTO> hobbyList = new ArrayList<>();
//       
//        try {
//            Connection conn = DBUtils.getConnection();
//            PreparedStatement ps = conn.prepareStatement(Query.LIST_SINGLE_USER_HOBBY);
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()){
//                int id = rs.getInt(1);
//                int 
//                int user_ID = rs.getInt(3);
//                
//                InterestInHobbyDTO userHobby = new InterestInHobbyDTO(id, name, user_ID);
//                hobbyList.add(userHobby);
//                rs.close();
//                ps.close();
//                conn.close();
//                
//            }
//            return hobbyList;
//        } catch (SQLException ex) {
//            Logger.getLogger(InterestInHobbyDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//}
    
    public void deleteHobby(String hobbyName,int accountID){
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(Query.DELETE_IIH);
            
            ps.setString(1, hobbyName);
            ps.setInt(2, accountID);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(photoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    

}
