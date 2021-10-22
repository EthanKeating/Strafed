package me.eths;

import lombok.Getter;
import lombok.Setter;
import me.eths.game.GameManager;
import me.eths.kit.KitManager;
import me.eths.player.PlayerManager;
import me.eths.tab.TabHandler;
import me.eths.tab.TabImpl;
import org.bukkit.plugin.java.JavaPlugin;

@Getter @Setter
public class Strafed extends JavaPlugin {

    public static Strafed instance;

    private PlayerManager playerManager;
    private KitManager kitManager;
    private GameManager gameManager;
    private TabHandler tabHandler;

    public void onEnable() {
        //new TabHandler(new TabImpl(), this, 20L);
        instance = this;
        playerManager = new PlayerManager();
        kitManager = new KitManager();
        gameManager = new GameManager();
    }

    public void onDisable() {
        playerManager.saveAll();
    }

}
