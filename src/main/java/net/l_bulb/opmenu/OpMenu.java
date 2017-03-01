package net.l_bulb.opmenu;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.l_bulb.opmenu.Commands.ClearChatCommand;
import net.l_bulb.opmenu.Commands.FlyCommand;
import net.l_bulb.opmenu.Commands.MenuCommand;
import net.l_bulb.opmenu.Commands.StaffCommand;
import net.l_bulb.opmenu.Listener.MenuListener;
import net.l_bulb.opmenu.StaffUtilitys.Compass;
import net.l_bulb.opmenu.StaffUtilitys.FreezePlayer;
import net.l_bulb.opmenu.StaffUtilitys.HealthCheck;
import net.l_bulb.opmenu.StaffUtilitys.InventoryCheck;
import net.l_bulb.opmenu.StaffUtilitys.RandomTeleport;

public class OpMenu extends JavaPlugin {
    @Override
    public void onEnable() {
	// 起動時Permissionを持っている人は全員Staff Mode Enableにする
	Player player =  (Player) Bukkit.getServer().getOnlinePlayers();
	if (IsStaff.isStaff(player)) {
	    StaffCommand.onEnableStaffMode(player);
	}

	// registers
	onCommands();
	onEvents();
    }

    public void onCommands() {
	getCommand("staff").setExecutor(new StaffCommand());
	getCommand("menu").setExecutor(new MenuCommand());
	getCommand("fly").setExecutor(new FlyCommand());
	getCommand("cc").setExecutor(new ClearChatCommand());
    }

    public void onEvents() {
	getServer().getPluginManager().registerEvents(new StaffCommand(), this);
	getServer().getPluginManager().registerEvents(new MenuListener(), this);
	getServer().getPluginManager().registerEvents(new Compass(), this);
	getServer().getPluginManager().registerEvents(new HealthCheck(), this);
	getServer().getPluginManager().registerEvents(new RandomTeleport(), this);
	getServer().getPluginManager().registerEvents(new InventoryCheck(), this);
	getServer().getPluginManager().registerEvents(new EventCancel(), this);
	getServer().getPluginManager().registerEvents(new FreezePlayer(), this);
    }
}