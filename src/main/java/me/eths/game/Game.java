package me.eths.game;

import lombok.Getter;
import lombok.Setter;
import me.eths.Strafed;
import me.eths.player.sPlayer;

import java.util.ArrayList;

@Getter @Setter
public abstract class Game {

    private final Strafed instance = Strafed.instance;

    private ArrayList<sPlayer> players = new ArrayList<>();

    public abstract void join(sPlayer player);
    public abstract void leave(sPlayer player);
    public abstract void tick();

}
