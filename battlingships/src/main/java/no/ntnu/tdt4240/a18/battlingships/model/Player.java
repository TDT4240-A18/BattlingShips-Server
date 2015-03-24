package no.ntnu.tdt4240.a18.battlingships.model;

/**
 * This file is part of battlingships
 * <p/>
 * Created by FanChun & GuoJunjun on March 24, 2015.
 */
public class Player {
    private String username;
    private boolean ready;
    private int x, y;

    public Player(String username) {
        this.username = username;
        this.ready = false;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public int getX() {
        return x;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return username + " : " + ready;
    }
}
