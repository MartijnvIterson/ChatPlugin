//package com.thejoeyl;
//
//import org.bukkit.Bukkit;
//import org.bukkit.Location;
//import org.bukkit.entity.Player;
//import org.bukkit.event.EventHandler;
//import org.bukkit.event.Listener;
//import org.bukkit.event.player.AsyncPlayerChatEvent;
//
//public class ChatRadius implements Listener {
//    @EventHandler
//    public void onChat(AsyncPlayerChatEvent e) {
//        Player sender = e.getPlayer();
//        Location sendloc = sender.getLocation();
//        String sendworld = sendloc.getWorld().getName();
//        for(Player recipient : Bukkit.getServer().getOnlinePlayers()) {
//            Location recloc = recipient.getLocation();
//            String recworld = recloc.getWorld().getName();
//            double afstand = recloc.distance(sendloc);
//            if (!sendworld.equals(recworld)) {
//                e.getRecipients().remove(recipient);
//            }
//            if (afstand > 50) {
//                e.getRecipients().remove(recipient);
//            }
//        }
//    }
//}