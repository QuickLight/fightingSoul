package fightingsoul.Main;

import net.milkbowl.vault.Vault;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {
    private Vault vault;
    private Economy economy = null;

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
        hookVault();
    }

    @Override
    public void onDisable() {
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return super.onCommand(sender, command, label, args);
    }
}
