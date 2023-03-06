/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBUtils.DBUtils;
import Query.Query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class relationshipDAO {
    public void insertRelationship(int userID, int relationID){
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(Query.INSERT_RELATIONSHIP);
            
            ps.setInt(1, userID);
            ps.setInt(2, relationID);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    
    public void updateRelationship(int relationID, int userID){
        
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(Query.UPDATE_RELATIONSHIP);
            
            ps.setInt(1, relationID);
            ps.setInt(2, userID);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void deleteRelationship(int userID){
        try {
            Connection conn =DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(Query.DELETE_RELATIONSHIP);
            ps.setInt(1, userID);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
