package com.sajidur.retofit;

import com.google.gson.annotations.SerializedName;

public class Post {
    private int userID;
    private Integer id;
    private String Title;
    @SerializedName("body")
    private String Text;

    public Post(int userID, String title, String text) {
        this.userID = userID;
        Title = title;
        Text = text;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }
}
