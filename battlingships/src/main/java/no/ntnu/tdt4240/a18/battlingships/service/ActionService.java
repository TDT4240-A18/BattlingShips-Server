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
            Player p = game.getPlayer(username);
            game.getBoard()[p.getX()][p.getY()] = null; // set players board position null
            p.setXY(x, y);// set new position to Player
            game.getBoard()[p.getX()][p.getY()] = p; // set new board position to player
            game.nextState();
            return game;
        }
        return null;
    }

    public String shoot(String username, int x, int y) {
        return "shoot";
    }

    public String doNothing(String username) {
        return "do nothing";
    }

    public String check(String username) {
        return "check";
    }
}
