// Decompiled with: FernFlower
// Class Version: 8
package io.github.swagree.refixPC;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public static Main plugin;

    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("§7[ReFixPC] §b作者§fSwagRee §cQQ:§f352208610");
        Bukkit.getPluginManager().registerEvents(new ListenerPC(), this);
        plugin = this;
    }

    public void onDisable() {
    }
}
 