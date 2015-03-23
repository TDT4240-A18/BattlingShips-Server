package no.ntnu.tdt4240.a18.battlingships.service;

/**
 * This file is part of battlingships
 * <p/>
 * Created by FanChun & GuoJunjun on March 17, 2015.
 */
public class ActionService {
    public String move(String username, int x, int y) {
        return "move";
    }

    public String shoot(String username, int x, int y) {
        return "shoot";
    }

    public String doNothing(String username) {
        return "do nothing";
    }

    public String check(String username) {
        return "check";
    }
}
