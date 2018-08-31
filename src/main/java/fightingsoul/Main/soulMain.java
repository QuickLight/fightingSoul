package fightingsoul.Main;

import net.milkbowl.vault.Vault;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class soulMain extends JavaPlugin {
    private Vault vault;
    private Economy economy = null;
    private static soulMain Instance;

    public static soulMain getInstance() {
        return Instance;
    }

    public Economy getEconomy() {
        return this.economy;
    }

    public boolean hookVault() {
        this.vault = (Vault) this.getServer().getPluginManager().getPlugin("Vault");
        if (this.vault != null) {
            RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
            if (rsp != null) {
                this.economy = rsp.getProvider();
                this.getLogger().info("succeed");
            } else if (rsp == null) {
                this.getLogger().info("Failed to get economy");
            }
            this.getLogger().info("found vault");
        }
        return true;
    }

    @Override
    public void onEnable() {
        Instance = this;
        hookVault();
    }

    @Override
    public void onDisable() {
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("请在游戏内输入该指令");
            return true;
        }
        Player player = (Player) sender;
        if ((args.length == 1) && (args[0].equalsIgnoreCase("open"))) {
            Inventory inventory = Bukkit.createInventory(player, InventoryType.CHEST, "§6斗魂系统");
            ItemStack black = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta blackmeta = black.getItemMeta();
            blackmeta.setDisplayName("§5§l1");
            black.setItemMeta(blackmeta);
            ItemStack gold = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1, (short) 1);
            ItemMeta goldmeta = gold.getItemMeta();
            goldmeta.setDisplayName("§5§l2");
            gold.setItemMeta(goldmeta);

            ItemStack red = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1, (short) 14);
            ItemMeta redmeta = red.getItemMeta();
            redmeta.setDisplayName("§5§l3");
            red.setItemMeta(redmeta);

            int[] blacks = {0, 1, 2, 4, 6, 7, 8};
            for (int i = 0; i < blacks.length; i++) {
                inventory.setItem(blacks[i], black);
            }
            inventory.setItem(3, gold);
            inventory.setItem(5, red);
            player.openInventory(inventory);
        }
        return false;
    }
}
