package no.ntnu.tdt4240.a18.battlingships.model;

/**
 * This file is part of battlingships
 * <p/>
 * Created by FanChun & GuoJunjun on March 24, 2015.
 */
public class Player {
    private String username;
    private boolean ready, dead, left;
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
        this.dead = false;
        this.left = false;

    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
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
        if (left) {
            return username + ":" + "left" + ":" + life;
        } else if (dead) {
            return username + ":" + "dead" + ":" + life;
        }

        return username + ":" + ready + ":" + life;
    }
}
