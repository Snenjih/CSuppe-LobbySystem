package net.chaotischesuppe.manager;

import net.chaotischesuppe.utils.builder.ItemStackBuilder;
import net.chaotischesuppe.utils.messages.Settings;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class InventoryManager {


    public void giveInventory(Player player) {
        player.getInventory().clear();

        player.getInventory().setItem(0, new ItemStackBuilder(Material.COMPASS)
                .setName(Settings.navigator)
                .toItemStack());

    }


    public void resetData(Player player) {
        player.setGameMode(GameMode.SURVIVAL);
        player.setHealth(20);
        player.performCommand("spawn");
        player.setMaxHealth(20);
    }

}
