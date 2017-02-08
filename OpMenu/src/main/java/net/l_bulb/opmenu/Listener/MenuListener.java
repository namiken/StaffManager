package net.l_bulb.opmenu.Listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MenuListener implements Listener {
    static ItemStack Vanish = new ItemStack(Material.GLASS);
    static ItemStack Fly = new ItemStack(Material.FEATHER);
    static {
        // Vanish
        ItemMeta VanishMeta = Vanish.getItemMeta();
        VanishMeta.setDisplayName(ChatColor.DARK_GREEN + "Vanish");
        Vanish.setItemMeta(VanishMeta);
        // Fly
        ItemMeta FlyMeta = Fly.getItemMeta();
        FlyMeta.setDisplayName("Fly");
        Fly.setItemMeta(FlyMeta);
    }

    public void MenuCreate(Player player) {
        Inventory inv = Bukkit.createInventory(null, 9, "OpMenu" );
        inv.setItem(0, Vanish);
        inv.setItem(2, Fly);
        player.openInventory(inv);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack clicked = event.getCurrentItem();

        String command = null;

        if (Vanish.equals(clicked)) {
            command = "vanish";
        }
        if (Fly.equals(clicked)) {
            command = "fly";
        }

        if (command != null) {
        event.setCancelled(true);
         player.closeInventory();
        player.performCommand(command);
        }
    }
}
