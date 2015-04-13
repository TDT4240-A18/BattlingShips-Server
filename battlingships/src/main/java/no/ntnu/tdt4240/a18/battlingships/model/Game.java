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

    /**
     * increase state by 1
     */
    public void nextState() {
        this.state++;
    }

    /**
     * @param x
     * @param y
     *
     * @return true if it is a valid move
     */
    public boolean isValidMove(int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "new game: " + playerlist.toString() + printBoard();
    }

    /**
     * @param username
     *
     * @return true if the username is in the player list
     */
    public boolean isInGame(String username) {
        for (Player p : getPlayerlist()) {
            if (p.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    /**
     * check a user is on moving state
     *
     * @param username
     *
     * @return true if a given name is in the player list and can have a move action
     */
    public boolean isOnMoveState(String username) {
        if (isInGame(username) &&
            this.getPlayerlist().get(this.getState() % (this.getPlayerlist().size()) - 1).getUsername()
                .equalsIgnoreCase(username)) {
            return true;
        }
        return false;
    }

    /**
     * @return true if every one is ready for the game
     */
    public boolean isEveryoneReady() {
        for (Player p : getPlayerlist()) {
            if (!p.isReady()) {
                return false;
            }
        }
        return true;
    }

    /**
     * get player by player name
     *
     * @param username
     *
     * @return Player object
     */
    public Player getPlayer(String username) {
        for (Player p : getPlayerlist()) {
            if (p.getUsername().equals(username)) {
                return p;
            }
        }
        return null;
    }

    /**
     * get player by x, y axis
     *
     * @param x
     * @param y
     *
     * @return Player Instance
     */
    public Player getPlayer(int x, int y) {
        for (Player p : getPlayerlist()) {
            if (p.getX() == x && p.getY() == y) {
                return p;
            }
        }
        return null;
    }

    /**
     * remove a player from player list (dead player)
     *
     * @param player
     */
    public void removePlayer(Player player) {
        playerlist.remove(player);
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

    public String gameInfor() {
        String s = playerlist.toString() + "\nstate: " + state + "\n";

        for (Player p : playerlist) {
            s += p.toString() + "\n";
        }
        return s;
    }
}
