package me.eths.player;

import lombok.Getter;
import lombok.Setter;
import me.eths.Strafed;
import me.eths.fastboard.FastBoard;
import me.eths.game.Game;
import org.bukkit.entity.Player;

@Getter @Setter
public class sPlayer {

    private final Strafed instance = Strafed.instance;

    private final Player player;
    private final FastBoard board;
    private Game game;

    public sPlayer(Player player) {
        this.player = player;
        board = new FastBoard(player);
        setGame(instance.getGameManager().getGameKitPVP());
        load();
    }

    public void load() {

    }

    public void save() {

    }

    public void setGame(Game game) {
        this.game = game;
        game.join(this);
    }

}
