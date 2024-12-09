package me.deeka.deekaSurvival;

import me.deeka.deekaSurvival.AdminCommands.GamemodeCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class DeekaSurvival extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        // Load up commands and listener
        getCommand("gamemode").setExecutor(new GamemodeCommand());
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
