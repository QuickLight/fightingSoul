package fightingsoul.Main;

import fightingsoul.Command.soulCommand;
import fightingsoul.Listener.soulListener;
import net.milkbowl.vault.Vault;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class soulMain extends JavaPlugin {
    public static JavaPlugin handle;
    private Vault vault;
    private Economy economy = null;
    private static soulMain Instance;
    soulCommand soulcommand = new soulCommand(this);

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
        Bukkit.getPluginManager().registerEvents(new soulListener(), this);
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
        if (args.length != 0) {
            soulcommand.open(sender, command, label, args);
        }
        return false;
    }
}
