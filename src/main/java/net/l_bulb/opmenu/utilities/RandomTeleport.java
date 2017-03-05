package net.l_bulb.opmenu.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class RandomTeleport implements Listener {
  
  @EventHandler
  public void randomTeleport(PlayerInteractEvent event) {
    Player player = event.getPlayer();
    if (!event.getPlayer().hasPermission("staff.tool")) {
      
    }
    if (player.getItemInHand().getType() == Material.RECORD_3) {
      if (Bukkit.getOnlinePlayers().size() <= 1) {
        player.sendMessage(ChatColor.RED + "Player is not found");
      }
      Random random = new Random();
      List<Player> players = new ArrayList<>(Bukkit.getOnlinePlayers());
      for (Player online : Bukkit.getServer().getOnlinePlayers()) {
        if (Objects.equals(online, player)) {
          continue;
        }
        int index = random.nextInt(players.size());
        Player target = (Player) players.get(index);
        player.teleport(target);
        player.sendMessage(ChatColor.GREEN + "Telepored " + target.getDisplayName());
        break;
      }
      
    }
  }
}
