package me.eths.kit.kits;

import me.eths.kit.Kit;
import me.eths.util.ChatColor;
import me.eths.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;

public class DefaultKit extends Kit implements Listener {

    public DefaultKit() {

        instance.getServer().getPluginManager().registerEvents(this, instance);

        name = "Default";
        level = 1;
        item = ItemBuilder.get(new ItemStack(Material.GOLD_SWORD),
                ChatColor.get("&eDefault Kit"),
                ChatColor.get(Arrays.asList("&7Fight like a normal", "player, SO BORING")),
                false);
    }


    @Override
    public void give(Player player) {

        PlayerInventory playerInv = player.getInventory();

        playerInv.clear();

        playerInv.setItem(0, ItemBuilder.get(new ItemStack(Material.STONE_SWORD, 1), "", true));
        playerInv.setItem(1, ItemBuilder.get(new ItemStack(Material.GOLDEN_APPLE, 1), "", true));
        playerInv.setItem(2, ItemBuilder.get(new ItemStack(Material.FISHING_ROD, 1), "", true));

        playerInv.setChestplate(ItemBuilder.get(new ItemStack(Material.IRON_CHESTPLATE, 1), "", true));
        playerInv.setChestplate(ItemBuilder.get(new ItemStack(Material.IRON_LEGGINGS, 1), "", true));
        playerInv.setBoots(ItemBuilder.get(new ItemStack(Material.GOLD_BOOTS, 1), "", true));

    }

    @Override
    public void refresh(Player player) {

        PlayerInventory playerInv = player.getInventory();

        for (int i = 0; i >= 35; i++) {
            if (playerInv.getItem(i).getType().equals(Material.GOLDEN_APPLE)) {
                playerInv.clear(i);
                playerInv.setItem(i, ItemBuilder.get(new ItemStack(Material.GOLDEN_APPLE, 1), "", true));
            }
        }

    }

    @Override
    public void ability(Player player) {

        player.getItemInHand().setAmount(player.getItemInHand().getAmount() - 1);
        player.playSound(player.getEyeLocation(), Sound.BURP, 1f, 1f);
        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 5, 1));
    }

    @EventHandler
    public void onGoldenApple(PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_AIR) {
            if (e.getPlayer().getInventory().getItemInHand().getType() == Material.GOLDEN_APPLE) {
                ability(e.getPlayer());
            }
        }
    }
}
