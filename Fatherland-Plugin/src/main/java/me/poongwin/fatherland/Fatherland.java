package me.poongwin.fatherland;

import me.poongwin.fatherland.commands.Discord;
import me.poongwin.fatherland.commands.Map;
import org.bukkit.plugin.java.JavaPlugin;

public final class Fatherland extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginCommand("map").setExecutor(new Map(this));
        getServer().getPluginCommand("discord").setExecutor(new Discord(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
