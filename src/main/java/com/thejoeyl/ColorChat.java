package com.thejoeyl;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class ColorChat implements CommandExecutor {

    public static final Map<Player, Integer> chatkleur = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        Player player = (Player) sender;

        if(command.getName().equalsIgnoreCase("chatcolorreset")) {
            sender.sendMessage(ChatColor.GREEN + "ChatColor back to white");
            chatkleur.remove(player);
            chatkleur.put(player,0);
        }

        if(command.getName().equalsIgnoreCase("chatcolorblue")) {
            sender.sendMessage(ChatColor.GREEN + "ChatColor set to blue");
            chatkleur.remove(player);
            chatkleur.put(player,1);
        }

        if(command.getName().equalsIgnoreCase("chatcolorred")) {
            sender.sendMessage(ChatColor.GREEN + "ChatColor set to red");
            chatkleur.remove(player);
            chatkleur.put(player,2);
        }

        if(command.getName().equalsIgnoreCase("chatcoloryellow")) {
            sender.sendMessage(ChatColor.GREEN + "ChatColor set to yellow");
            chatkleur.remove(player);
            chatkleur.put(player,3);
        }
        return true;
    }
}