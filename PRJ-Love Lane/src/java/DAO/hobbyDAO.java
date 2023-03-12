/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBUtils.DBUtils;
import DTO.hobbyDTO;
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
public class hobbyDAO {
    public void insertHobby(int hobbyID,int accountID){
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(Query.INSERT_HOBBY);
            
            ps.setInt(1, hobbyID);
            ps.setInt(2, accountID);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (Exception e) {
        }
    }
    public ArrayList<hobbyDTO> getUserListHobby(){
        ArrayList<hobbyDTO> hobbyList = new ArrayList<>();
       
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(Query.LIST_SINGLE_USER_HOBBY);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int user_ID = rs.getInt(3);
                
                hobbyDTO userHobby = new hobbyDTO(id, name, user_ID);
                hobbyList.add(userHobby);
                rs.close();
                ps.close();
                conn.close();
                
            }
            return hobbyList;
        } catch (SQLException ex) {
            Logger.getLogger(hobbyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
}
    public void deleteHobby(int hobbyID,int accountID){
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(Query.INSERT_HOBBY);
            
            ps.setInt(1, hobbyID);
            ps.setInt(2, accountID);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(photoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    

}
