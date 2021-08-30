package com.poongwin.tescoland;

import com.poongwin.tescoland.commands.Map;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public final class Tescoland extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        Objects.requireNonNull(getServer().getPluginCommand("map")).setExecutor(new Map(this));
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("tescoland")){
            if (!sender.hasPermission("tescoland.reload")){
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        Objects.requireNonNull(this.getConfig().getString("no-permission"))));
                return true;
            }
            if (args.length == 0){
                sender.sendMessage(ChatColor.RED + "A subcommand is required.");
                return true;
            }
            if (args[0].equalsIgnoreCase("reload")) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(this.getConfig().getString("reload-message"))));
                this.reloadConfig();
            } else{
                sender.sendMessage(ChatColor.RED + "Invalid subcommand.");
            }
            return true;
        }
        return false;
    }
}
