package com.thejoeyl;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WarningsClear implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("warningsclear")) {
            if (strings.length == 0) {
                sender.sendMessage(ChatColor.RED + "You must specify a player");
                System.out.println("warningsclear no args");
                return true;
            }

            Player target = Bukkit.getServer().getPlayer(strings[0]);

            if (target == null) {
                sender.sendMessage(ChatColor.RED + "Could not find player " + strings[0]);
                System.out.println("warningsclear args but not correct");
                return true;
            } else {
                Warn.warns.put(target, 0);
                sender.sendMessage(ChatColor.GREEN + "You cleared " + target.getName() + " his warnings");
                sender.sendMessage(ChatColor.GREEN + target.getName() + " now has " + Warn.warns.get(target) + " warnings!");
                System.out.println(Warn.warns.get(target));
            }
        }
        return true;
    }
}
