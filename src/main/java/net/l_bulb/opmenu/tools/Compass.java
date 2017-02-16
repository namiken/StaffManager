package net.l_bulb.opmenu.tools;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.BlockIterator;

public class Compass implements Listener{

    @EventHandler
    public void CompassLeftClickEvent(PlayerInteractEvent event) {
	System.out.println("1");
	Player player =event.getPlayer();
	if(player.getItemInHand().getType() == Material.COMPASS) {
	    Block target = getTargetBlock(player);

	    if (target != null) {
		System.out.println(target.getLocation());
	    }
	}

    }

    private Block getTargetBlock(Player player) {

	BlockIterator it = new BlockIterator(player, 150);

	while ( it.hasNext()) {

	    Block block = it.next();
	    if (block.getType() != Material.AIR) {
		return block;
	    }

	}
	player.sendMessage(ChatColor.RED +  "Block Not Found");
	return null;
    }

}
