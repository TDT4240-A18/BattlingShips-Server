package no.ntnu.tdt4240.a18.battlingships.model;

/**
 * This file is part of battlingships
 * <p/>
 * Created by FanChun & GuoJunjun on March 17, 2015.
 */
public class Ship {
    private int life, moveRange, shootRange;
    private int[] shape;
    private String owner;
    private int shipId;
    private int level;

    public Ship(int life, int moveRange, int shootRange, int[] shape, String owner, int shipId) {
        this.life = life;
        this.moveRange = moveRange;
        this.shootRange = shootRange;
        this.shape = shape;
        this.owner = owner;
        this.shipId = shipId;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getMoveRange() {
        return moveRange;
    }

    public void setMoveRange(int moveRange) {
        this.moveRange = moveRange;
    }

    public int getShootRange() {
        return shootRange;
    }

    public void setShootRange(int shootRange) {
        this.shootRange = shootRange;
    }

    public int[] getShape() {
        return shape;
    }

    public void setShape(int[] shape) {
        this.shape = shape;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getShipId() {
        return shipId;
    }

    public void setShipId(int shipId) {
        this.shipId = shipId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
