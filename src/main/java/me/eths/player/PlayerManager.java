package me.eths.player;

import lombok.Getter;
import me.eths.Strafed;
import me.eths.tab.TabHandler;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

@Getter
public class PlayerManager implements Listener {

    private final Strafed instance = Strafed.instance;
    private HashMap<Player, sPlayer> players;

    public PlayerManager() {
        instance.getServer().getPluginManager().registerEvents(this, instance);
        players = new HashMap<>();

        new BukkitRunnable() {
            @Override
            public void run() {
                saveAll();
            }
        }.runTaskTimerAsynchronously(instance, 1200, 1200);

    }

    public void saveAll() {
        for (sPlayer player : players.values()) {
            player.save();
        }
    }


    public void createPlayer(Player player) {
        if (players.containsKey(player))
            players.remove(player);
        players.put(player, new sPlayer(player));

    }

    public void deletePlayer(Player player) {
        sPlayer pl = players.get(player);
        if (players.containsKey(player)) {
            pl.getGame().leave(pl);
            players.remove(player);
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        e.setJoinMessage("");
        createPlayer(e.getPlayer());
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        e.setQuitMessage("");
        deletePlayer(e.getPlayer());
    }

}
