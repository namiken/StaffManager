package com.github.favreyo.staffmanager;

import org.bukkit.plugin.java.JavaPlugin;

import com.github.favreyo.staffmanager.commands.ClearChatCommand;
import com.github.favreyo.staffmanager.commands.FlyCommand;
import com.github.favreyo.staffmanager.commands.FreezeCommand;
import com.github.favreyo.staffmanager.commands.MenuCommand;
import com.github.favreyo.staffmanager.commands.StaffCommand;
import com.github.favreyo.staffmanager.listener.MenuListener;
import com.github.favreyo.staffmanager.staffutilitys.Compass;
import com.github.favreyo.staffmanager.staffutilitys.HealthCheck;
import com.github.favreyo.staffmanager.staffutilitys.InventoryCheck;
import com.github.favreyo.staffmanager.staffutilitys.RandomTeleport;
import com.github.favreyo.staffmanager.staffutilitys.StaffGUI;

public class StaffManager extends JavaPlugin {
    @Override
    public void onEnable() {
	// registers
	onCommandRegister();
	onEventRegiser();
    }

    public void onCommandRegister() {
	getCommand("staff").setExecutor(new StaffCommand());
	getCommand("menu").setExecutor(new MenuCommand());
	getCommand("fly").setExecutor(new FlyCommand());
	getCommand("cc").setExecutor(new ClearChatCommand());
	getCommand("freeze").setExecutor(new FreezeCommand());
    }

    public void onEventRegiser() {
	getServer().getPluginManager().registerEvents(new StaffCommand(), this);
	getServer().getPluginManager().registerEvents(new MenuListener(), this);
	getServer().getPluginManager().registerEvents(new Compass(), this);
	getServer().getPluginManager().registerEvents(new HealthCheck(), this);
	getServer().getPluginManager().registerEvents(new RandomTeleport(), this);
	getServer().getPluginManager().registerEvents(new InventoryCheck(), this);
	getServer().getPluginManager().registerEvents(new EventCancel(), this);
	getServer().getPluginManager().registerEvents(new StaffGUI(), this);
    }
}