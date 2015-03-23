package no.ntnu.tdt4240.a18.battlingships.model;


import org.json.JSONException;
import org.json.JSONObject;

/**
 * This file is part of battlingships
 * <p/>
 * Created by FanChun & GuoJunjun on March 23, 2015.
 */
public class Result {

    private String tag, description, type, object;

    public Result(String tag, String description) {
        this.tag = tag;
        this.description = description;
        this.type = "";
        this.object = "";
    }

    public Result(String tag, String description, String type, String object) {
        this.tag = tag;
        this.description = description;
        this.type = type;
        this.object = object;
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
            return jsonObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}