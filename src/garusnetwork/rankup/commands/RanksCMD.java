/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garusnetwork.rankup.commands;

import garusnetwork.rankup.enums.Ranks;
import garusnetwork.rankup.json.JSONChatColor;
import garusnetwork.rankup.json.JSONChatExtra;
import garusnetwork.rankup.json.JSONChatHoverEventType;
import garusnetwork.rankup.json.JSONChatMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 *
 * @author Jhow
 */
public class RanksCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender cs, Command cmnd, String string, String[] strings) {
        if (cs instanceof Player) {
            Player p = (Player) cs;
            cs.sendMessage("§r         §3Lista de Ranks");
            for (Ranks rank : Ranks.values()) {
                JSONChatMessage message = new JSONChatMessage("", JSONChatColor.YELLOW, null);
                JSONChatExtra pre = new JSONChatExtra("§r §e" + rank.toString());
                pre.setHoverEvent(JSONChatHoverEventType.SHOW_TEXT, " " + "\n §e" + rank.getInfo() + "\n" + " ");
                message.addExtra(pre);

                JSONChatExtra pro = new JSONChatExtra("  §2$ " + rank.getPrice());
                message.addExtra(pro);

                message.sendToPlayer(p);
            }
            cs.sendMessage(" ");
        }
        return true;
    }
}
