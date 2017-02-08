package net.l_bulb.opmenu.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
public class StaffCommand implements CommandExecutor{
    //TODO 未実装 とりあえず menuと同じ結果を出すように
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args ) {
        if (sender instanceof Player) {
            System.out.println("Staff Command Done!");
        } else {
            sender.sendMessage("Cannot execute this command from console");
        }
        return true;
    }

}
