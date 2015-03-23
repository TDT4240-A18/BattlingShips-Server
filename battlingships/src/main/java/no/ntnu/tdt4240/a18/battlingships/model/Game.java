package no.ntnu.tdt4240.a18.battlingships.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This file is part of battlingships
 * <p/>
 * Created by FanChun & GuoJunjun on March 17, 2015.
 */
public class Game {
    private String[][] board;
    private List<String> playerlist;
    private int state;

    public Game(String username) {
        this.playerlist = new ArrayList<>();
        playerlist.add(username);
    }

    public Game(String[][] board, List<String> playerlist, int state) {
        this.board = board;
        this.playerlist = playerlist;
        this.state = state;
    }

    public String[][] getBoard() {
        return board;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }

    public List<String> getPlayerlist() {
        return playerlist;
    }

    public void setPlayerlist(List<String> playerlist) {
        this.playerlist = playerlist;
    }

    public void addPlayer(String username) {
        this.playerlist.add(username);
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {

        return "new game: " + playerlist.toString();
    }
}
