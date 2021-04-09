package com.upgrad.technicalblogpost.model;

import javax.persistence.JoinColumn;
import java.util.Date;


public class Post {
    //Id is missing, it needs to be present here
    private String title;
    private String body;
    private Date date;

    //User Object
    @JoinColumn
    private User user_id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
