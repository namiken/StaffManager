package net.l_bulb.opmenu;

import org.bukkit.entity.Player;

public class IsStaff {
  
  public static boolean isStaff(Player player) {
    if (player.hasPermission("staff.staff")) {
      return true;
    } else {
      return false;
    }
  }
}