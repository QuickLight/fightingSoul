package fightingsoul.Listener;

import fightingsoul.Main.soulMain;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.event.Listener;

public class soulListeners implements Listener {
    private final soulMain plugin = soulMain.getInstance();
    private Economy economy = plugin.getEconomy();
}
