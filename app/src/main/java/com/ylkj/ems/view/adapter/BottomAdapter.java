package com.ylkj.ems.view.adapter;

import android.content.Context;
import android.view.View;

import com.ylkj.ems.R;
import com.ylkj.ems.base.adapter.BaseRecyclerAdapter;
import com.ylkj.ems.base.adapter.BaseRecylerViewHolder;

import java.util.List;

public class BottomAdapter extends BaseRecyclerAdapter<String>{
    Impl impl;
    public BottomAdapter(Context context, int resource, List<String> list,Impl impl) {
        super(context, resource, list);
        this.impl = impl;
    }

    @Override
    public void setConvert(final BaseRecylerViewHolder viewHolder, String s) {
        viewHolder.setTextView(R.id.item_text,s);
        viewHolder.getView(R.id.item_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                impl.itemClick(viewHolder.getAdapterPosition());
            }
        });

    }
    public interface Impl{
        void itemClick(int position);
    }
}
