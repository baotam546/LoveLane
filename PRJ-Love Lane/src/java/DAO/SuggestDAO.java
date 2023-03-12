/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBUtils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class SuggestDAO {

    public void suggest() {
        int point = 0;

        List<Integer> SO, Hobbies, Blocks, Relation;
        int Location;

        List<Integer> UsersID = listAccountsID();

        List<Integer> otherHobbies, otherRelation;
        int otherLocation;

        for (int currentID : UsersID) {
            System.out.println(currentID);
            SO = listSO(currentID);
            Hobbies = listHobbies(currentID);
            Blocks = listBlocks(currentID);
            Location = getLocation(currentID);
            Relation = listRelation(currentID);

            List<Integer> othersID = listAccountsIDExcept(currentID);
            List<Integer> filteredIDs = FilterByGender(othersID, SO);
            filteredIDs = FilterBlock(filteredIDs, Blocks);

            for (int otherID : filteredIDs) {
                point = 0;
                otherHobbies = listHobbies(otherID);
                point += calculatePoint(Hobbies, otherHobbies);

                otherRelation = listRelation(otherID);
                point += calculatePoint(Relation, otherRelation);

                otherLocation = getLocation(otherID);
                if (Location == otherLocation) {
                    point += 50;
                }

                insertToSuggest(currentID, otherID, point);
            }
        }
    }

    public int calculatePoint(List<Integer> list1, List<Integer> list2) {
        int point = 0;
        for (int o1 : list1) {
            for (int o2 : list2) {
                if (o1 == o2) {
                    point += 10;
                }
            }
        }
        return point;
    }

    public boolean insertToSuggest(int userID, int otherID, int point) {
        String sql_test = "SELECT * FROM Suggest"
                + " WHERE account_id_sent = ? and account_id_received = ?";
        String sqlInsert = "INSERT INTO Suggest( point, account_id_sent, account_id_received ) "
                + " VALUES (?, ?, ?)";
        String sqlUpdate = "UPDATE Suggest\n"
                + "SET point = ?\n"
                + "WHERE account_id_sent = ? and account_id_received = ?";
        try {

            Connection conn = DBUtils.getConnection();
            PreparedStatement ps1 = conn.prepareStatement(sql_test);

            ps1.setInt(1, userID);
            ps1.setInt(2, otherID);

            ResultSet rs = ps1.executeQuery();
            PreparedStatement ps = null;
            if (rs.next()) {
                ps = conn.prepareStatement(sqlUpdate);

            } else {
                ps = conn.prepareStatement(sqlInsert);
            }
            ps.setInt(1, point);
            ps.setInt(2, userID );
            ps.setInt(3, otherID);

            ps.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.out.println("Insert Student error!" + ex.getMessage());
        }
        return false;
    }

    public List<Integer> FilterByGender(List<Integer> usersID, List<Integer> SO) {
        List<Integer> gender = listAccountByGender(SO);
        usersID.retainAll(gender);
        return usersID;
    }

    public List<Integer> FilterBlock(List<Integer> usersID, List<Integer> blocks) {
        usersID.removeAll(blocks);
        return usersID;
    }

    public List<Integer> listAccountByGender(List<Integer> genderIDs) {
        List<Integer> UsersID = new ArrayList<>();
        String SQL = null;
        if(genderIDs.isEmpty()){
            return listAccountsID();
        } else{
            SQL= "select account_ID\n"
                + "from dbo.User_Account\n"
                + "where (gender_ID = ?";
        }
        for (int i = 1; i < genderIDs.size(); i++) {
            SQL += " or gender_ID = ?";
        }
        SQL += ")";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setInt(1, genderIDs.get(0));
            for (int i = 1; i < genderIDs.size(); i++) {
                int index = i + 1;
                ps.setInt(index, genderIDs.get(i));
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UsersID.add(rs.getInt(1));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Query Student error!" + ex.getMessage());
        }
        return UsersID;
    }

    public List<Integer> listAccountsID() {
        List<Integer> UsersID = new ArrayList<>();
        String SQL = "select account_id from User_Account";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UsersID.add(rs.getInt(1));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Query Student error!" + ex.getMessage());
        }
        return UsersID;
    }

    public List<Integer> listAccountsIDExcept(int id) {
        List<Integer> UsersID = new ArrayList<>();
        String SQL = "select account_id from User_Account\n"
                + "except \n"
                + "select account_id from User_Account where account_id = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UsersID.add(rs.getInt(1));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Query Student error!" + ex.getMessage());
        }
        return UsersID;
    }

    public List<Integer> listSO(int id) {
        List<Integer> UserSO = new ArrayList<>();
        String S_OSQL = "select s.gender_ID\n"
                + "from dbo.User_Account u inner join dbo.Sex_Oriented s\n"
                + "on u.account_ID=s.account_ID\n"
                + "where u.account_ID = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(S_OSQL);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UserSO.add(rs.getInt(1));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Query Student error!" + ex.getMessage());
        }
        return UserSO;
    }

    public List<Integer> listHobbies(int id) {
        List<Integer> UserHobbies = new ArrayList<>();
        String HobbySQL = "select ii.hobby_ID\n"
                + "from dbo.User_Account u inner join dbo.Interest_in_Hobby ii\n"
                + "						on u.account_ID=ii.account_ID\n"
                + "where u.account_ID = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(HobbySQL);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UserHobbies.add(rs.getInt(1));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Query Student error!" + ex.getMessage());
        }
        return UserHobbies;
    }

    public List<Integer> listBlocks(int id) {
        List<Integer> UserBlocks = new ArrayList<>();
        String BlockSQL = "select b.account_ID_block\n"
                + "from dbo.User_Account u inner join dbo.[block] b\n"
                + "						on u.account_ID=b.account_ID\n"
                + "where u.account_ID = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(BlockSQL);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UserBlocks.add(rs.getInt(1));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Query Student error!" + ex.getMessage());
        }
        return UserBlocks;
    }

    public List<Integer> listRelation(int id) {
        List<Integer> UserRelation = new ArrayList<>();
        String RelationSQL = "select ir.relation_ID\n"
                + "from dbo.User_Account u inner join dbo.Interest_in_Relationship ir\n"
                + "						on u.account_ID=ir.account_ID\n"
                + "where u.account_ID = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(RelationSQL);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UserRelation.add(rs.getInt(1));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Query Student error!" + ex.getMessage());
        }
        return UserRelation;
    }

    public int getLocation(int id) {
        String BlockSQL = "select Location_ID\n"
                + "from dbo.User_Account\n"
                + "where account_ID = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(BlockSQL);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Query Student error!" + ex.getMessage());
        }
        return 0;
    }

    public static void main(String[] args) {
        SuggestDAO dao = new SuggestDAO();
        System.out.println(dao.listAccountsID());
        System.out.println(dao.listSO(3));
        System.out.println(dao.listHobbies(3));
        System.out.println(dao.listRelation(3));
        System.out.println(dao.listBlocks(3));
        System.out.println(dao.FilterByGender(dao.listAccountsIDExcept(5), dao.listSO(3)));
        System.out.println(dao.FilterBlock(dao.listAccountsIDExcept(3), dao.listBlocks(3)));
        System.out.println(dao.listAccountsIDExcept(3));
        System.out.println(dao.insertToSuggest(3, 5, 50));
        dao.suggest();
    }
}
