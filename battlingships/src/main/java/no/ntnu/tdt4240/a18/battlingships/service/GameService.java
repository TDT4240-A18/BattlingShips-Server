package no.ntnu.tdt4240.a18.battlingships.service;

import no.ntnu.tdt4240.a18.battlingships.model.Game;

/**
 * This file is part of battlingships
 * <p/>
 * Created by FanChun & GuoJunjun on March 17, 2015.
 */
public class GameService {

    public Game create(String username) {
        return new Game(username);
    }

    public Game join(Game game, String username) {
        if (game.getPlayerlist().contains(username)) {
            return null;
        } else {
            game.addPlayer(username);
            return game;
        }
    }
}
