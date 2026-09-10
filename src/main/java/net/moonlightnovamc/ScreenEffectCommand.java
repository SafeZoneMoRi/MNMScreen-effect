package net.moonlightnovamc;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ScreenEffectCommand implements CommandExecutor {

    private final Main plugin;

    public ScreenEffectCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length != 4) {
            sender.sendMessage("§cUsage: /screeneffect <fadeIn> <stay> <fadeOut> <player>");
            return true;
        }

        int fadeIn, stay, fadeOut;

        try {
            fadeIn = Integer.parseInt(args[0]);
            stay = Integer.parseInt(args[1]);
            fadeOut = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            sender.sendMessage("§cfadeIn, stay, fadeOut ต้องเป็นตัวเลข");
            return true;
        }

        String playerArg = args[3];

        // ใช้ PlaceholderAPI
        if (sender instanceof Player) {
            playerArg = PlaceholderAPI.setPlaceholders(
                    (Player) sender,
                    playerArg
            );
        }

        Player target = Bukkit.getPlayerExact(playerArg);

        if (target == null) {
            sender.sendMessage("§cไม่พบผู้เล่น: " + playerArg);
            return true;
        }

        plugin.getScreenEffect().fade(target, fadeIn, stay, fadeOut);

        sender.sendMessage("§aPlayed screen effect to " + target.getName());
        return true;
    }
}
