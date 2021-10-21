package me.eths.util;

import lombok.experimental.UtilityClass;
import me.eths.player.sPlayer;
import org.bukkit.GameMode;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.util.Vector;

@UtilityClass
public class PlayerUtil {

    public void refresh(Player player) {
        ((CraftPlayer) player).getHandle().getDataWatcher().watch(9, (byte) 0);

        for(PotionEffect effect : player.getActivePotionEffects()) {
            player.removePotionEffect(effect.getType());
        }
        player.setFlying(false);
        player.setGameMode(GameMode.SURVIVAL);
        player.setVelocity(new Vector(0, 0, 0));
        player.setMaximumNoDamageTicks(18);
        player.setSaturation(20f);
        player.setAllowFlight(false);
        player.setFoodLevel(20);
        player.setHealth(20f);
        player.setWalkSpeed(0.2f);
        player.setFireTicks(0);
        player.setNoDamageTicks(0);
        player.getEquipment().clear();
        player.getInventory().clear();

    }

    public void refresh(sPlayer player) {
        refresh(player.getPlayer());
    }

}
