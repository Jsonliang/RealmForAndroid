package com.jsonliang.realmforandroid.ui;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.jsonliang.realmforandroid.R;
import com.jsonliang.realmforandroid.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.btn_add)
    Button btnAdd;
    @BindView(R.id.btn_query)
    Button btnQuery;
    @BindView(R.id.btn_async)
    Button btnAsync;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;
    @BindView(R.id.toolbar)
    Toolbar toolbar;


    @OnClick({R.id.btn_add, R.id.btn_query, R.id.btn_async})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                break;
            case R.id.btn_query:
                Intent intent  = new Intent(MainActivity.this,ListActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_async:
                break;
        }
    }

    @Override
    protected void initViewAndEvent() {
        toolbar.setTitle("DemoRealm");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

}
