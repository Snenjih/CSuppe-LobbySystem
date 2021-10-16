package net.chaotischesuppe.listener.player;

import net.chaotischesuppe.utils.messages.Settings;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class PlayerInventoryClickListener implements Listener {

    //Spawn
    @EventHandler
    public void Spawn(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getType() == Material.NETHER_STAR) {
            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(Settings.spawn)) {

                player.performCommand("spawn");
                event.setCancelled(true);
            }
        }
    }

}
