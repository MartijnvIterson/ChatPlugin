package com.thejoeyl;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ChatManager extends JavaPlugin implements Listener {

    @EventHandler
    public void badWords(AsyncPlayerChatEvent e) {
        for (String word : e.getMessage().split(" ")) {
            if (getConfig().getStringList("badwords").contains(word)) {
                e.setCancelled(true);
                e.getPlayer().sendMessage(ChatColor.RED + "DONT CURSE!");
            }
        }
    }

    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveConfig();
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new ListenerToStaff(),this);
        getServer().getPluginManager().registerEvents(new ChatColorCheck(),this);
        this.getCommand("warn").setExecutor(new Warn());
        this.getCommand("warnings").setExecutor(new Warnings());
        this.getCommand("warningsremove").setExecutor(new WarningsRemove());
        this.getCommand("warningsclear").setExecutor(new WarningsClear());
        this.getCommand("sthelp").setExecutor(new StaffHelp());
        this.getCommand("hetisstil").setExecutor(new Memes());
        this.getCommand("chatcolorblue").setExecutor(new ColorChat());
        this.getCommand("chatcolorreset").setExecutor(new ColorChat());
        this.getCommand("chatcolorred").setExecutor(new ColorChat());
        this.getCommand("chatcoloryellow").setExecutor(new ColorChat());
    }
}