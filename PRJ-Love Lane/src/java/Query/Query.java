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
    // User Account
    public static String INSERT_USER_ACCOUNT="insert into User_Account (first_name,last_name,email,password,description, gender_ID,DOB,Location_ID,Phone) value(?,?,?,?,?,?,?,?,?)";
    public static String DELETE_USER_ACCOUNT="delete from User_Account where account_ID= ?";
    public static String UPDATE_USER_ACCOUNT="update User_Account first_name= ?, last_name= ?, email= ?, password= ?, description=?, gender_ID= ?, DOB= ?, Location_ID= ?, Phone= ?"
                                           + "where id = ?";
    public static String LIST_USER = "select account_ID,first_name,last_name,email,password,description,gender_ID, DOB, Phone, Location\n" +
                                     "from User_Account" ;
    // Relationship
    public static String INSERT_RELATIONSHIP="insert into Interest_in_Relationship (account_ID,relation_ID) VALUE (?,?)";
    public static String UPDATE_RELATIONSHIP="UPDATE Interest_in_Relationship relation_ID = ? WHERE account_ID = ?";
    public static String DELETE_RELATIONSHIP="delete from Relationship where accountID= ?";
    // Hobby
    public static String INSERT_HOBBY = "";
    // Sex Oriented
    public static String INSERT_SO = "INSERT into Sex_Oriented (account_ID,gender_ID) value(?,?)";
    public static String UPDATE_SO = "UPDATE Sex_Oriented gender_ID = ? WHERE account_ID = ?";
    // Like 
    public static String INSERT_LIKE = "INSERT into like (account_ID_send,account_ID_received,grade) value(?,?,?)";
    
    
}
