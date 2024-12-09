package me.deeka.deekaSurvival;

import me.deeka.deekaSurvival.AdminCommands.GamemodeCommand;
import me.deeka.deekaSurvival.Commands.SethomeCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class DeekaSurvival extends JavaPlugin {
    // get instance
    public static DeekaSurvival getInstance() {
        return getPlugin(DeekaSurvival.class);
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        // Load up commands and listener
        getCommand("gamemode").setExecutor(new GamemodeCommand());
        getCommand("sethome").setExecutor(new SethomeCommand());
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        File dataFolder = getDataFolder();
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
            getLogger().info("Data Directory does not exist... Creating...");
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
