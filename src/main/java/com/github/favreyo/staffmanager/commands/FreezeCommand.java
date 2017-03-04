package com.github.favreyo.staffmanager.commands;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class FreezeCommand implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
	if (!(sender instanceof Player)) {
	    sender.sendMessage("コンソールから実行できません");
	    return true;
	}

	if (args.length == 0) {
	    sender.sendMessage(ChatColor.RED + "Playerを入力してください。Freezeしている人を表示:/Freezes");
	    return true;
	}
	Player online = Bukkit.getPlayerExact(args[0]);
	if (online == null) {
	    sender.sendMessage(ChatColor.RED + args[0] + " is off line");
	} else {
	    sender.sendMessage(ChatColor.GREEN + args[0] + "の動きを規制しました");
	    Player target = (Player) sender;
	    toggleFreaze(target);
	}
	return true;

    }

    private static void toggleFreaze(Player target) {
	if (!isFreeze(target)) {
	    onFreezeEnable(target);
	} else {
	    onFreezeDisable(target);
	}
    }

    public static HashMap<String, Location> Freeze = new HashMap<>();

    private static void onFreezeEnable(Player target) {
	Freeze.put(target.getDisplayName(), target.getLocation());
	target.sendMessage(ChatColor.RED + "⚠管理者によって規制されました");
    }

    private static void onFreezeDisable(Player target) {
	Freeze.remove(target.getDisplayName());
	target.sendMessage(ChatColor.GREEN + "規制が解除されました");
    }

    @EventHandler
    public void movingEvent(PlayerMoveEvent event) {
	if (isFreeze(event.getPlayer())) {
	    event.getPlayer().sendMessage(ChatColor.RED + "⚠ 動きが規制されています");
	    event.getPlayer().teleport(Freeze.get(event.getPlayer().getDisplayName()));
	}
    }

    public static boolean isFreeze(Player target) {
	return Freeze.containsKey(target.getDisplayName());
    }

}
