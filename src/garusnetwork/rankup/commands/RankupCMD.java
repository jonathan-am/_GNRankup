/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garusnetwork.rankup.commands;

import garusnetwork.rankup.Main;
import garusnetwork.rankup.db.UserDB;
import garusnetwork.rankup.enums.Ranks;
import garusnetwork.rankup.events.PlayerRankupEvent;
import garusnetwork.rankup.objects.RankedUser;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 *
 * @author Jhow
 */
public class RankupCMD implements CommandExecutor {
    
    @Override
    public boolean onCommand(CommandSender cs, Command cmnd, String string, String[] strings) {
        if (cs instanceof Player) {
            Player player = (Player) cs;
            switch (strings.length) {
                case 0:
                    if (UserDB.users.containsKey(player.getName())) {
                        RankedUser user = UserDB.users.get(player.getName());
                        if (user.getRank().getPosition() > 0) {
                            double rankup_price = Ranks.values()[user.getRank().getPosition() - 1].getPrice();
                            if (Main.instance.economy.has(player, rankup_price)) {
                                Main.instance.economy.withdrawPlayer(player, rankup_price);
                                player.sendMessage("§a[RANK] §eForam removidos §2$ " + rankup_price + " §eda sua carteira.");
                                Bukkit.getPluginManager().callEvent(new PlayerRankupEvent(player));
                            } else {
                                player.sendMessage("§a[RANK] §cVoce nao tem dinhero suficiente para isso!");
                            }
                        } else {
                            player.sendMessage("§a[RANK] §eVoce ja atingiu o rank Maximo!");
                        }
                    } else {
                        player.sendMessage("§a[RANK] §cVoce nao esta cadastrado, tente relogar");
                    }
                    break;
            }
        } else {
            cs.sendMessage("§cVoce nao é um player");
        }
        return true;
    }
}
