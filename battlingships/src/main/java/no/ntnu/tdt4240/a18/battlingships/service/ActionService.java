package no.ntnu.tdt4240.a18.battlingships.service;

import no.ntnu.tdt4240.a18.battlingships.model.Game;
import no.ntnu.tdt4240.a18.battlingships.model.Player;

/**
 * This file is part of battlingships
 * <p/>
 * Created by FanChun & GuoJunjun on March 17, 2015.
 */
public class ActionService {

    public Game move(Game game, String username, int x, int y) {
        if (game.isOnMoveState(username) && game.isValidMove(x, y)) {
            if (game.getPlayer(x, y) == null) {
                Player p = game.getPlayer(username);
                p.setXY(x, y);// set new position to Player
            }
            game.nextState();
            return game;
        }
        return null;
    }

    /**
     * @param game
     * @param username
     * @param x
     * @param y
     *
     * @return shoot result
     */
    public String shoot(Game game, String username, int x, int y) {
        if (game.isValidMove(x, y)) {
            game.nextState();
            Player p = game.getPlayer(x, y);
            if (p != null) {
                if (!p.reduceLife()) {
                    p.setDead(true);
                    game.removePlayer(p);
                    return p.getUsername() + " dead !";
                }
            }
        }
        return "";
    }

    public Game doNothing(Game game, String username) {
        game.nextState();
        return game;
    }

    public String check(String username) {
        return "check";
    }
}
