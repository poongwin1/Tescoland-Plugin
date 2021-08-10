package me.poongwin.fatherland;

import me.poongwin.fatherland.commands.Map;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public final class Fatherland extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        Objects.requireNonNull(getServer().getPluginCommand("map")).setExecutor(new Map());
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("fatherland")){
            if (!sender.hasPermission("fatherland.reload")){
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
            }
        }
        return false;
    }
}
