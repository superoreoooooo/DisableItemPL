package org.oreoprojekt.disableitem;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.oreoprojekt.disableitem.event.DIEvent;

public final class DIMain extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Disable Item Plugin on");
        getServer().getPluginManager().registerEvents(new DIEvent(), this);
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "Disable Item Plugin off!");
    }
}
