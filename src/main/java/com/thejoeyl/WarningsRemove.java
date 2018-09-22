package com.thejoeyl;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WarningsRemove implements CommandExecutor {

    public void valueCheck(Player player) {
        if(Warn.warns.get(player) == null) {
            int count = 0;
            Warn.warns.put(player, count);
        }
    }

    public void decrementValue(Player player) {
        int count = Warn.warns.get(player);
        Warn.warns.put(player, count - 1);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("warningsremove")) {
            if (strings.length == 0) {
                sender.sendMessage(ChatColor.RED + "You must specify a player");
                System.out.println("warningsremove no args");
                return true;
            }

            Player target = Bukkit.getServer().getPlayer(strings[0]);

            if (target == null) {
                sender.sendMessage(ChatColor.RED + "Could not find player " + strings[0]);
                System.out.println("warningsremove args but not correct");
                return true;
            } else {
                valueCheck(target);
                if (Warn.warns.get(target) > 0) {
                    decrementValue(target);
                    sender.sendMessage(ChatColor.GREEN + "You removed one of " + target.getName() + " his warnings");
                    sender.sendMessage(ChatColor.GREEN + target.getName() + " now has " + Warn.warns.get(target) + " warnings!");
                    System.out.println(Warn.warns.get(target));
                } else {
                    System.out.println(Warn.warns.get(target));
                    sender.sendMessage(ChatColor.GREEN + target.getName() + " does not have any warnings!");
                }
            }
        }
        return true;
    }
}
