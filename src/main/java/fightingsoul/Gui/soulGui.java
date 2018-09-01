package fightingsoul.Gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class soulGui {
    public static void opengui(CommandSender sender) {
        Player player = (Player) sender;
        Inventory inventory = Bukkit.createInventory(player, 9, "§6§l斗魂系统");
        ItemStack black = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
        ItemMeta blackmeta = black.getItemMeta();
        blackmeta.setDisplayName("§5§l斗魂分解");
        blackmeta.setUnbreakable(true);
        black.setItemMeta(blackmeta);

        ItemStack gold = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
        ItemMeta goldmeta = gold.getItemMeta();
        goldmeta.setDisplayName("§5§l斗魂强化");
        goldmeta.setUnbreakable(true);
        gold.setItemMeta(goldmeta);

        ItemStack red = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
        ItemMeta redmeta = red.getItemMeta();
        redmeta.setDisplayName("§5§l斗魂合成");
        redmeta.setUnbreakable(true);
        red.setItemMeta(redmeta);

        inventory.setItem(1, black);
        inventory.setItem(4, gold);
        inventory.setItem(7, red);
        player.openInventory(inventory);
    }
}
