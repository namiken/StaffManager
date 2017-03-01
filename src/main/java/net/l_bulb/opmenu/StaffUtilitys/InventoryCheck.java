package net.l_bulb.opmenu.StaffUtilitys;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryCheck implements Listener {

    @EventHandler
    public void bookLeftClickEvent(PlayerInteractEntityEvent event) {
	if (!event.getPlayer().hasPermission("staff.tool")) {
	}
	if (!(event.getRightClicked() instanceof Player)) {
	    return;
	}

	if (event.getPlayer().getItemInHand().getType() == Material.BOOK) {
	    Player player = event.getPlayer();
	    Player target = (Player) event.getRightClicked();
	    createInventory(player, target);
	}

    }

    public static void createInventory(Player player, Player target) {
	// Armour
	ItemStack helmet = target.getInventory().getHelmet();
	ItemStack chestplate = target.getInventory().getChestplate();
	ItemStack leggins = target.getInventory().getLeggings();
	ItemStack boots = target.getInventory().getBoots();
	ItemStack[] items = target.getInventory().getContents();
	ItemStack Health = new ItemStack(Material.SHEARS);

	ItemMeta HealthMeta = Health.getItemMeta();
	HealthMeta.setDisplayName(target.getDisplayName() + "has" + target.getHealth() + "Health");

	Inventory inv = Bukkit.createInventory(player, 45, target.getDisplayName() + " Inventory!");

	inv.setContents(items);
	player.openInventory(inv);
	inv.setItem(36, helmet);
	inv.setItem(37, chestplate);
	inv.setItem(38, leggins);
	inv.setItem(39, boots);
	inv.setItem(40, Health);

	player.updateInventory();
    }
}
