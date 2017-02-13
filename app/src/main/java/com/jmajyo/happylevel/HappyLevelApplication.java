package com.jmajyo.happylevel;

import android.app.Application;

import io.realm.Realm;

public class HappyLevelApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        //inicializo realm
        Realm.init(this);
    }
}
