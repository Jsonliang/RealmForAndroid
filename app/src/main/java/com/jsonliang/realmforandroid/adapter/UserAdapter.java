package com.jsonliang.realmforandroid.adapter;

import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jsonliang.realmforandroid.App;
import com.jsonliang.realmforandroid.R;
import com.jsonliang.realmforandroid.entity.User;
import com.jsonliang.realmforandroid.utils.RealmHelper;

import java.util.List;

/**
 * Created by Jsonliang on 2016/11/4.
 */

public class UserAdapter extends BaseQuickAdapter<User,BaseViewHolder> {
    private List<User> data ;
    private RealmHelper<User> realmHelper ;
    public UserAdapter(int layoutResId, List<User> data) {
        super(layoutResId, data);
        realmHelper = RealmHelper.getInstance(App.getInstance());
    }

    @Override
    protected void convert(BaseViewHolder helper, final User item) {
        helper.setText(R.id.tv_name, item.getUserName()+"")
                .setText(R.id.tv_id, item.getUserId()+"");

        final ImageView iv = helper.getView(R.id.iv_like);
        if (realmHelper.isExist("userId",item.getUserId(),item)){
            iv.setSelected(true);
        } else {
            iv.setSelected(false);
        }

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (iv.isSelected()) {
                    iv.setSelected(false);
                    realmHelper.delete(item.getUserId(),item);
                    UserAdapter.this.setNewData(realmHelper.queryAll(User.class));

                    UserAdapter.this.notifyDataSetChanged();
                } else {
                    iv.setSelected(true);
                    realmHelper.add(item);
                }
            }
        });

    }
}
