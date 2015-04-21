package no.ntnu.tdt4240.a18.battlingships.model;


import org.json.JSONException;
import org.json.JSONObject;

/**
 * This file is part of battlingships
 * <p/>
 * Created by FanChun & GuoJunjun on March 23, 2015.
 */
public class Result {

    private String tag;
    private String description;
    private String type;
    private String object;
    private String onPlayer;
    private int state;
    private String activePlayers;
    private String inactivePlayers;

    public Result(
            String tag, String description, String type, String object, String onPlayer, int state,
            String activePlayers, String inactivePlayers) {
        this.tag = tag;
        this.description = description;
        this.type = type;
        this.object = object;
        this.onPlayer = onPlayer;
        this.state = state;
        this.activePlayers = activePlayers;
        this.inactivePlayers = inactivePlayers;
    }

    public Result(String tag, String description, String type, String object, String onPlayer, int state) {
        this.tag = tag;
        this.description = description;
        this.type = type;
        this.object = object;
        this.onPlayer = onPlayer;
        this.state = state;
    }

    public Result(String tag, String description, String type, String object, int state) {
        this.tag = tag;
        this.description = description;
        this.type = type;
        this.object = object;
        this.state = state;
    }

    public Result(String tag, String description) {
        this.tag = tag;
        this.description = description;
        this.type = "";
        this.object = "";
        this.state = 0;
    }

    public Result(String tag, String description, String type, String object) {
        this.tag = tag;
        this.description = description;
        this.type = type;
        this.object = object;
        this.state = 0;
    }


    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getOnPlayer() {
        return onPlayer;
    }

    public void setOnPlayer(String onPlayer) {
        this.onPlayer = onPlayer;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    @Override
    public String toString() {

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("tag", this.tag);
            jsonObject.put("type", this.type);
            jsonObject.put("obj", this.object);
            jsonObject.put("desc", this.description);
            jsonObject.put("state", this.state);
            jsonObject.put("onplayer", this.onPlayer);
            jsonObject.put("active", this.activePlayers);
            jsonObject.put("inactive", this.inactivePlayers);
            return jsonObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}