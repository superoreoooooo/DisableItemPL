package org.oreoprojekt.disableitem.event;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;

public class DIEvent implements Listener {

    @EventHandler
    public void craftItem(PrepareItemCraftEvent e) {
        try {
            Material itemType = e.getRecipe().getResult().getType();
            Byte itemData = e.getRecipe().getResult().getData().getData();
            if (itemType == Material.ENDER_CHEST) {
                e.getInventory().setResult(new ItemStack(Material.AIR));
                for (HumanEntity he : e.getViewers()) {
                    if (he instanceof Player) {
                        ((Player) he).sendMessage(ChatColor.RED + "이 아이템은 조합할 수 없습니다!");
                    }
                }
            }
        } catch(Exception exception) {

        }
    }

    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event) {
        if (event.getInventory().equals(event.getPlayer().getEnderChest() ) )
        {
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatColor.RED + "이 아이템은 열 수 없습니다!");
        }
    }
}
