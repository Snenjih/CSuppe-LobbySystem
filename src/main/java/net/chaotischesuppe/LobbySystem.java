package net.chaotischesuppe;

import net.chaotischesuppe.command.SpawnCMD;
import net.chaotischesuppe.listener.EventsListener;
import net.chaotischesuppe.listener.player.Navigator;
import net.chaotischesuppe.listener.player.PlayerInventoryClickListener;
import net.chaotischesuppe.listener.player.PlayerJoinListener;
import net.chaotischesuppe.manager.InventoryManager;
import net.chaotischesuppe.manager.Inventorys;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class LobbySystem extends JavaPlugin {

    private static LobbySystem instance;
    private InventoryManager inventoryManager;
    private Inventorys inventorys;

    @Override
    public void onLoad() {
        instance = this;
        inventoryManager = new InventoryManager();
        inventorys = new Inventorys();
    }

    @Override
    public void onEnable() {
        PluginManager pluginManager = Bukkit.getPluginManager();

        getCommand("spawn").setExecutor(new SpawnCMD());
        pluginManager.registerEvents(new EventsListener(),this);
        pluginManager.registerEvents(new PlayerJoinListener(),this);
        pluginManager.registerEvents(new PlayerInventoryClickListener(),this);
        pluginManager.registerEvents(new Navigator(),this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static LobbySystem getInstance() {
        return instance;
    }

    public InventoryManager getInventoryManager() {
        return inventoryManager;
    }

    public Inventorys getInventorys() {
        return inventorys;
    }

}
