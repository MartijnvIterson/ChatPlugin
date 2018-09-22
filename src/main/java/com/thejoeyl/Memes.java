package com.thejoeyl;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Memes implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("hetisstil")) {
            sender.sendMessage(ChatColor.GREEN + "aan de overkant");
        }
        return true;
    }
}
