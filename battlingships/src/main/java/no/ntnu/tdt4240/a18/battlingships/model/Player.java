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
    private int life;

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    /**
     * @return true if life not equal to 0
     */
    public boolean reduceLife() {
        this.life--;
        if (life <= 0) {
            return false;
        }
        return true;
    }

    public Player(String username) {
        this.username = username;
        this.ready = false;
        this.life = 3;

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
