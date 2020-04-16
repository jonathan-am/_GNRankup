/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garusnetwork.rankup.manager;

import garusnetwork.rankup.interfaces.Interface;
import net.minecraft.server.v1_8_R1.ChatSerializer;
import net.minecraft.server.v1_8_R1.EnumTitleAction;
import net.minecraft.server.v1_8_R1.PacketPlayOutChat;
import net.minecraft.server.v1_8_R1.PacketPlayOutTitle;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

/**
 *
 * @author Jhow
 */
public class TitleManager implements Interface {

    private Player player = null;
    private String title = null;
    private String subtitle = null;
    private String actionbar = null;

    public TitleManager(Player p, String title, String subtitle) {
        this.player = p;
        this.title = title;
        this.subtitle = subtitle;
    }

    public TitleManager(Player p, String actionbar) {
        this.player = p;
        this.actionbar = actionbar;
    }

    @Override
    public void send() {
        // Title or subtitle, text, fade in (ticks), display time (ticks), fade out (ticks).
        if (actionbar == null) {
            PacketPlayOutTitle t = new PacketPlayOutTitle(EnumTitleAction.TITLE, ChatSerializer.a("{\"text\":\"" + title + "\"}"), 10, 20 * 5, 10);
            PacketPlayOutTitle s = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, ChatSerializer.a("{\"text\":\"" + subtitle + "\"}"), 10, 20 * 5, 10);
            ((CraftPlayer) player).getHandle().playerConnection.sendPacket(t);
            ((CraftPlayer) player).getHandle().playerConnection.sendPacket(s);
        } else {
            PacketPlayOutChat a = new PacketPlayOutChat(ChatSerializer.a("{\"text\":\"" + actionbar + "\"}"), (byte) 2);
            ((CraftPlayer) player).getHandle().playerConnection.sendPacket(a);
        }
    }

    @Override
    public void start() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void stop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
