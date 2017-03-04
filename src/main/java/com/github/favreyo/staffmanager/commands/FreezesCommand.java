package com.github.favreyo.staffmanager.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class FreezesCommand implements CommandExecutor, Listener {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
	Player player = (Player) sender;
	if (StaffCommand.isInStaffMode(player)) {
	}
	for (String list : FreezeCommand.Freeze.keySet()) {
	    sender.sendMessage(list);
	}
	return true;
    }
}
