package net.chaotischesuppe.listener.player;

import net.chaotischesuppe.utils.builder.ItemStackBuilder;
import net.chaotischesuppe.utils.messages.Settings;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import java.util.Set;

public class Navigator implements Listener {


    public void open(Player player) {

        Inventory inventory = Bukkit.createInventory(null, 3 * 9, "§8» §aNavigator");

        for(int i = 0; i < inventory.getSize(); i++) {
            inventory.setItem(i , new ItemStackBuilder(Material.GRAY_STAINED_GLASS_PANE).setName("§0").toItemStack());
        }


        inventory.setItem(13, new ItemStackBuilder(Material.NETHER_STAR)
                .setName(Settings.spawn)
                .toItemStack());



        player.openInventory(inventory);
    }



    @EventHandler
    private void onInteract(PlayerInteractEvent event) {
        if (event.getItem() == null) return;
        if (event.getItem().getType() == Material.COMPASS) {
            if (event.getItem().getItemMeta().getDisplayName().equals(Settings.navigator)) {
                if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
                    open(event.getPlayer());
                    event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, 3, 1);
                    event.setCancelled(true);
                }
            }
        }
    }


}
