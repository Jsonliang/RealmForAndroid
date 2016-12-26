package com.jsonliang.realmforandroid;

import android.app.Application;
import android.content.Context;

import io.realm.Realm;
import io.realm.RealmCollection;
import io.realm.RealmConfiguration;

/**
 * Created by Jsonliang on 2016/11/4.
 */

public class App extends Application {
    private static  App instance ;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this ;
        Realm.init(this);
        //自定义文件命名为
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .name("myRealm.realm")
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(configuration);
    }

    public static App getInstance(){
        return instance ;
    }

}
