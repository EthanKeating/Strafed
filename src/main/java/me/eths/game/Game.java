package me.eths.game;

import lombok.Getter;
import lombok.Setter;
import me.eths.player.sPlayer;

import java.util.ArrayList;

@Getter @Setter
public abstract class Game {

    private ArrayList<sPlayer> players = new ArrayList<>();

    public abstract void join();
    public abstract void leave();
    public abstract void tick();

}
