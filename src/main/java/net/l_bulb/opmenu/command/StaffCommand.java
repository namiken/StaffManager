package net.l_bulb.opmenu.command;

import java.util.Set;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.google.common.collect.Sets;

import net.l_bulb.opmenu.utilities.StaffItems;

public class StaffCommand implements Listener, CommandExecutor {
  
  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (!(sender instanceof Player)) {
      sender.sendMessage("コンソールから実行できません。");
      return true;
    }
    
    Player player = (Player) sender;
    toggleStaffMode(player);
    return true;
  }
  
  private static Set<UUID> staffs = Sets.newHashSet();
  
  public static void toggleStaffMode(Player player) {
    if (!isInStaffMode(player)) {
      enableStaffMode(player);
    } else {
      disableStaffMode(player);
    }
  }
  
  public static void enableStaffMode(Player player) {
    player.getInventory().clear();
    StaffItems.addstaffItems(player);
    player.sendMessage(ChatColor.GREEN + "[OpMenu] " + ChatColor.GOLD + "Staff Mode >> Enable!");
    staffs.add(player.getUniqueId());
    player.setAllowFlight(true);
    player.setGameMode(GameMode.SURVIVAL);
  }
  
  public static void disableStaffMode(Player player) {
    player.getInventory().clear();
    player.sendMessage(ChatColor.RED + "[OpMenu] " + ChatColor.GOLD + "Staff Mode >> Disable!");
    staffs.remove(player.getUniqueId());
    player.setAllowFlight(false);
    player.setGameMode(GameMode.SURVIVAL);
  }
  
  public static boolean isInStaffMode(Player player) {
    return staffs.contains(player.getUniqueId());
  }
}