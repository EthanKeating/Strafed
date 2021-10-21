package me.eths.game;

import lombok.Getter;
import lombok.Setter;
import me.eths.Strafed;
import me.eths.game.games.KitPVP;
import me.eths.game.games.Practice;
import org.bukkit.scheduler.BukkitRunnable;

@Setter @Getter
public class GameManager {

    private final Strafed instance = Strafed.instance;

    private final KitPVP gameKitPVP;
    private final Practice gamePractice;

    public GameManager() {
        gameKitPVP = new KitPVP();
        gamePractice = new Practice();

        new BukkitRunnable() {
            @Override
            public void run() {
                gameKitPVP.tick();
                gamePractice.tick();
            }
        }.runTaskTimerAsynchronously(instance, 1, 1);

    }



}
