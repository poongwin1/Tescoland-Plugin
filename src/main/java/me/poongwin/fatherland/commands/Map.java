package me.poongwin.fatherland.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public final class Map extends JavaPlugin{

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("fatherland")){
            if (!sender.hasPermission("fatherland.map")){
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        Objects.requireNonNull(this.getConfig().getString("no-permission"))));
                return true;
            }
            if (args.length == 0){
                sender.sendMessage(ChatColor.RED + "A subcommand is required.");
                return true;
            }
            if (args[0].equalsIgnoreCase("fast")) {
                if (sender instanceof Player player) {
                    if (player.isOp() || player.hasPermission("fatherland.map")) {
                        TextComponent message = new TextComponent((ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(this.getConfig().getString("fastmap.message")))));
                        TextComponent link = new TextComponent((ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(this.getConfig().getString("fastmap.link-text")))));
                        link.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, this.getConfig().getString("fastmap.link")));
                        link.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text((ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(this.getConfig().getString("fastmap.hover")))))));
                        message.addExtra(link);
                        player.spigot().sendMessage(message);
                    } else {
                        player.sendMessage(Objects.requireNonNull(this.getConfig().getString(ChatColor.translateAlternateColorCodes('&', "no-permission"))));
                    }
                } else {
                    this.getLogger().info("You have to be a player to use this command");
                }
                return true;
            }
            if (args[0].equalsIgnoreCase("slow")) {
                if (sender instanceof Player player) {
                    if (player.isOp() || player.hasPermission("fatherland.map")) {
                        TextComponent message = new TextComponent((ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(this.getConfig().getString("slowmap.message")))));
                        TextComponent link = new TextComponent((ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(this.getConfig().getString("slowmap.link-text")))));
                        link.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, this.getConfig().getString("slowmap.link")));
                        link.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text((ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(this.getConfig().getString("slowmap.hover")))))));
                        message.addExtra(link);
                        player.spigot().sendMessage(message);
                    } else {
                        player.sendMessage(Objects.requireNonNull(this.getConfig().getString(ChatColor.translateAlternateColorCodes('&', "no-permission"))));
                    }
                } else {
                    this.getLogger().info("You have to be a player to use this command");
                }
                return true;
            }
        }
        return false;
    }
}
