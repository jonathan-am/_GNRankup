/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garusnetwork.rankup;

import garusnetwork.rankup.db.UserDB;
import garusnetwork.rankup.enums.Ranks;
import garusnetwork.rankup.events.PlayerRankupEvent;
import garusnetwork.rankup.manager.TitleManager;
import garusnetwork.rankup.manager.dbManager;
import garusnetwork.rankup.objects.RankedUser;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 *
 * @author Jhow
 */
public class Listener implements org.bukkit.event.Listener {

    @EventHandler
    public void onEvent(PlayerJoinEvent e) {
        Player player = (Player) e.getPlayer();
        UserDB db = new UserDB();
        if (!UserDB.users.containsKey(player.getName())) {
            RankedUser user = new RankedUser().setName(player.getName()).setRank(Ranks.values()[Main.first]);
            new dbManager(user).set();
            UserDB.users.put(player.getName(), user);
        }
    }

    @EventHandler
    public void onRankup(PlayerRankupEvent e) {
        RankedUser user = e.getUser();
        UserDB.users.get(e.getPlayer().getName()).setRank(e.getNextRank());
        //##
        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.LEVEL_UP, 10L, 10L);
        new TitleManager(e.getPlayer(), "  §6§lParabens  ", "§aVoce evoluiu para o rank §b" + user.getRank()).send();
        Bukkit.getOnlinePlayers().forEach((player) -> {
            new TitleManager(player, "§eO Jogador §f" + user.getName() + " §eacaba de evoluir para §b" + user.getRank().toString()).send();
        });
    }

}
