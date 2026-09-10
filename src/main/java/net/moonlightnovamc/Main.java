package net.moonlightnovamc;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;
    private ScreenEffect screenEffect;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        instance = this;

        screenEffect = new ScreenEffect(this);

        if (getCommand("screeneffect") == null) {
            getLogger().severe("Command screeneffect NOT FOUND (plugin.yml problem)");
        } else {
            getCommand("screeneffect")
                    .setExecutor(new ScreenEffectCommand(this));
            getLogger().info("Command screeneffect registered");
        }

        getLogger().info("MNMscreeneffect has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("MNMscreeneffect has been disabled!");
    }

    public static Main getInstance() {
        return instance;
    }

    public ScreenEffect getScreenEffect() {
        return screenEffect;
    }
}
