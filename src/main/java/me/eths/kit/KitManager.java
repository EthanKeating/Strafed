package me.eths.kit;

import me.eths.Strafed;
import me.eths.kit.kits.DefaultKit;
import me.eths.util.ChatColor;
import me.eths.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class KitManager implements Listener {

    private final Strafed instance = Strafed.instance;

    public final ArrayList<Kit> kits;

    public KitManager() {
        instance.getServer().getPluginManager().registerEvents(this, instance);

        kits = new ArrayList<>();

        kits.add(new DefaultKit());
    }

    public void openGUI(Player player) {
        Inventory kitGUI = Bukkit.createInventory(null, 36, ChatColor.get("&eKit Selector"));


        for (int i = 0; i < 36; i++) {
            kitGUI.setItem(i, ItemBuilder.get(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15), "", false));
        }

        for (int i = 10; i < 23; i++) {
            kitGUI.setItem(i, ItemBuilder.get(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14), "", false));
            if (i == 17)
                i++;
        }

        int kitSlot = 10;

        for (Kit kit : kits) {

            kitGUI.setItem(kitSlot, kit.getItem());

            kitSlot++;
            if (kitSlot == 17 || kitSlot == 26)
                kitSlot++;
       }

    }

    @EventHandler
    public void kitInventoryClick(InventoryClickEvent e) {
        if (e.getClickedInventory().getName().contains("Kit Selector")) {
            e.setCancelled(true);
        }
    }

}
