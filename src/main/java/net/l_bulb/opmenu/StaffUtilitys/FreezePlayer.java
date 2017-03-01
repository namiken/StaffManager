package net.l_bulb.opmenu.StaffUtilitys;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import net.md_5.bungee.api.ChatColor;

public class FreezePlayer implements Listener {

    @EventHandler
    public void freeazeClickEvent(PlayerInteractAtEntityEvent event) {
	if (!(event.getRightClicked() instanceof Player)) {
	    return;
	}

	if (event.getPlayer().getItemInHand().getType() == Material.ICE) {
	    toggleFreaze(event.getPlayer());
	}

    }

    private static void toggleFreaze(Player target) {
	if (!isFreaze(target)) {
	    onFreazeEnable(target);
	} else {
	    onFreazeDisable(target);
	}
    }
    /*
     * FreazeさせたPlayerコレクションにぶち込む部分
     */

    private static HashMap<Player, Location> Freaze = new HashMap<Player, Location>();

    private static void onFreazeEnable(Player target) {
	Freaze.put(target, target.getLocation());
	target.sendMessage(ChatColor.RED + "⚠管理者によって規制されました"); // TODO
							       // movingeventを叩く
    }

    private static void onFreazeDisable(Player target) {
	Freaze.remove(target, target.getLocation()); // TODO
						     // movingeventを叩く
	target.sendMessage(ChatColor.GREEN + "規制が解除されました");
    }

    @EventHandler
    private void movingEvent(PlayerMoveEvent event) {
	if (isFreaze(event.getPlayer())) {

	}

	if (Freaze.containsKey(event.getPlayer().getUniqueId().toString())) {
	    event.getPlayer().sendMessage(ChatColor.RED + "⚠ 動きが規制されています");
	}

    }

    //

    public static boolean isFreaze(Player target) {
	return Freaze.containsKey(target);
    }

}