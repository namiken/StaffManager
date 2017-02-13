package net.l_bulb.opmenu.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.l_bulb.opmenu.Listener.MenuListener;

public class MenuCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args ) {
        if (sender instanceof Player) {
           new MenuListener().MenuCreate((Player) sender);
        } else {
            sender.sendMessage("コンソールから実行できません。");
        }
        return true;
    }
}