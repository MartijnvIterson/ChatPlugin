package com.thejoeyl;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Warnings implements CommandExecutor {

    public void valueCheck(Player p) {
        if(Warn.warns.get(p) == null) {
            int count = 0;
            Warn.warns.put(p, count);
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("warnings")) {
            if (strings.length == 0) {
                sender.sendMessage(ChatColor.RED + "You must specify a player");
                System.out.println("Warnings no args");
                return true;
            }

            Player target = Bukkit.getServer().getPlayer(strings[0]);

            if (target == null) {
                sender.sendMessage(ChatColor.RED + "Could not find player " + strings[0]);
                System.out.println("Warnings args but not correct");
                return true;
            } else {
                valueCheck(target);
                sender.sendMessage(ChatColor.GREEN + target.getName() + " has " + Warn.warns.get(target) + " warnings!");
                System.out.println(Warn.warns.get(target));
            }
        }
        return true;
    }
}
