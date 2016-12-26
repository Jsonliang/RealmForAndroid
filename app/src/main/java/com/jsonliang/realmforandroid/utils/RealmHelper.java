package com.jsonliang.realmforandroid.utils;

import android.content.Context;

import com.jsonliang.realmforandroid.entity.User;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;


/**
 * Created by Jsonliang on 2016/11/4.
 */

public class RealmHelper<T extends RealmObject> {
    public static final  String DB_NAME = "myRealm.realm";
    private  Realm realm ;
    private static RealmHelper helper ;
    private RealmHelper(Context context){
       realm = Realm.getDefaultInstance() ;
    }

    public static RealmHelper getInstance(Context context){
        if(helper == null){
            synchronized(RealmHelper.class){
                if(helper == null){
                    helper = new  RealmHelper(context);
                }
            }
        }

        return helper ;
    }

    /**
     * 添加,如果存在就覆盖
     * @param t
     */
    public void add(T t){
     realm.beginTransaction();
     realm.copyToRealmOrUpdate(t);// 如果已经存在就覆盖
     realm.commitTransaction();
    }

    /**
     * 删除
     * @param userId
     * @param t
     */
    public void delete(int userId,T t){
        realm.beginTransaction();
        realm.where(t.getClass())
                .equalTo("userId",userId)
                .findFirst()
                .deleteFromRealm();
        realm.commitTransaction();

    }

    public void update(){

    }

    /**
     * 查询所有
     * @return
     */
    public List<T> queryAll(Class t){
        List<T> users= realm.where(t).findAll();
        return users;
    }

    public Realm getRealm(){
        return  realm ;
    }

    public void close(){
        if(realm != null){
            realm.close();
        }
    }

    /**
     * 通过主键判断保存对象是否存在
     * @param key
     * @param id
     * @param t
     * @return
     */
    public boolean isExist(String key,int id,T t){
       T tt = (T) realm.where(t.getClass()).equalTo(key,id).findFirst();
        if (tt==null){
            return false;
        }else {
            return  true;
        }
    }
}
