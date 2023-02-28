/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Query;

/**
 *
 * @author ACER
 */
public class Query {
    public static String INSERT_USER_ACCOUNT="insert into User_Account (first_name,last_name,email,password,description, gender_ID,DOB,Location_ID,Phone) value(?,?,?,?,?,?,?,?,?)";
    public static String DELETE_USER_ACCOUNT="delete from User_Account where account_ID= ?";
    public static String UPDATE_USER_ACCOUNT="update User_Account first_name= ?, last_name= ?, email= ?, password= ?, description=?, gender_ID= ?, DOB= ?, Location_ID= ?, Phone= ?"
            + "where id = ?";
    
}
