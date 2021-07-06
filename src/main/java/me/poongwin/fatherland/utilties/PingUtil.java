package me.poongwin.fatherland.utilties;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PingUtil {

    public static int getPing(Player p) {
        String v = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
        if (!p.getClass().getName().equals("org.bukkit.craftbukkit." + v + ".entity.CraftPlayer")) { //compatibility with some plugins
            p = Bukkit.getPlayer(p.getUniqueId()); //cast to org.bukkit.entity.Player
        }
        try {
            assert p != null;
            return p.getPing();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
