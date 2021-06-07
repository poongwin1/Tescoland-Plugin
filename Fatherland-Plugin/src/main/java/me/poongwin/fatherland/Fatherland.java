package me.poongwin.fatherland;

import me.poongwin.fatherland.commands.Discord;
import me.poongwin.fatherland.commands.Map;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Fatherland extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.saveDefaultConfig();
        Objects.requireNonNull(getServer().getPluginCommand("map")).setExecutor(new Map(this));
        Objects.requireNonNull(getServer().getPluginCommand("discord")).setExecutor(new Discord(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("fatherland")){
            if (!sender.hasPermission("fatherland.reload")){
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        Objects.requireNonNull(this.getConfig().getString("no-permission"))));
                return true;
            }
            if (args.length == 0){
                // /fatherland
                sender.sendMessage(ChatColor.RED + "Usage: /fatherland reload");
                return true;
            }
            // /fatherland reload
            if (args[0].equalsIgnoreCase("reload")) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(this.getConfig().getString("reload-message"))));
                this.reloadConfig();
            }
        }
        return false;
    }
}
