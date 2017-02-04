package net.l_bulb.opmenu;

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

public class Menu implements Listener {
    static ItemStack Vanish = new ItemStack(Material.GLASS);
    static {
        ItemMeta VanishMeta = Vanish.getItemMeta();
        VanishMeta.setDisplayName(ChatColor.DARK_GREEN + "Vanish");
        Vanish.setItemMeta(VanishMeta);
    }


    public void MenuCreate(Player player) {
        Inventory inv = Bukkit.createInventory(null, 9, "OpMenu" );
        inv.setItem(0, Vanish);
        player.openInventory(inv);
        System.out.println("open inv");
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        System.out.println("1");
        Player player = (Player) event.getWhoClicked();

        ItemStack clicked = event.getCurrentItem();

        Inventory invenotory = event.getInventory();

        if (invenotory.getName().equals("OpMenu")) {
            System.out.println("2");
            if (Vanish.equals(clicked)) {
                event.setCancelled(true);
                player.closeInventory();
                player.performCommand("vanish");
            }
        }
    }
}