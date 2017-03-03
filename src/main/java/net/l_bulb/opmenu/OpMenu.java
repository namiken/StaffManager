package net.l_bulb.opmenu;

import org.bukkit.plugin.java.JavaPlugin;

import net.l_bulb.opmenu.command.ClearChatCommand;
import net.l_bulb.opmenu.command.FlyCommand;
import net.l_bulb.opmenu.command.FreezeCommand;
import net.l_bulb.opmenu.command.MenuCommand;
import net.l_bulb.opmenu.command.StaffCommand;
import net.l_bulb.opmenu.listener.MenuListener;
import net.l_bulb.opmenu.utilities.Compass;
import net.l_bulb.opmenu.utilities.HealthCheck;
import net.l_bulb.opmenu.utilities.InventoryCheck;
import net.l_bulb.opmenu.utilities.RandomTeleport;

public class OpMenu extends JavaPlugin {
  
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
  }
}