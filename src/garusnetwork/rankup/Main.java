/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garusnetwork.rankup;

import garusnetwork.rankup.commands.RanksCMD;
import garusnetwork.rankup.commands.RankupCMD;
import garusnetwork.rankup.db.MySQL;
import garusnetwork.rankup.db.UserDB;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

/**
 *
 * @author Jhow
 */
public class Main extends JavaPlugin {

    public static Main instance = null;
    public static String prefix = "§e§l[GN] ";
    //##
    //==== MYSQL
    public static String Senha = null;//Senha MySQL
    public static String Usuario = null;//Usuario MySQL
    public static String Banco = null;//Base de Dados MySQL
    public static String Host = null;//Ip MySQL
    public static String Port = null;//Ip MySQL
    public static MySQL mysql = null;//Return MYSQL
    //==================
    //##
    public static int first = 23;
    public Economy economy = null;

    @Override
    public void onEnable() {
        super.onEnable(); //To change body of generated methods, choose Tools | Templates.
        instance = this;
        Bukkit.getConsoleSender().sendMessage("§a[GN] §eCarregando arquivos e configuraçoes...");
        saveDefaultConfig();
        Senha = getConfig().getString("MySQL.Senha");
        Usuario = getConfig().getString("MySQL.Usuario");
        Banco = getConfig().getString("MySQL.Banco");
        Host = getConfig().getString("MySQL.Ip");
        Port = getConfig().getString("MySQL.Porta");
        new MySQL().initBanco();
        setupEconomy();
        getCommand("rankup").setExecutor(new RankupCMD());
        getCommand("ranks").setExecutor(new RanksCMD());
        Bukkit.getPluginManager().registerEvents(new Listener(), this);
        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.getConsoleSender().sendMessage("§a[RANKUP] §eCarregando usuarios ao Cache...");
                new UserDB().loadFromSQL();
                Bukkit.getConsoleSender().sendMessage("§a[RANKUP] §eUsuarios carregados ao Cache!");
            }
        }.runTaskLater(this, 20 * 10);
    }

    @Override
    public void onDisable() {
        super.onDisable(); //To change body of generated methods, choose Tools | Templates.
        HandlerList.unregisterAll();
        Bukkit.getConsoleSender().sendMessage("§a[GN] §eDescarregando usuarios ao banco...");
        new UserDB().loadToSQL();
        Bukkit.getConsoleSender().sendMessage("§a[GN] §eUsuarios descarregados com sucesso!");
    }

    private boolean setupEconomy() {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }

        return (economy != null);
    }

}
