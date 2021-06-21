package me.poongwin.fatherland.commands;

import me.poongwin.fatherland.Fatherland;
import me.poongwin.fatherland.utilties.PingUtil;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public record Ping(Fatherland fatherland) implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (sender instanceof Player player) {

            if (player.isOp() || player.hasPermission("fatherland.ping")) {
                String ping = "" + PingUtil.getPing(player);
                String customMex = Objects.requireNonNull(fatherland.getConfig().getString("ping.message")).replaceAll("%ping%", ping);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', customMex));
            } else {
                player.sendMessage(Objects.requireNonNull(fatherland.getConfig().getString(ChatColor.translateAlternateColorCodes('&', "no-permission"))));
            }
        } else {
            fatherland.getLogger().info("You have to be a player to use this command");
        }
        return true;
    }
}