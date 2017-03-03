package com.github.favreyo.staffmanager.staffutilitys;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import com.github.favreyo.staffmanager.listener.MenuListener;

public class StaffGUI implements Listener {
    @EventHandler
    public void randomTeleport(PlayerInteractEvent event) {
	Player player = event.getPlayer();
	if (!event.getPlayer().hasPermission("staff.tool")) {
	    return;
	}
	if (player.getItemInHand().getType() == Material.INK_SACK) {
	    MenuListener.MenuCreate(player);
	}
    }

}
