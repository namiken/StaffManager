package com.github.favreyo.staffmanager.staffutilitys;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.BlockIterator;

public class Compass implements Listener {

    @EventHandler
    public void CompassLeftClickEvent(PlayerInteractEvent event) {
	if (!event.getPlayer().hasPermission("staff.staff.tool")) {
	    return;
	}
	if (event.getPlayer().getItemInHand().getType() == Material.COMPASS) {
	    Player player = event.getPlayer();
	    Block target = getTargetBlock(player);
	    if (target != null) {
		float pitch = player.getLocation().getPitch();
		float yaw = player.getLocation().getYaw();
		Location to = target.getLocation();
		to.setPitch(pitch);
		to.setYaw(yaw);
		player.teleport(to);
		player.sendMessage(ChatColor.GREEN + "[OpMenu] " + ChatColor.YELLOW + "Teleported.");

	    }
	}
    }

    private Block getTargetBlock(Player player) {

	BlockIterator it = new BlockIterator(player, 150);

	while (it.hasNext()) {

	    Block block = it.next();
	    if (block.getType() != Material.AIR) {
		return block;
	    }

	}
	player.sendMessage(ChatColor.GREEN + "[OpMenu] " + ChatColor.RED + "Block Not Found.");
	return null;
    }
    @EventHandler
    public static void compassEventCancel(BlockBreakEvent event) {
	if (event.getPlayer().getItemInHand().getType() == Material.COMPASS) {
	    event.setCancelled(true);
	}
    }
}
