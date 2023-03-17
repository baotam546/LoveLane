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
public class InterestInRelationshipDAO {

    public void insertRelationship(int userID, String[] relationName) {
        try {
            Connection conn = DBUtils.getConnection();
            for (String relation : relationName) {
                PreparedStatement ps = conn.prepareStatement(Query.INSERT_IIR);

                ps.setInt(1, userID);
                ps.setString(2, relation);
                ps.executeUpdate();
                ps.close();
            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateRelationship(String relationName, int userID) {

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(Query.UPDATE_IIR);

            ps.setString(1, relationName);
            ps.setInt(2, userID);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deleteRelationship(int userID, String relationName) {
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(Query.DELETE_IIR);
            ps.setInt(1, userID);
            ps.setString(2, relationName);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
