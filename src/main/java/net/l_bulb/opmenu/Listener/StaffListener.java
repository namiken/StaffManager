package net.l_bulb.opmenu.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;


public class StaffListener implements Listener {

    @EventHandler
    public void FoodLevel(FoodLevelChangeEvent event) {
	event.setCancelled(true);
    }
    @EventHandler
    public void Damage(EntityDamageByEntityEvent event) {
	event.setCancelled(true);
	String  player = event.getEventName();
	
    }
}
