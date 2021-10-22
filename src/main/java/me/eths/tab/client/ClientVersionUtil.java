package me.eths.tab.client;

import com.viaversion.viaversion.api.Via;
import org.bukkit.entity.Player;

public class ClientVersionUtil {

    /**
     * Get the protocol version of the client.
     * <br>
     * Had to be made because 1.8+ doesn't have a NetworkManager#getVersion method, which is required for legacy support on tab.
     *
     * @param player the player to get the version of
     * @return the version, or -1 if none of the plugins are supported.
     */
    public static int getProtocolVersion(Player player) {
        return Via.getAPI().getPlayerVersion(player.getUniqueId());
    }

}
