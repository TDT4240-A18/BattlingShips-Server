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
        if (game.isInGame(username)) {
            return null;
        } else {
            game.addPlayer(username);
            return game;
        }
    }

    public Game ready(Game game, String username) {
        if (!game.isInGame(username)) {
            return null;
        } else {
            game.getPlayer(username).setReady(true);
            if (game.isEveryoneReady()) {
                Player[][] board = new Player[4][game.getPlayerlist().size()];
                ArrayList list = new ArrayList();
                for (int i = 0; i < board.length; i++) {
                    list.add(i);
                }
                for (Player p : game.getPlayerlist()) {
                    board[(int) list.remove((int) Math.random() * list.size())][(int) Math.random() * board[0].length]
                            = p;
                }
                game.setBoard(board);
                game.setState(1);
            }
            return game;
        }
    }

    public String check(Game game, String username) {
        if (!game.isInGame(username)) {
            return null;
        }
        if (game.getState() == 0) {
            return null;
        } else {
            return game.getPlayerlist().get(game.getState() % (game.getPlayerlist().size()) - 1).getUsername();
        }
    }
}
