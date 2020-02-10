package com.tabibu.desktop;

import com.google.gson.annotations.SerializedName;

public class People {

    @SerializedName("userId")
    private int numb;
    private int id;
    @SerializedName("title")
    private String description;
    @SerializedName("body")
    private String german;

    public int getNumb() {
        return numb;
    }

    public void setNumb(int numb) {
        this.numb = numb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGerman() {
        return german;
    }

    public void setGerman(String german) {
        this.german = german;
    }
}
