package net.l_bulb.opmenu;

import org.bukkit.plugin.java.JavaPlugin;

public class OpMenu extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("opmenu").setExecutor(new MenuCommand());
        getServer().getPluginManager().registerEvents(new Menu(), this);
    }
}