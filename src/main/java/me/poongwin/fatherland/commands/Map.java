package me.poongwin.fatherland.commands;

import me.poongwin.fatherland.Fatherland;
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

import java.util.ArrayList;
import java.util.Objects;

public record Map(Fatherland fatherland) implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("map")){
            if (!sender.hasPermission("fatherland.map")){
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        Objects.requireNonNull(fatherland.getConfig().getString("no-permission"))));
                return true;
            }
            if (args.length == 0){
                sender.sendMessage(ChatColor.RED + "Valid subcommands are: '3D' and '2D'");
                return true;
            }
            if (!(sender instanceof Player player)){
                fatherland.getLogger().info("You have to be a player to use this command");
                return true;
            }
            if (args[0].equalsIgnoreCase("3d")) {
                TextComponent message = new TextComponent((ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(fatherland.getConfig().getString("3dmap.message")))));
                TextComponent link = new TextComponent((ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(fatherland.getConfig().getString("3dmap.link-text")))));
                link.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, fatherland.getConfig().getString("3dmap.link")));
                link.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text((ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(fatherland.getConfig().getString("3dmap.hover")))))));
                message.addExtra(link);
                player.sendMessage(message);
                return true;
            }
            if (args[0].equalsIgnoreCase("2d")) {
                TextComponent message = new TextComponent((ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(fatherland.getConfig().getString("2dmap.message")))));
                TextComponent link = new TextComponent((ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(fatherland.getConfig().getString("2dmap.link-text")))));
                link.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, fatherland.getConfig().getString("2dmap.link")));
                link.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text((ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(fatherland.getConfig().getString("2dmap.hover")))))));
                message.addExtra(link);
                player.sendMessage(message);
                return true;
            }
        }
        return false;
    }
}