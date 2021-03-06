package no.ntnu.tdt4240.a18.battlingships.service;

import no.ntnu.tdt4240.a18.battlingships.model.Game;
import no.ntnu.tdt4240.a18.battlingships.model.Player;
import no.ntnu.tdt4240.a18.battlingships.model.Result;

import java.util.ArrayList;
import java.util.Random;

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
        game.addPlayer(username);
        return game;
    }

    public Game ready(Game game, String username) {
        if (!game.isInGame(username)) {
            return null;
        } else {
            game.getPlayer(username).setReady(true);
            if (game.isEveryoneReady() && game.getPlayerlist().size() > 1) {
                int boardsize = 4;
                ArrayList list = new ArrayList();
                for (int i = 0; i < boardsize; i++) {
                    list.add(i);
                }
                for (Player p : game.getPlayerlist()) {
                    p.setXY(
                            (int) list.remove((int) (Math.random() * list.size())), (int) (Math.random() * boardsize));
                }
                game.setBoard(boardsize);
                game.setState(1);
            }
            return game;
        }
    }

    /**
     * a player leave the game: remove the player from player list
     *
     * @param game
     * @param username
     *
     * @return
     */
    public Game leave(Game game, String username) {
        if (game.getState() == 0) {
            game.removePlayerBS(game.getPlayer(username));
        } else {
            Player player = (game.getPlayer(username));
            player.setLeft(true);
            game.removePlayer(player);
            if (game.getPlayerlist().size() == 0) {
                game = null;
            }
        }
        return game;
    }

    /**
     * @param game
     * @param username
     *
     * @return null if player not in the game or game not started; the player who is on action
     */
    public String check(Game game, String username) {
        if (!game.isInGame(username)) {
            return null;
        }
        if (game.getState() == 0) {
            return null;
        } else {
            return game.getPlayerlist().get(game.getState() % (game.getPlayerlist().size())).getUsername();
        }
    }
}
