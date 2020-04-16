/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garusnetwork.rankup.events;

import garusnetwork.rankup.db.UserDB;
import garusnetwork.rankup.enums.Ranks;
import garusnetwork.rankup.objects.RankedUser;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 *
 * @author Jhow
 */
public class PlayerRankupEvent extends Event {

    private final Player player;

    public Ranks getNextRank() {
        return UserDB.users.get(player.getName()).getRank().getPosition() > 0 ? Ranks.values()[UserDB.users.get(player.getName()).getRank().getPosition() - 1] : UserDB.users.get(player.getName()).getRank();
    }

    public RankedUser getUser() {
        return UserDB.users.get(player.getName());
    }

    public Player getPlayer() {
        return player;
    }

    public PlayerRankupEvent(Player player) {
        this.player = player;
    }

    private static final HandlerList handlers = new HandlerList();

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
