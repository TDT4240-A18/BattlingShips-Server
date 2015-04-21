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
    private List<Player> playerlistInactive;
    private int state;

    public Game(String username) {
        this.state = 0;
        this.playerlist = new ArrayList<>();
        playerlist.add(new Player(username));
        this.playerlistInactive = new ArrayList<Player>();
    }

    //    public Game(Player[][] board, List<Player> playerlist, int state) {
    //    public Game(int boardsize, List<Player> playerlist, int state) {
    //        this.state = 0;
    //        this.board = new Player[boardsize][boardsize];
    //        this.playerlist = playerlist;
    //        this.state = state;
    //        this.playerlistInactive = new ArrayList<Player>();
    //    }

    /**
     * @return the updated board filled with players
     */
    public Player[][] getBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = null;
            }
        }
        for (Player p : playerlist) {
            board[p.getX()][p.getY()] = p;
        }
        return board;
    }

    public void setBoard(int boardsize) {
        this.board = new Player[boardsize][boardsize];
    }
    //    public void setBoard(Player[][] board) {
    //        this.board = board;
    //    }

    public List<Player> getPlayerlist() {
        return playerlist;
    }

    public void setPlayerlist(List<Player> playerlist) {
        this.playerlist = playerlist;
    }

    public List<Player> getPlayerlistInactive() {
        return playerlistInactive;
    }

    public void addPlayerlistInactive(List<Player> playerlistInactive) {
        this.playerlistInactive = playerlistInactive;
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
        if (x < 0 || x >= 4 || y < 0 || y >= 4) {
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
            this.getPlayerlist().get(this.getState() % (this.getPlayerlist().size())).getUsername()
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
     * remove a player from player list (dead player or player left the game)
     *
     * @param player
     */
    public void removePlayer(Player player) {
        playerlistInactive.add(player);
        playerlist.remove(player);
    }

    //    public String printBoard() {
    //        String b = "";
    //        if (board != null) {
    //            for (int i = 0; i < board.length; i++) {
    //                b += (i + 1) + ":[ ";
    //                for (int j = 0; j < board[i].length; j++) {
    //                    if (board[i][j] == null) {
    //                        b += "null; ";
    //                    } else {
    //                        b += board[i][j].getUsername() + "; ";
    //                    }
    //                }
    //                b += " ] ";
    //            }
    //        }
    //        return b;
    //    }

    public String printBoard() {
        String b = "";
        if (getBoard() != null) {
            for (int i = 0; i < getBoard().length; i++) {
                b += ":[";
                for (int j = 0; j < getBoard()[i].length; j++) {
                    if (getBoard()[i][j] == null) {
                        b += "null;";
                    } else {
                        b += getBoard()[i][j].getUsername() + ";";
                    }
                }
                b += "]";
            }
        }
        return b;
    }

    public String gameInfor() {
        //game not started
        if (state == 0) {
            return playerlist.toString();
        }
        if (playerlist.size() == 1) {
            return "infor: " + "game started # " + "board: " + printBoard() + " # on player: " +
                   getPlayerlist().get(0) +
                   " # on state: " + getState() +
                   " player " +
                   "list: " + getPlayerlist().toString() + " # inactive player list: " +
                   getPlayerlistInactive().toString();
        }
        return "infor: " + "game started # " + "board: " + printBoard() + " # on player: " + (getPlayerlist().get(
                getState() % (getPlayerlist().size())).getUsername()) + " # on state: " + getState() + " player " +
               "list: " + getPlayerlist().toString() + " # inactive player list: " + getPlayerlistInactive().toString();
    }
}
