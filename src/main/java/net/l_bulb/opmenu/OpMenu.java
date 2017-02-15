package net.l_bulb.opmenu;

import org.bukkit.plugin.java.JavaPlugin;

import net.l_bulb.opmenu.Commands.FlyCommand;
import net.l_bulb.opmenu.Commands.MenuCommand;
import net.l_bulb.opmenu.Commands.StaffCommand;
import net.l_bulb.opmenu.Listener.FoodListener;
import net.l_bulb.opmenu.Listener.MenuListener;;

public class OpMenu extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("staff").setExecutor(new StaffCommand());
        getCommand("menu").setExecutor(new MenuCommand());
        getServer().getPluginManager().registerEvents(new MenuListener(), this);
        getServer().getPluginManager().registerEvents(new FoodListener(), this);
    }
}