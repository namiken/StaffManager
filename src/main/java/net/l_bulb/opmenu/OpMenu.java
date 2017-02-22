package net.l_bulb.opmenu;

import org.bukkit.plugin.java.JavaPlugin;

import net.l_bulb.opmenu.Commands.FlyCommand;
import net.l_bulb.opmenu.Commands.MenuCommand;
import net.l_bulb.opmenu.Commands.StaffCommand;
import net.l_bulb.opmenu.Listener.MenuListener;
import net.l_bulb.opmenu.StaffUtilitys.Compass;
import net.l_bulb.opmenu.StaffUtilitys.HealthCheck;

public class OpMenu extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("staff").setExecutor(new StaffCommand());
        getCommand("menu").setExecutor(new MenuCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getServer().getPluginManager().registerEvents(new StaffCommand(), this);
        getServer().getPluginManager().registerEvents(new MenuListener(), this);
        getServer().getPluginManager().registerEvents(new Compass(), this);
        getServer().getPluginManager().registerEvents(new HealthCheck(), this);
    }

}