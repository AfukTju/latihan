package com.example.afuktju.solutionapp;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.afuktju.solutionapp.greendao.model.DaoMaster;
import com.example.afuktju.solutionapp.greendao.model.DaoSession;

/**
 * Created by AfukTju on 12/11/2016.
 */

public class CustomApplication extends Application {
    public DaoSession daoSession;
    public SQLiteDatabase db;

    @Override
    public void onCreate() {
        super.onCreate();
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "pawoon-db", null);
        db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public SQLiteDatabase getDb() {
        return db;
    }

}
