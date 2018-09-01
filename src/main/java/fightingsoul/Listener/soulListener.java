package fightingsoul.Listener;


import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class soulListener implements Listener {

    @EventHandler
    void opengui(InventoryClickEvent event) {
        if (event.getClickedInventory().getName().equals("§6§l斗魂系统")) {
            event.setCancelled(true);
            if (event.getCurrentItem() != null || !event.getCurrentItem().equals(Material.AIR)) {
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§5§l斗魂分解")) {
                    event.getWhoClicked().sendMessage("你点了分解");
                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§5§l斗魂强化")) {
                    event.getWhoClicked().sendMessage("你点了强化");
                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§5§l斗魂合成")) {
                    event.getWhoClicked().sendMessage("你点了合成");
                }
            }

        }
    }
}
