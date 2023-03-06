/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBUtils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author ACER
 */
public class hobbyDAO {
    public void insertHobby(int hobbyID,int accountID){
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareCall()
        } catch (Exception e) {
        }
    }
}
