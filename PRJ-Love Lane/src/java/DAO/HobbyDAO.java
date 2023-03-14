/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBUtils.DBUtils;
import DTO.HobbyDTO;
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
public class HobbyDAO {
    
    public ArrayList<HobbyDTO>getHobbyList(){
        ArrayList<HobbyDTO> hobbyList = null;
        try {
            hobbyList = new ArrayList<>();
            
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(Query.LIST_HOBBY);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                
                HobbyDTO hobby = new HobbyDTO(id, name);
                hobbyList.add(hobby);
                rs.close();
                ps.close();
                conn.close();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(HobbyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hobbyList;
    }
}
