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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class userAccountDAO {

    public userAccountDAO() {
    }
    
    public void insertUser(String firstName, String lastName, String email, String password
    ,int genderID, String location, String DOB, String phone){
        
        
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(Query.Query.INSERT_USER_ACCOUNT);
            
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, email);
            ps.setString(4, password);
            ps.setInt(5,genderID);
            ps.setString(6, location);
            ps.setString(7, DOB);
            ps.setString(8, phone);
            ps.executeUpdate();
            ps.close();
            conn.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    public ArrayList<userAccountDTO> getListUser(){
        ArrayList<userAccountDTO> userList = new ArrayList<>();
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(Query.Query.LIST_USER);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String email = rs.getString(4);
                String password = rs.getString(5);
                String description = rs.getString(6);
                int gender = rs.getInt(7);
                Date dob = rs.getDate(8);
                String phone= rs.getString(9);
                int location = rs.getInt(10);
                
                userAccountDTO ua = new userAccountDTO(id, firstName, lastName, email, password, description, gender, dob, location, phone);
                userList.add(ua);
                rs.close();
                ps.close();
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(userAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
}
    public userAccountDTO login (String username, String pass){
        userAccountDTO userDTO =null;
        String sql="select email from User_Account  "+
                " where email= ? and password = ?";
         try{
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, username);
            ps.setString(2, pass);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                userDTO= new userAccountDTO();
                userDTO.setEmail(username);
                return userDTO;
            }
            
        } catch (SQLException ex) {
            System.out.println("Query Student error!" + ex.getMessage());
        }return null;
    } 
      
    public void updateUser(String firstName, String lastName, String email, String password,String description
    ,int genderID, int location, String DOB, String phone, int id){
         try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(Query.Query.INSERT_USER_ACCOUNT);
            
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, email);
            ps.setString(4, password);
            ps.setString(5, description);
            ps.setInt(6,genderID);
            ps.setInt(7, location);
            ps.setString(8, DOB);
            ps.setString(9, phone);
            ps.setInt(10, id);
            ps.executeUpdate();
            ps.close();
            conn.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void deleteUser(int id){
        try {
            Connection conn =DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(Query.Query.DELETE_USER_ACCOUNT);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            conn.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public userAccountDTO getUserByID(int id){
        ArrayList<userAccountDTO> listUser = new ArrayList<>();
        try {
            String sql="select first_name, last_name, description, gender_ID, DOB, Location_ID, Phone,email,password"+
            "from User_Account where id = ?";
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            String firstName = rs.getString(1);
            String lastName = rs.getString(2);
            String description =rs.getString(3);
            String gender_ID= rs.getString(4);
            Date DOB = rs.getDate(5);
            String location = rs.getString(6);
            String phone= rs.getString(7);
            String email=rs.getString(8);
            String pass=rs.getString(9);
            
            userAccountDTO us= new userAccountDTO(firstName, lastName, email, pass, description, gender_ID, DOB, phone,location);
            listUser.add(us);
            return us;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args) {
            Connection conn = DBUtils.getConnection();
            System.out.println(conn==null);
            
    }
}