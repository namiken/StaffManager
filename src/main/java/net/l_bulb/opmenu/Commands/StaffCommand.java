package net.l_bulb.opmenu.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
public class StaffCommand implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args ) {
        if (sender instanceof Player) {
        } else {
            sender.sendMessage("コンソールから実行できません。");
        }
        return true;
    }
}
