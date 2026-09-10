package net.moonlightnovamc;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class ScreenEffect {

    private final JavaPlugin plugin;
    private String fadeChar;

    public ScreenEffect(JavaPlugin plugin) {
        this.plugin = plugin;
        loadConfig();
    }

    private void loadConfig() {
        fadeChar = plugin.getConfig().getString(
                "screen-effect.fade-char",
                "" // fallback
        );
    }

    public void reload() {
        plugin.reloadConfig();
        loadConfig();
    }

    public void fade(Player player, int fadeIn, int stay, int fadeOut) {
        Bukkit.getScheduler().runTask(plugin, () -> {
            player.sendTitle(
                    fadeChar,
                    "",
                    fadeIn,
                    stay,
                    fadeOut
            );
        });
    }

    public void clear(Player player) {
        Bukkit.getScheduler().runTask(plugin, player::resetTitle);
    }
}
