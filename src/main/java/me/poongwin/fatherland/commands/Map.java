package me.poongwin.fatherland.commands;

import me.poongwin.fatherland.Fatherland;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Map implements CommandExecutor {
    private final Fatherland fatherland;

    public Map(Fatherland fatherland){
        this.fatherland = fatherland;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;

            if (player.isOp() || player.hasPermission("fatherland.map")){
                player.sendMessage(ChatColor.GRAY + "Click this link to view the web-map: https://bit.ly/3e8FkC5");

                return true;
            } else{
                player.sendMessage(ChatColor.RED + "You do not have permission to use this command");
                return true;
            }

         } else{
            fatherland.getLogger().info("You have to be a player to use this command");
            return true;
        }
    }
}
