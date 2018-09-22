package com.thejoeyl;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ListenerToStaff implements Listener {
    String staffMessage = "Null";

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        String chat = e.getMessage();
        if (e.getMessage().toLowerCase().contains("staff")) {
            staffMessage = e.getMessage().toLowerCase().replace("staff",
                    ChatColor.GREEN + "staff" + ChatColor.RESET);
            e.setCancelled(true);
            Bukkit.broadcast("<" + player.getName() + "> " + staffMessage, "ChatManager.staff");
            Bukkit.broadcast("<" + player.getName() + "> " + chat, "ChatManager.default");
        }
    }
}