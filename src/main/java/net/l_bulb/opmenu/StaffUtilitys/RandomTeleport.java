package net.l_bulb.opmenu.StaffUtilitys;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class RandomTeleport implements Listener{

    @EventHandler
    public void randomTeleport(PlayerInteractEvent event) {
	Player player = event.getPlayer();
	if (!event.getPlayer().hasPermission("staff.tool")) {
	    return;
	}
	if (event.getPlayer().getItemInHand().getType() == Material.RECORD_3 ) {
	        Random r = new Random();
	        int random = r.nextInt();
	        
	        }
	    
	    
	    
	    
	    
	    
	    
	}
	    /*
	}
	    Random r = new Random();
	          ArrayList<Player> players = new ArrayList<Player>();
	          for(Player online : Bukkit.getServer().getOnlinePlayers()) {
	          if(!(online == player)) {

		          players.add(online);
		          }
		          int index = r.nextInt(players.size());
		          Player loc = (Player) players.get(index);
		          player.teleport(loc);
		          player.sendMessage("§eTelporting you to " + "§6(name)" + "§e...");
	          } return;
	}
	*/
}
