package me.deeka.deekaSurvival.Commands;

import me.deeka.deekaSurvival.DeekaSurvival;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SethomeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (sender instanceof Player) {
            // get the plugin directory
            File pluginDirectory = DeekaSurvival.getInstance().getDataFolder();
            File homeFolder = new File(pluginDirectory, "homes/");
            ConnectToDatabase();
            if (!homeFolder.exists()) {
                homeFolder.mkdir();
                p.sendMessage("Home folder does not exist, Creating...");
            }

            ConnectToDatabase();
            sender.sendMessage(ChatColor.GREEN + "Your home has been set.");
            return true;
        } else {
            sender.sendMessage(ChatColor.RED + "This command only works with player.");
        }
        return true;
    }
    public static void ConnectToDatabase() {
        File pluginDirectory = DeekaSurvival.getInstance().getDataFolder();
        var url = "jdbc:sqlite:" + pluginDirectory + "/homes/data.db";

        try (var conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                var meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
