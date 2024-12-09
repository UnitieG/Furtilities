package me.deeka.deekaSurvival;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {

    @EventHandler
    public void OnPlayerJoin (PlayerJoinEvent event) {
        String p = event.getPlayer().getName();
        Player player = event.getPlayer();
        Component JoinMSG = MiniMessage.miniMessage().deserialize("<#AAFFAA>" + p + " <#55ff00>has joined the game!");

        event.joinMessage(JoinMSG);
        Component DataF = MiniMessage.miniMessage().deserialize("<#55ff00>Data Folder:" + DeekaSurvival.getInstance().getDataFolder());
        player.sendMessage(DataF);

    }

    @EventHandler
    public void OnPlayerQuit (PlayerQuitEvent event) {
        String p = event.getPlayer().getName();
        Player player = event.getPlayer();
        Component QuitMSG = MiniMessage.miniMessage().deserialize("<#ff4e3b>" + p + " <#FF0000>has left the game!");

        event.quitMessage(QuitMSG);
    }
}
