package com.thejoeyl;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class Warn implements CommandExecutor {

    public void incrementValue(Player player) {
        Integer count = warns.get(player);
        if (count == null) {
            count = 0;
        }
        warns.put(player, count + 1);
    }

    public static final Map<Player, Integer> warns = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        if (command.getName().equalsIgnoreCase("warn")) {
            if (strings.length == 0) {
                System.out.println("warn no args");
                sender.sendMessage(ChatColor.RED + "You must specify a player");
                return true;
            }

            Player target = Bukkit.getServer().getPlayer(strings[0]);

            if (target == null) {
                System.out.println("warn args but not correct");
                sender.sendMessage(ChatColor.RED + "Could not find player " + strings[0]);
                return true;
            } else {
                System.out.println("Warned " + target.getName());
                sender.sendMessage(ChatColor.GREEN + "You have warned " + target.getName());
                incrementValue(target);
                System.out.println(warns.get(target));
                sender.sendMessage(ChatColor.GREEN + target.getName() + " now has " + Warn.warns.get(target) + " warnings!");
            }
        }
        return true;
    }
}