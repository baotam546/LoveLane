/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBUtils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import DTO.userAccountDTO;

/**
 *
 * @author ACER
 */
public class userAccountDAO {

    public userAccountDAO() {
    }
   
    
    public userAccountDTO login (String username, String pass){
        userAccountDTO userDTO =null;
        String sql="select email from User_Account  "+
                "where email= ? and password = ?";
         try{
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, username);
            ps.setString(2, pass);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                userDTO= new userAccountDTO();
                userDTO.setEmail(username);
            }
        } catch (SQLException ex) {
            System.out.println("Query Student error!" + ex.getMessage());
        }return userDTO;
    } 
    
    
}
