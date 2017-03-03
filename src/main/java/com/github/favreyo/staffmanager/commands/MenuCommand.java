package com.github.favreyo.staffmanager.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.favreyo.staffmanager.listener.MenuListener;

public class MenuCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args ) {
	if (!sender.hasPermission("staff.menu")) {

	}
        if (sender instanceof Player) {
           MenuListener.MenuCreate((Player) sender);
        } else {
            sender.sendMessage("コンソールから実行できません。");
        }
        return true;
    }
}