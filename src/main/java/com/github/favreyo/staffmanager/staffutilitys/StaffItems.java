package com.github.favreyo.staffmanager.staffutilitys;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class StaffItems {

	/**
	 * スタッフアイテムの本を取得する
	 */
	public static ItemStack getStaffItemBook() {
		ItemStack ItemStack2 = new ItemStack(Material.BOOK);
		//アイテム名を設定
		ItemMeta ItemMeta2 = ItemStack2.getItemMeta();
		ItemMeta2.setDisplayName(ChatColor.GOLD + "Inventory Check");
		ItemStack2.setItemMeta(ItemMeta2);
		return ItemStack2;
	}

    public static void addstaffItems(Player player) {
	PlayerInventory Inventory = player.getInventory();
	ItemStack ItemStack1 = new ItemStack(Material.COMPASS);

	ItemStack ItemStack3 = new ItemStack(Material.RECORD_3);
	ItemStack ItemStack4 = new ItemStack(Material.INK_SACK);
	ItemStack ItemStack5 = new ItemStack(Material.SHEARS);

	ItemMeta ItemMeta1 = ItemStack1.getItemMeta();

	ItemMeta ItemMeta3 = ItemStack3.getItemMeta();
	ItemMeta ItemMeta4 = ItemStack4.getItemMeta();
	ItemMeta ItemMeta5 = ItemStack5.getItemMeta();

	ItemMeta1.setDisplayName(ChatColor.GOLD + "Teleport Compass");
	ItemMeta3.setDisplayName(ChatColor.GOLD + "Teleport Random");
	ItemMeta4.setDisplayName(ChatColor.GOLD + "Staff GUI");
	ItemMeta5.setDisplayName(ChatColor.GOLD + "Health Check");

	ItemStack1.setItemMeta(ItemMeta1);
	ItemStack3.setItemMeta(ItemMeta3);
	ItemStack4.setItemMeta(ItemMeta4);
	ItemStack5.setItemMeta(ItemMeta5);

	Inventory.setItem(0, ItemStack1);
	Inventory.setItem(1, getStaffItemBook());
	Inventory.setItem(7, ItemStack3);
	Inventory.setItem(8, ItemStack4);
	Inventory.setItem(2, ItemStack5);
    }
}
