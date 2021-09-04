package com.poongwin.tescoland.commands;

import com.poongwin.tescoland.Tescoland;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public record Map(Tescoland tescoland) implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("map")){
            if (sender instanceof Player player) {
                if (player.isOp() || player.hasPermission("fatherland.map")) {
                    TextComponent message = new TextComponent((ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(tescoland.getConfig().getString("map.message")))));
                    TextComponent link = new TextComponent((ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(tescoland.getConfig().getString("map.link-text")))));
                    link.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, tescoland.getConfig().getString("map.link")));
                    link.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text((ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(tescoland.getConfig().getString("map.hover")))))));
                    message.addExtra(link);
                    player.spigot().sendMessage(message);
                } else {
                    player.sendMessage(Objects.requireNonNull(tescoland.getConfig().getString(ChatColor.translateAlternateColorCodes('&', "no-permission"))));
                }
            } else {
                tescoland.getLogger().info("You have to be a player to use this command");
            }
            return true;
        }
        return false;
    }
}
