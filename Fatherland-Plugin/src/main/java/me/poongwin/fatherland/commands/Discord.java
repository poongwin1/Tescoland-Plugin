package me.poongwin.fatherland.commands;

import me.poongwin.fatherland.Fatherland;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Discord implements CommandExecutor {
    private final Fatherland fatherland;

    public Discord(Fatherland fatherland){
        this.fatherland = fatherland;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;

            if (player.isOp() || player.hasPermission("fatherland.discord")){
                TextComponent mainComponent = new TextComponent( "Click this link to join our Discord server: " );
                mainComponent.setColor( ChatColor.GRAY );
                TextComponent subComponent = new TextComponent( "https://bit.ly/39jwmjZ" );
                subComponent.setColor( ChatColor.AQUA );
                subComponent.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT, new ComponentBuilder( "Click me!" ).create() ) );
                subComponent.setClickEvent( new ClickEvent( ClickEvent.Action.OPEN_URL, "https://bit.ly/39jwmjZ" ) );
                mainComponent.addExtra( subComponent );
                player.spigot().sendMessage( mainComponent );
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
