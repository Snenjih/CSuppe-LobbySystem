package net.chaotischesuppe.listener.player;

import net.chaotischesuppe.LobbySystem;
import net.chaotischesuppe.utils.messages.Settings;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(null);
        player.sendTitle("§6§lChaotischeSuppe", "§c§lWilkommen!", 20, 60, 20);
        player.setGameMode(GameMode.SURVIVAL);

        LobbySystem.getInstance().getInventoryManager().giveInventory(player);
        LobbySystem.getInstance().getInventoryManager().resetData(player);


    }


    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        event.setQuitMessage("");

    }

}
