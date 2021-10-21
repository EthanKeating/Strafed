package me.eths.util;

import lombok.experimental.UtilityClass;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

@UtilityClass
public class ItemBuilder {

    public ItemStack get(ItemStack itemType, String name, List<String> lore, boolean unbreakable) {
        ItemMeta meta = itemType.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lore);
        meta.spigot().setUnbreakable(unbreakable);
        itemType.setItemMeta(meta);
        return itemType;
    }

    public ItemStack get(ItemStack itemType, String name, boolean unbreakable) {
        ItemMeta meta = itemType.getItemMeta();
        meta.setDisplayName(name);
        meta.spigot().setUnbreakable(unbreakable);
        itemType.setItemMeta(meta);
        return itemType;
    }

}
