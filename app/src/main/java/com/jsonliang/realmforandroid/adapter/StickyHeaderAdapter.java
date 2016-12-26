package com.jsonliang.realmforandroid.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jiang.android.lib.adapter.expand.StickyRecyclerHeadersAdapter;
import com.jsonliang.realmforandroid.entity.Person;

import java.util.List;

/**
 * Created by Jsonliang on 2016/11/4.
 */

public class StickyHeaderAdapter extends BaseQuickAdapter<Person,BaseViewHolder>
implements StickyRecyclerHeadersAdapter<StickyHeaderAdapter.HeadHolder> {


    public StickyHeaderAdapter(int layoutResId, List<Person> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, Person item) {

    }

    @Override
    public long getHeaderId(int position) {
        return 0;
    }

    @Override
    public HeadHolder onCreateHeaderViewHolder(ViewGroup parent) {
        // TODO 这里创建 Header的View
        View headView = null ;
        return new HeadHolder(headView);
    }

    @Override
    public void onBindHeaderViewHolder(HeadHolder holder, int position) {
        // holder.textView = getData().get(position).
    }



    /**
     * 头部的Holder
     */
    public static class HeadHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public HeadHolder(View itemView) {
            super(itemView);

        }
    }
}
