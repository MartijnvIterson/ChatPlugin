package com.thejoeyl;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class    ChatColorCheck implements Listener {

    @EventHandler
    public void onChat (AsyncPlayerChatEvent e) {
        Player eplayer = e.getPlayer();

        if (ColorChat.chatkleur.isEmpty()) {
            ColorChat.chatkleur.put(eplayer,0);
        }

        int chatkleur = ColorChat.chatkleur.get(e.getPlayer());

        if(chatkleur == 0) {
            e.getFormat();
            e.setFormat(ChatColor.WHITE + "<" + eplayer.getName() + "> " + e.getMessage());
        }

        if(chatkleur == 1) {
            e.getFormat();
            e.setFormat(ChatColor.WHITE + "<" + eplayer.getName() + "> " + ChatColor.BLUE + e.getMessage());
        }

        if(chatkleur == 2) {
            e.getFormat();
            e.setFormat(ChatColor.WHITE + "<" + eplayer.getName() + "> " + ChatColor.RED + e.getMessage());
        }

        if(chatkleur == 3) {
            e.getFormat();
            e.setFormat(ChatColor.WHITE + "<" + eplayer.getName() + "> " + ChatColor.YELLOW + e.getMessage());
        }
    }
}
