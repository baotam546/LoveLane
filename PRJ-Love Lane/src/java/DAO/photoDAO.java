/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBUtils.DBUtils;
import Query.Query;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Part;

/**
 *
 * @author ACER
 */
public class photoDAO {
    public void insertPhoto(int account_ID, String link, String time_added, String status){
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(Query.INSERT_PHOTO);
            
            ps.setInt(1, account_ID);
            ps.setString(2, link);
            ps.setString(3, time_added);
            ps.setString(4, status);
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
    
    public void getPhoto(Part filePart) throws IOException{
  
        // creating path components for saving the file  
        final String path = "PRJ-Love Lane/upload";   
        final String fileName = getFileName(filePart);  
          
        // declare instances of OutputStream, InputStream, and PrintWriter classes  
        OutputStream otpStream = null;  
        InputStream iptStream = null;  
          
        // try section handles the code for storing file into the specified location  
        try {  
            // initialize instances of OutputStream and InputStream classes  
            otpStream = new FileOutputStream(new File(path + File.separator + fileName));  
            iptStream = filePart.getInputStream();  
  
            int read = 0;  
              
            // initialize bytes array for storing file data  
            final byte[] bytes = new byte[1024];  
              
            // use while loop to read data from the file using iptStream and write into  the desination folder using writer and otpStream  
            while ((read = iptStream.read(bytes)) != -1) {  
                otpStream.write(bytes, 0, read);  
            }  
            System.out.println("New file " + fileName + " created at " + path);  
        }  
        // catch section handles the errors   
        catch (FileNotFoundException fne){  
            System.out.println("You either did not specify a file to upload or are trying to upload a file to a protected or nonexistent location.");  
            System.out.println("<br/> ERROR: " + fne.getMessage());  
        }  
        // finally section will close all the open classes  
        finally {  
            if (otpStream != null) {  
                otpStream.close();  
            }  
            if (iptStream != null) {  
                iptStream.close();  
            }  
        }  
    } 
    
    // getFileName() method to get the file name from the part  
    private String getFileName(final Part part) {  
        // get header(content-disposition) from the part  
        final String partHeader = part.getHeader("content-disposition");  
          
        // code to get file name from the header  
        for (String content : part.getHeader("content-disposition").split(";")) {  
            if (content.trim().startsWith("filename")) {  
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");  
            }  
        }  
        // it will return null when it doesn't get file name in the header   
        return null;  
    }  
    
}
