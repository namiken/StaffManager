package net.l_bulb.opmenu.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	if (!sender.hasPermission("staff.fly")) {

	}
        if (sender instanceof Player) {
            toggleFly((Player) sender);
        } else {
            sender.sendMessage("コンソールから実行できません。");
        }
        return true;
    }
    private static void toggleFly(Player target) {
        final boolean allowFlight = target.getAllowFlight();
        target.setAllowFlight(!allowFlight);
        target.sendMessage(!allowFlight ? ChatColor.GREEN + "[OpMenu] " + ChatColor.GREEN + "Flying enabled!" :ChatColor.GREEN + "[OpMenu]" + ChatColor.GOLD + " Flying disabled!");
    }
}