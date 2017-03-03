package net.l_bulb.opmenu.utilities;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class HealthCheck implements Listener {
  
  @EventHandler
  public void shearsClickEvent(PlayerInteractEntityEvent event) {
    if (!event.getPlayer().hasPermission("staff.tool")) {
      return;
    }
    if (!(event.getRightClicked() instanceof Player)) {
      return;
    }
    
    if (event.getPlayer().getItemInHand().getType() == Material.SHEARS) {
      Player target = (Player) event.getRightClicked();
      event.getPlayer().sendMessage(ChatColor.GREEN + "[OpMenu] " + ChatColor.RED
          + target.getDisplayName() + " has " + target.getHealth() + "Health.");
    }
    
  }
}
