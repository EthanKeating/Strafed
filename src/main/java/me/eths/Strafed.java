package me.eths;

import lombok.Getter;
import lombok.Setter;
import me.eths.kit.KitManager;
import me.eths.player.PlayerManager;
import org.bukkit.plugin.java.JavaPlugin;

@Getter @Setter
public class Strafed extends JavaPlugin {

    public static Strafed instance;

    private PlayerManager playerManager;
    private KitManager kitManager;

    public void onEnable() {
        instance = this;
        playerManager = new PlayerManager();
        kitManager = new KitManager();
    }

    public void onDisable() {
        playerManager.saveAll();
    }

}
