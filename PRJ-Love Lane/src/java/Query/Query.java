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
    public static String UPDATE_USER_ACCOUNT="update User_Account SET first_name= ?, last_name= ?, email= ?, password= ?, description=?, gender_ID= ?, DOB= ?, Location_ID= ?, Phone= ?"
                                           + "where id = ?";
    public static String LIST_USER = "select account_ID,first_name,last_name,email,password,description,gender_ID, DOB, Phone, Location\n" +
                                     "from User_Account" ;
    // Relationship
    public static String INSERT_RELATIONSHIP="insert into Interest_in_Relationship (account_ID,relation_ID) VALUE (?,?)";
    public static String UPDATE_RELATIONSHIP="UPDATE Interest_in_Relationship SET relation_ID = ? WHERE account_ID = ?";
    public static String DELETE_RELATIONSHIP="delete from Interest_in_Relationship where accountID= ?";
   
    // Interest_in_Hobby
    public static String INSERT_IIH = "INSERT INTO Interest_in_Hobby (hobby_name,account_ID) value (?,?)";
    public static String DELETE_IIH = "DELETE FROM Interest_in_Hobby WHERE hobby_name =?,account_ID=?";
    
    public static String LIST_SINGLE_USER_HOBBY = "SELECT ioh.iih_ID, h.name, ioh.account_ID FROM hobby h , Interest_in_Hobby ioh WHERE h.hobby_ID = ioh.hobby_ID AND ioh.account_ID = ?";
    
    // Sex Oriented
    public static String INSERT_SO = "INSERT into Sex_Oriented (account_ID,gender_ID) value(?,?)";
    public static String UPDATE_SO = "UPDATE Sex_Oriented SET gender_ID = ? WHERE account_ID = ?";
    
    // Like 
    public static String INSERT_LIKE = "INSERT into like (account_ID_send,account_ID_received) value(?,?)";
    public static String DELETE_LIKE = "DELETE FROM like WHERE account_ID_send =?, account_ID_receive =?";
    
    // Block 
    public static String INSERT_BLOCK = "INSERT into block (account_ID_send,account_ID_received) value(?,?)";
    public static String DELETE_BLOCK = "DELETE FROM block WHERE account_ID_send =?, account_ID_receive =?";
    
    // Photo
    public static String INSERT_PHOTO = "INSERT INTO User_Photo(account_ID, link, time_added, status) VALUE(?,?,?,?)";
    public static String DELETE_PHOTO = "DELETE FROM User_Photo where link = ?";
    public static String UPDATE_PHOTO = "UPDATE User_Photo SET time_added = ?, status = ? WHERE link = ?";
    
}
