/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBUtils.DBUtils;
import DTO.LocationDTO;
import Query.Query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;

/**
 *
 * @author ACER
 */
public class LocationDAO {
    public ArrayList<LocationDTO>getLocationList(){
        ArrayList<LocationDTO> locationList = null;
        try {
            locationList= new ArrayList<>();
            
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(Query.LIST_LOCATION);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                
                
                LocationDTO location = new LocationDTO(id, name);
                locationList.add(location);
            }
                rs.close();
                ps.close();
                conn.close();
        } catch (SQLException ex) {
            
        }
        return locationList;
}
}
