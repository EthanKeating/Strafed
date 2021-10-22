package me.eths.tab;

import com.viaversion.viaversion.api.Via;
import me.eths.tab.entry.TabElement;
import me.eths.tab.entry.TabElementHandler;
import me.eths.tab.skin.SkinType;
import me.eths.util.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class TabImpl implements TabElementHandler {

    /**
     * Get the tab element of a player
     *
     * @param player the player
     * @return the element
     */
    @Override
    public TabElement getElement(Player player) {
        final TabElement element = new TabElement();

        int ping = ((CraftPlayer) player).getHandle().ping;

        element.add(1, 1, ChatColor.get("   &6&lStrafed &7┃ &fKits"), -1, SkinType.ORANGE);
        element.add(1, 2, ChatColor.get("     1/100 online"), -1, SkinType.ORANGE);

        return element;
    }
}