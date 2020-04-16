/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garusnetwork.rankup.db;

import garusnetwork.rankup.enums.Ranks;
import garusnetwork.rankup.manager.dbManager;
import garusnetwork.rankup.objects.RankedUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jhow
 */
public class UserDB {

    public static HashMap<String, RankedUser> users = new HashMap<>();

    public UserDB loadFromSQL() {
        Connection connection;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        connection = new MySQL().pegaConexao();
        try {
            stmt = connection.prepareStatement("SELECT * FROM player_ranks");
            rs = stmt.executeQuery();
            while (rs.next()) {
                users.put(rs.getString("name"), new RankedUser().setName(rs.getString("name")).setRank(Ranks.values()[rs.getInt("rank_id")]));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            MySQL.fechaConexao(connection, stmt, rs);
        }
        return this;
    }

    public void loadToSQL() {
        users.values().forEach((user) -> {
            new dbManager(user.getName()).update(user);
        });
    }
}
