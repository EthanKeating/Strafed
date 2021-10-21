package me.eths.player;

import lombok.Getter;
import lombok.Setter;
import me.eths.fastboard.FastBoard;
import org.bukkit.entity.Player;

@Getter @Setter
public class sPlayer {

    private final Player player;
    private final FastBoard board;

    public sPlayer(Player player) {
        this.player = player;
        board = new FastBoard(player);
        load();
    }

    public void load() {

    }

    public void save() {

    }

}
