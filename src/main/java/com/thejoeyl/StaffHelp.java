package com.thejoeyl;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StaffHelp implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        Player player = (Player) sender;
        if (command.getName().equalsIgnoreCase("sthelp")) {
            String sthelpme = "";

            for(int i = 0; i < strings.length; i++){
                String arg = strings[i] + " ";
                sthelpme = sthelpme + arg;
            }

            Bukkit.broadcast(ChatColor.BLUE + "[HELP - " + sender.getName() + "] " + ChatColor.RESET + sthelpme, "ChatManager.staff");
        }
        return true;
    }
}
