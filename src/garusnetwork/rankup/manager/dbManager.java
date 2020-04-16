/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garusnetwork.rankup.manager;

import garusnetwork.rankup.db.MySQL;
import garusnetwork.rankup.enums.Ranks;
import garusnetwork.rankup.objects.RankedUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jhow
 */
public class dbManager {

    private RankedUser user;
    private String name;

    public dbManager(RankedUser user) {
        this.user = user;
    }

    public dbManager(String name) {
        this.name = name;
    }

    public void set() {
        Connection connection;
        PreparedStatement stmt = null;
        connection = new MySQL().pegaConexao();
        try {
            stmt = connection.prepareStatement("INSERT INTO player_ranks VALUES((?),(?))");
            stmt.setString(1, user.getName());
            stmt.setInt(2, user.getRank().getPosition());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(dbManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            MySQL.fechaConexao(connection, stmt);
        }
    }

    public void update(RankedUser user) {
        Connection connection;
        PreparedStatement stmt = null;
        connection = new MySQL().pegaConexao();
        try {
            stmt = connection.prepareStatement("UPDATE player_ranks SET rank_id = (?) WHERE name = (?)");
            stmt.setInt(1, user.getRank().getPosition());
            stmt.setString(2, user.getName());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(dbManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            MySQL.fechaConexao(connection, stmt);
        }
    }

    public RankedUser getUser() {
        Connection connection;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        connection = new MySQL().pegaConexao();
        try {
            stmt = connection.prepareStatement("SELECT * FROM player_ranks WHERE name = (?)");
            stmt.setString(1, user.getName());
            rs = stmt.executeQuery();
            if (rs.next()) {
                user = new RankedUser().setName(rs.getString("name")).setRank(Ranks.values()[rs.getInt("rank_id")]);
            }
        } catch (SQLException ex) {
            Logger.getLogger(dbManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            MySQL.fechaConexao(connection, stmt, rs);
        }
        return user;
    }
}
