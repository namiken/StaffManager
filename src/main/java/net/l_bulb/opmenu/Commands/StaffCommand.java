package net.l_bulb.opmenu.Commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
public class StaffCommand implements Listener,  CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args ) {
	if (!sender.hasPermission("staff.staff")) {
	}
        if (sender instanceof Player) {
	    Player player = (Player) sender;
	    player.sendMessage("player");
        } else {
            sender.sendMessage("コンソールから実行できません。");
        }
        return true;
    }
    public static void staffItems(Player player) {
	PlayerInventory Inventory = player.getInventory();
	Inventory.clear();
	ItemStack ItemStack1 = new ItemStack(Material.COMPASS);
	ItemStack ItemStack2 = new ItemStack(Material.BOOK);
	ItemStack ItemStack3 = new ItemStack(Material.RECORD_3);
	ItemStack ItemStack4 = new ItemStack(Material.INK_SACK);
	ItemStack ItemStack5 = new ItemStack(Material.SHEARS);

	ItemMeta ItemMeta1 = ItemStack1.getItemMeta();
	ItemMeta ItemMeta2 = ItemStack2.getItemMeta();
	ItemMeta ItemMeta3 = ItemStack3.getItemMeta();
	ItemMeta ItemMeta4 = ItemStack4.getItemMeta();
	ItemMeta ItemMeta5 = ItemStack5.getItemMeta();

	ItemMeta1.setDisplayName(ChatColor.GOLD + "Teleport Compass");
	ItemMeta2.setDisplayName(ChatColor.GOLD + "Inventory Check");
	ItemMeta3.setDisplayName(ChatColor.GOLD + "Teleport Random");
	ItemMeta4.setDisplayName(ChatColor.GOLD + "Staff GUI");
	ItemMeta5.setDisplayName(ChatColor.GOLD + "Health Check");

	ItemStack1.setItemMeta(ItemMeta1);
	ItemStack2.setItemMeta(ItemMeta2);
	ItemStack3.setItemMeta(ItemMeta3);
	ItemStack4.setItemMeta(ItemMeta4);
	ItemStack5.setItemMeta(ItemMeta5);

	Inventory.setItem(0, ItemStack1);
	Inventory.setItem(1, ItemStack2);
	Inventory.setItem(7, ItemStack3);
	Inventory.setItem(8, ItemStack4);
	Inventory.setItem(2, ItemStack5);
    }

    public static void onEnableStaffMode(Player player) {
	player.getInventory().clear();
	staffItems(player);
	player.sendMessage(ChatColor.GREEN + "[OpMenu] " + ChatColor.GOLD + "Staff Mode >> Enable!");
    }

    public static void onDisableStaffMode(Player player) {
	player.setGameMode(GameMode.SURVIVAL);
	player.getInventory().clear();
	player.sendMessage(ChatColor.GREEN + "[OpMenu] " + ChatColor.GOLD + "Staff Mode >> Disable!");
    }

    @EventHandler
    public void rightClick(PlayerInteractEntityEvent event) { // Playerが左クリックした時
	if(!(event.getRightClicked() instanceof Player)) {
	    return;
	}
	Player Player1 = event.getPlayer();
	Player Player2 = (Player)event.getRightClicked();
	Player1.sendMessage("1");
	Player2.sendMessage("2");
    }


}
