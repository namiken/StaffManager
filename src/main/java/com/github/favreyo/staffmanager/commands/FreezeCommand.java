package com.github.favreyo.staffmanager.commands;

import java.util.HashMap;
import java.util.Objects;

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
	    sender.sendMessage(ChatColor.RED + "Playerを入力してください。");
	    return true;
	} else {
	    sender.sendMessage("message");
	}

	if (Objects.equals(Bukkit.getOnlinePlayers().toString(), args[0])) {
	    sender.sendMessage(ChatColor.GREEN + args[0].toString() + " is on line");
	} else {
	    sender.sendMessage(ChatColor.RED + args[0].toString() + " is off line");
	}

	Player target = (Player) sender;
	toggleFreaze(target);
	return true;
    }

    private static void toggleFreaze(Player target) {
	if (!isFreaze(target)) {
	    onFreazeEnable(target);
	} else {
	    onFreazeDisable(target);
	}
    }

    private static HashMap<Player, Location> Freeze = new HashMap<>();

    private static void onFreazeEnable(Player target) {
	Freeze.put(target, target.getLocation());
	target.sendMessage(ChatColor.RED + "⚠管理者によって規制されました");
    }

    private static void onFreazeDisable(Player target) {
	Freeze.remove(target, target.getLocation());
	target.sendMessage(ChatColor.GREEN + "規制が解除されました");
    }

    @EventHandler
    public void movingEvent(PlayerMoveEvent event) {
	if (isFreaze(event.getPlayer())) {
	    Location loc = event.getFrom();
	    event.getPlayer().teleport(loc);
	    event.getPlayer().sendMessage(ChatColor.RED + "⚠ 動きが規制されています");
	    return;

	} else {
	    event.getPlayer().sendMessage("Not Freease");
	}

	if (!Freeze.containsKey(event.getPlayer().getUniqueId().toString())) {
	    return;
	}
	if (!Freeze.containsValue(event.getPlayer().getLocation())) {
	    event.getPlayer().teleport((Location) Freeze.values());
	    event.getPlayer().sendMessage(ChatColor.RED + "⚠ 動きが規制されています");
	}
    }

    public static boolean isFreaze(Player target) {
	return Freeze.containsKey(target);
    }

    public boolean isPlyerOnline(Player target) {
	if (Bukkit.getServer().getOnlinePlayers() == target) {
	    return true;
	} else {
	    return false;
	}

    }



}
