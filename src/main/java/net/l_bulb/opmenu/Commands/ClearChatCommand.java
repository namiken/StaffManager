package net.l_bulb.opmenu.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearChatCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
	Player player = (Player) sender;
	if(!player.hasPermission("staff.Clear")) {
	}
	int a;
	for (a = 0; a < 100; a++) {
	player.sendMessage("");
	}
	return true;
    }

}
