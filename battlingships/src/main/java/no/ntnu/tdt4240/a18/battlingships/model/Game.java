package no.ntnu.tdt4240.a18.battlingships.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This file is part of battlingships
 * <p/>
 * Created by FanChun & GuoJunjun on March 17, 2015.
 */
public class Game {
    private Player[][] board;
    private List<Player> playerlist;
    private int state;

    public Game(String username) {
        this.state = 0;
        this.playerlist = new ArrayList<>();
        playerlist.add(new Player(username));
    }

    public Game(Player[][] board, List<Player> playerlist, int state) {
        this.state = 0;
        this.board = board;
        this.playerlist = playerlist;
        this.state = state;
    }

    public Player[][] getBoard() {
        return board;
    }

    public void setBoard(Player[][] board) {
        this.board = board;
    }

    public List<Player> getPlayerlist() {
        return playerlist;
    }

    public void setPlayerlist(List<Player> playerlist) {
        this.playerlist = playerlist;
    }

    public void addPlayer(String username) {
        this.playerlist.add(new Player(username));
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "new game: " + playerlist.toString() + printBoard();
    }

    public boolean isInGame(String username) {
        for (Player p : getPlayerlist()) {
            if (p.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEveryoneReady() {
        for (Player p : getPlayerlist()) {
            if (!p.isReady()) {
                return false;
            }
        }
        return true;
    }

    public Player getPlayer(String username) {
        for (Player p : getPlayerlist()) {
            if (p.getUsername().equals(username)) {
                return p;
            }
        }
        return null;
    }

    public String printBoard() {
        String b = "";
        if (board != null) {
            for (int i = 0; i < board.length; i++) {
                b += (i + 1) + ":[ ";
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == null) {
                        b += "null; ";
                    } else {
                        b += board[i][j].getUsername() + "; ";
                    }
                }
                b += " ] ";
            }
        }
        return b;
    }
}
