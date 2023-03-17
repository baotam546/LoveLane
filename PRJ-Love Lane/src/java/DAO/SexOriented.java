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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class SexOriented {

    public static void insertSexOriendted(int accountID, int[] genderID) {

        try {
            Connection conn = DBUtils.getConnection();
            for (int gender : genderID) {
                PreparedStatement ps = conn.prepareCall(Query.INSERT_SO);
                ps.setInt(1, accountID);
                ps.setInt(2, gender);
                ps.executeUpdate();
                ps.close();
            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void updateSexOriented(int accountID, int genderID) {
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareCall(Query.UPDATE_SO);
            ps.setInt(1, genderID);
            ps.setInt(2, genderID);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
