package me.deeka.deekaSurvival.AdminCommands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (sender instanceof Player) {
            Component ChangedDone = MiniMessage.miniMessage().deserialize("<#55ff00><b>Staff Utils <reset><gray><b>| <reset><#AAFFAA>Your Gamemode has been updated to <#55ff00>" + p.getGameMode());
            Component InvalidArgument =  MiniMessage.miniMessage().deserialize("<#55ff00><b>Staff Utils <reset><gray><b>| <reset><#FF0000>Invalid command argument.");
            Component InvalidGamemode =  MiniMessage.miniMessage().deserialize("<#55ff00><b>Staff Utils <reset><gray><b>| <reset><#FF0000>Invalid gamemode.");
            Component NoPermission = MiniMessage.miniMessage().deserialize("<#FF0000>You do not have permission to use this command.");
            if (args.length > 0) {
                if (p.hasPermission("deekasurvival.gamemode.use")) {
                    String gamemodeInput = args[0].toUpperCase();
                    GameMode gameMode = getGameModeFromString(gamemodeInput);
                    if (args.length > 1) {
                        if (p.hasPermission("deekasurvival.gamemode.others")) {
                            Player t = Bukkit.getPlayer(args[1]);
                            Component ChangedDoneT = MiniMessage.miniMessage().deserialize("<#55ff00><b>Staff Utils <reset><gray><b>| <reset><#AAFFAA>Gamemode of <#55ff00>" + t.getName() + " <#AAFFAA>has been updated to <#55ff00>" + t.getGameMode());
                            Component ChangedFailed = MiniMessage.miniMessage().deserialize("<#55ff00><b>Staff Utils <reset><gray><b>| <reset>" + t + "<#FF0000>is not a valid player.");
                            if (t != null) {
                                if (gameMode != null) {
                                    t.setGameMode(gameMode);
                                    t.sendMessage(ChangedDone);
                                    p.sendMessage(ChangedDoneT);
                                } else {
                                    p.sendMessage(InvalidGamemode);
                                }
                            } else {
                                p.sendMessage(ChangedFailed);
                            }
                        }
                    } else {
                        if (gameMode != null) {
                            p.setGameMode(gameMode);
                            p.sendMessage(ChangedDone);
                        } else {
                            p.sendMessage(InvalidGamemode);
                        }
                    }
                } else {
                    p.sendMessage(NoPermission);
                }
            } else {
                p.sendMessage(InvalidArgument);
            }
        }
        return true;
    }

    private GameMode getGameModeFromString(String gamemode) {
        try {
            // Try to convert the string to a GameMode
            return GameMode.valueOf(gamemode);
        } catch (IllegalArgumentException e) {
            // Return null if the gamemode is not valid
            return null;
        }
    }
}
