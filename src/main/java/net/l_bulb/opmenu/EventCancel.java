package net.l_bulb.opmenu;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

import net.l_bulb.opmenu.Commands.StaffCommand;

public class EventCancel implements Listener {

    @EventHandler
    public void dropEvent(PlayerDropItemEvent event) {
	if (StaffCommand.isInStaffMode(event.getPlayer())) {
	    event.setCancelled(true);
	}
    }

    @EventHandler
    public void inventoryclickEvent(InventoryClickEvent event) {
	Player player = (Player) event.getWhoClicked();
	if (StaffCommand.isInStaffMode(player)) {
	    event.setCancelled(true);
	}
    }

    @EventHandler
    public void itemsetEvent(PlayerInteractEvent event) {
	if (StaffCommand.isInStaffMode(event.getPlayer())) {
	    event.setCancelled(true);
	}
    }

    @EventHandler
    public void foodEvent(FoodLevelChangeEvent event) {
	Player player = (Player) event.getEntity();
	if (StaffCommand.isInStaffMode(player)) {
	    event.setCancelled(true);
	}
    }

    @EventHandler
    public void onDamageEvent(EntityDamageByEntityEvent event) {
	EntityType type = event.getEntityType();
	if (EntityType.PLAYER != type) {
	    return;
	}

	Player me = (Player) event.getEntity();
	if (StaffCommand.isInStaffMode(me)) {
	    event.setCancelled(true);
	}
    }

    @EventHandler
    public void breakEvent(BlockBreakEvent event) {
	if (StaffCommand.isInStaffMode(event.getPlayer())) {
	    event.setCancelled(true);
	}
    }

    @EventHandler
    public void itemPickUp(PlayerPickupItemEvent event) {
	if (StaffCommand.isInStaffMode(event.getPlayer())) {
	    event.setCancelled(true);
	}
    }
}