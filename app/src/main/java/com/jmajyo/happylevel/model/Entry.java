package com.jmajyo.happylevel.model;

import java.util.Date;

import io.realm.RealmObject;

public class Entry extends RealmObject{

    private Date date;
    private int state;

    public Entry() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}

