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

/**
 *
 * @author ACER
 */
public class block {
    public void insertBlock(int account_ID_send,int account_ID_receive){
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(Query.INSERT_BLOCK);
            
            ps.setInt(1, account_ID_send);
            ps.setInt(2, account_ID_receive);
            
            ps.executeUpdate();
            
            conn.close();
            ps.close();
        } catch (Exception e) {
        }
    }
    
    public void deleteBlock(int account_ID_send,int account_ID_receive){
         try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(Query.DELETE_BLOCK);
            
            ps.setInt(1, account_ID_send);
            ps.setInt(2, account_ID_receive);
            
            ps.executeUpdate();
            
            conn.close();
            ps.close();
        } catch (Exception e) {
        }
    }
}
