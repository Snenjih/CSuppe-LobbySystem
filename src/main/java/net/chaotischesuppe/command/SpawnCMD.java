package net.chaotischesuppe.command;

import net.chaotischesuppe.utils.config.FileConfig;
import net.chaotischesuppe.utils.config.LocationsUtils;
import net.chaotischesuppe.utils.messages.Settings;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SpawnCMD implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player))
            return true;

        Player player = (Player) sender;
        FileConfig spawns = new FileConfig("spawnloc.yml");
        if (label.equalsIgnoreCase("setspawn")) {
            if (player.hasPermission("suppe.command.setspawn")) {
                spawns.set("spawn", LocationsUtils.loc25tr(player.getLocation()));
                spawns.saveConfig();
                player.sendMessage(Settings.prefix + "§7Du hast den §eSpawn §7gesetzt.");
                return true;
            } else {
                player.sendMessage(Settings.noperm);
            }
            return true;
        }

        if (spawns.contains("spawn")) {
            LocationsUtils.teleport(player, LocationsUtils.str2Loc(spawns.getString("spawn")));
        } else {
            player.sendMessage(Settings.prefix + "§7Es wurde §ckein Spawn §7gesetzt.");
        }

        return true;

    }
}
