package com.jsonliang.realmforandroid.entity;

import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * Created by Jsonliang on 2016/11/4.
 */

public class Person extends SectionEntity<String> {

    public Person(boolean isHeader, String header) {
        super(isHeader, header);
    }

    public Person(String o) {
        super(o);
    }
}
