package com.tynh.studentmanagement.helper;

import android.content.Context;
import android.util.Log;

import com.tynh.studentmanagement.models.Data;
import com.tynh.studentmanagement.models.DataModel;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

public class RealmHelper {

    private static final String TAG = "RealmHelper";

    private Realm realm;
    private RealmResults<Data> realmResult;

    /**
     * constructor to create instance realm
     *
     * @param context
     */
    public RealmHelper(Context context) {
        Realm.init(context);
        realm = Realm.getDefaultInstance();
    }

    /**
     * add data
     *
     * @param title
     * @param description
     */
    public void addArticle(String title, String description) {
        Data article = new Data();
        article.setId((int) (System.currentTimeMillis() / 1000));
        article.setTitle(title);
        article.setDescription(description);

        realm.beginTransaction();
        realm.copyToRealm(article);
        realm.commitTransaction();

        showLog("Added ; " + title);
    }

    /**
     * methodto find all data
     */
    public ArrayList<DataModel> findAllArticle() {
        ArrayList<DataModel> data = new ArrayList<>();

        realmResult = realm.where(Data.class).findAll();
        realmResult.sort("id", Sort.DESCENDING);
        showLog("Size : " + String.valueOf(realmResult.get(0).getTitle()));

        for (int i = 0; i < realmResult.size(); i++) {
            String title, description;
            int id = realmResult.get(i).getId();
            title = realmResult.get(i).getTitle();
            description = realmResult.get(i).getDescription();
            data.add(new DataModel(id, title, description));
        }

        return data;
    }

    /**
     * method update data
     *
     * @param id
     * @param title
     * @param description
     */
    public void updateArticle(int id, String title, String description) {
        realm.beginTransaction();
        Data article = realm.where(Data.class).equalTo("id", id).findFirst();
        article.setTitle(title);
        article.setDescription(description);
        realm.commitTransaction();
        showLog("Updated : " + title);
    }

    /**
     * method delete data by id
     *
     * @param id
     */
    public void deleteData(int id) {
//        RealmResults<Data> dataDesults = realm.where(Data.class).equalTo("id", id).findAll();
//        realm.beginTransaction();
//        dataDesults.remove(0);
//        dataDesults.removeLast();
//        dataDesults.clear();
//        realm.commitTransaction();
    }

    /**
     * create log
     *
     * @param s
     */
    private void showLog(String s) {
        Log.d(TAG, s);
    }
}