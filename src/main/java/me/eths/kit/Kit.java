package me.eths.kit;

import lombok.Getter;
import lombok.Setter;
import me.eths.Strafed;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

@Getter @Setter
public abstract class Kit {

    public final Strafed instance = Strafed.instance;

    public ItemStack item;
    public String name;
    public int level;

    public abstract void give(Player player);
    public abstract void refresh(Player player);
    public abstract void ability(Player player);

}
