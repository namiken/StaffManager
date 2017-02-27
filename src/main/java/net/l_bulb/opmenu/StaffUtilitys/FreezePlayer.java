package net.l_bulb.opmenu.StaffUtilitys;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class FreezePlayer implements Listener {

    @EventHandler
    public void freezeEvent(PlayerMoveEvent event, Player player) {
	event.setCancelled(true);

    }

}
