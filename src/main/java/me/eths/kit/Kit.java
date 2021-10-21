package me.eths.kit;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@Getter @Setter
public abstract class Kit {

    public ItemStack item;
    public String name;
    public int level;

    public abstract void give(Player player);
    public abstract void refresh(Player player);
    public abstract void ability(Player player);

}
