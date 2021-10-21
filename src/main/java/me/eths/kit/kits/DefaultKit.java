package me.eths.kit.kits;

import me.eths.kit.Kit;
import me.eths.util.ChatColor;
import me.eths.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class DefaultKit extends Kit {

    public DefaultKit() {
        name = "Default";
        level = 1;
        item = ItemBuilder.get(new ItemStack(Material.GOLD_SWORD),
                ChatColor.get("&eDefault Kit"),
                ChatColor.get(Arrays.asList("&7Fight like a normal", "player, SO BORING")),
                false);
    }


    @Override
    public void give(Player player) {
        Inventory playerInv = player.getInventory();
        playerInv.clear();

        playerInv.setItem(0, ItemBuilder.get(new ItemStack(Material.STONE_SWORD, 1), "", true));
        playerInv.setItem(1, ItemBuilder.get(new ItemStack(Material.GOLDEN_APPLE, 1), "", true));
        playerInv.setItem(2, ItemBuilder.get(new ItemStack(Material.FISHING_ROD, 1), "", true));

    }

    @Override
    public void refresh(Player player) {

    }

    @Override
    public void ability(Player player) {

    }
}
