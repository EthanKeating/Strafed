package me.eths.game.games;

import me.eths.fastboard.FastBoard;
import me.eths.game.Game;
import me.eths.player.sPlayer;
import me.eths.util.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;

public class KitPVP extends Game implements Listener {

    public KitPVP() {
        getInstance().getServer().getPluginManager().registerEvents(this, getInstance());
    }

    @Override
    public void join(sPlayer player) {
        if (!getPlayers().contains(player))
            getPlayers().add(player);

    }

    @Override
    public void leave(sPlayer player) {
        if (getPlayers().contains(player))
            getPlayers().remove(player);
    }

    @Override
    public void tick() {
        if (getPlayers().size() > 0) {
            ArrayList<String> lines = new ArrayList<>();
            FastBoard board;
            for (sPlayer player : getPlayers()) {
                lines.clear();
                board = player.getBoard();

                board.updateTitle(ChatColor.get("&6&lStrafed &7┃ &fKits"));

                lines.add(ChatColor.get("&7&m------------------"));
                lines.add(ChatColor.get("&fKills: &6null"));
                lines.add(ChatColor.get("&fKillstreak: &6null &e(null)"));
                lines.add(ChatColor.get("&fDeaths: &6null"));
                lines.add(ChatColor.get("&fLevel: &6null &e(null%)"));
                lines.add(ChatColor.get(""));
                lines.add(ChatColor.get("&fstrafed.us"));
                lines.add(ChatColor.get("&7&m------------------"));

                board.updateLines(lines);
            }
        }

    }

    @EventHandler
    public void onPlayerClick(PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (e.getPlayer().getItemInHand() != null) {
                if (e.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains("Kit Selector")) {
                    getInstance().getKitManager().openGUI(e.getPlayer());
                }

            }
        }
    }

}
