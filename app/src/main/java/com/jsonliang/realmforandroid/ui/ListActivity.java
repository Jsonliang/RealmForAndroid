package com.jsonliang.realmforandroid.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;

import com.jsonliang.realmforandroid.R;
import com.jsonliang.realmforandroid.adapter.UserAdapter;
import com.jsonliang.realmforandroid.base.BaseActivity;
import com.jsonliang.realmforandroid.entity.User;
import com.jsonliang.realmforandroid.utils.RealmHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Jsonliang on 2016/11/4.
 */

public class ListActivity extends BaseActivity {
    @BindView(R.id.targetView)
    LinearLayout targetView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private List<User> users = new ArrayList<>();
    private UserAdapter adapter ;
    RealmHelper<User> realmHelper = RealmHelper.getInstance(this) ;

    @Override
    protected void initViewAndEvent() {
        setToolbar(toolbar,"查询");
     //   initData();
        initRecyclerView();
    }

    private void initRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        adapter = new UserAdapter(R.layout.item_user,realmHelper.queryAll(User.class));
        recyclerView.setAdapter(adapter);
    }

    private void initData() {
        User user = null ;
        for(int u = 0 ;u < 20 ; u++){
            user = new User();
            user.setAge(u+10);
            user.setAvatarUrl("http://baidu.com/"+u);
            user.setPassWord("123456"+u);
            user.setSex((u%2==0 ? "男":"女"));
            user.setUserId(100+u);
            user.setUserName("用户"+u);
            users.add(user);
            realmHelper.add(user);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_list;
    }


}
