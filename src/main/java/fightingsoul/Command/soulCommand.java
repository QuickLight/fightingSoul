package fightingsoul.Command;

import fightingsoul.Gui.soulGui;
import fightingsoul.Main.soulMain;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class soulCommand {
    soulMain main;
    public soulCommand(soulMain main){
        this.main=main;
    }

    public void open(CommandSender sender, Command command,String label,String[] args){
        if (args.length==1){
            soulGui.opengui(sender);
        }

    }
}
