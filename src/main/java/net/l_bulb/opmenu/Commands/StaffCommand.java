package net.l_bulb.opmenu.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
public class StaffCommand implements CommandExecutor {
    static ItemStack Compass = new ItemStack(Material.COMPASS);
    static ItemStack Shears = new ItemStack(Material.SHEARS);

    static {
	// Compass
	ItemMeta CompassMeta = Compass.getItemMeta();
	CompassMeta.setDisplayName("Teleport Compass");
	Compass.setItemMeta(CompassMeta);

	// Shears
	ItemMeta ShearsMeta = Shears.getItemMeta();
	ShearsMeta.setDisplayName("Health Check");
	Shears.setItemMeta(ShearsMeta);
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args ) {
        if (sender instanceof Player) {
            inventoryClear(sender);
        } else {
            sender.sendMessage("コンソールから実行できません。");
        }
        return true;
    }
    public static void inventoryClear(CommandSender sender) {
	((Player) sender).getInventory().clear();
	sender.sendMessage(ChatColor.RED + "インベントリを削除しました");
    }

    public static void getStaffItem(CommandSender sender) {
	((Player) sender).getInventory().setItem(0, Compass);
	((Player) sender).getInventory().setItem(1, Shears);
	sender.sendMessage(ChatColor.GREEN +"Welcome To Staff Mode");
    }
}
