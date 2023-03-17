/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBUtils.DBUtils;
import DTO.HobbyDTO;
import DTO.RelationDTO;
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
public class RelationDAO {

    public ArrayList<RelationDTO> getRelationList() {
        ArrayList<RelationDTO> relationList = null;
        try {
            relationList = new ArrayList<>();

            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(Query.LIST_RELATION);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);

                RelationDTO relation = new RelationDTO(id, name);
                relationList.add(relation);

            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(RelationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return relationList;
    }

    public String[] getRelationListByIDs(int[] id) {
        String[] relationList = new String[id.length];
        try {

            Connection conn = DBUtils.getConnection();
            for (int i=0;i<id.length;i++) {
                PreparedStatement ps = conn.prepareStatement(Query.LIST_RELATION_ID);
                ps.setInt(1, id[i]);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String name = rs.getString(1);

                    relationList[i]=name;

                }
                rs.close();
                ps.close();
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(RelationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return relationList;
    }

    public static void main(String[] args) {
        RelationDAO DAO = new RelationDAO();
        ArrayList<RelationDTO> hobbyList = DAO.getRelationList();
        for (RelationDTO hobby : hobbyList) {
            System.out.println(hobby.getName());
        }
        int [] h = new int[2];
        h[0]=4; h[1]=10;
        for(String l : DAO.getRelationListByIDs(h)){
            System.out.println(l);
        }

    }
}
