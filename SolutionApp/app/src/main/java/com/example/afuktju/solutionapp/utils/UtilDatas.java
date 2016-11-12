package com.example.afuktju.solutionapp.utils;

import android.content.Context;
import android.widget.Toast;

import com.example.afuktju.solutionapp.CustomApplication;
import com.example.afuktju.solutionapp.activity.CoreServiceActivity;
import com.example.afuktju.solutionapp.greendao.model.DaoMaster;
import com.example.afuktju.solutionapp.greendao.model.DaoSession;
import com.example.afuktju.solutionapp.greendao.model.DtbPost;
import com.example.afuktju.solutionapp.greendao.model.DtbPostDao;

import java.util.List;

/**
 * Created by AfukTju on 12/11/2016.
 */

public class UtilDatas {

    public static void insertOrReplaceDtbPost(Context context, DtbPost dtbPost) {
        if (dtbPost == null) return;
        DaoSession daoSession = (((CustomApplication) context).getDaoSession());
        DtbPostDao dtbPostDao = daoSession.getDtbPostDao();
        dtbPostDao.insertOrReplace(dtbPost);
    }

    public static void insertOrReplaceDtbPost(Context context, List<DtbPost> dtbPostList) {
        if (dtbPostList == null) return;
        DaoSession daoSession = (((CustomApplication) context).getDaoSession());
        DtbPostDao dtbPostDao = daoSession.getDtbPostDao();
        dtbPostDao.insertOrReplaceInTx(dtbPostList);
    }

    public static List<DtbPost> getPosts(Context context) {
        DaoSession daoSession = (((CustomApplication) context).getDaoSession());
        DtbPostDao dtbSettingDao = daoSession.getDtbPostDao();
        return dtbSettingDao.queryBuilder().list();
    }

    public final static void truncateDB(Context context) {
        DaoSession daoSession = (((CustomApplication) context).getDaoSession());
        DaoMaster.dropAllTables(daoSession.getDatabase(), true);
        DaoMaster.createAllTables(daoSession.getDatabase(), true);
        Toast.makeText(context,"clear data success",Toast.LENGTH_SHORT).show();
    }
}
