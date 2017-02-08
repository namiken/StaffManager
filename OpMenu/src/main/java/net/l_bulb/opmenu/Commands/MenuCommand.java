package net.l_bulb.opmenu.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.l_bulb.opmenu.Menu;

public class MenuCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args ) {
        if (sender instanceof Player) {
            new Menu().MenuCreate((Player) sender);
        } else {
            sender.sendMessage("Cannot execute this command from console");
        }
        return true;
    }
}