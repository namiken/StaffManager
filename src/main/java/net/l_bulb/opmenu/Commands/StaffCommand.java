package net.l_bulb.opmenu.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import net.l_bulb.opmenu.StaffUtilitys.StaffItems;
public class StaffCommand implements Listener,  CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args ) {
	if (!sender.hasPermission("staff.staff")) {
	}
        if (sender instanceof Player) {
	    Player player = (Player) sender;
	    onEnableStaffMode(player);
        } else {
            sender.sendMessage("コンソールから実行できません。");
        }
        return true;
    }

    public static void onEnableStaffMode(Player player) {
	player.getInventory().clear();
	StaffItems.addstaffItems(player);
	player.sendMessage(ChatColor.GREEN + "[OpMenu] " + ChatColor.GOLD + "Staff Mode >> Enable!");
    }

    @EventHandler
    public void rightClick(PlayerInteractEntityEvent event) { // Playerが左クリックした時
	if(!(event.getRightClicked() instanceof Player)) {
	    return;
	}
	Player Player1 = event.getPlayer();
	Player Player2 = (Player)event.getRightClicked();


    }


}
