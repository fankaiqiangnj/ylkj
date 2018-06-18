package com.ylkj.ems.mytask.adapter;

import android.content.Context;
import android.view.View;

import com.ylkj.ems.R;
import com.ylkj.ems.base.adapter.BaseRecyclerAdapter;
import com.ylkj.ems.base.adapter.BaseRecylerViewHolder;
import com.ylkj.ems.util.DateUtil;

import java.util.Date;
import java.util.List;

public class MyTaskAdapter extends BaseRecyclerAdapter<String> {
    TaskImp taskImp;

    public MyTaskAdapter(Context context, int resource, List<String> list, TaskImp taskImp) {
        super(context, resource, list);
        this.taskImp = taskImp;
    }

    @Override
    public void setConvert(BaseRecylerViewHolder viewHolder, String s) {
        viewHolder.setTextView(R.id.mytask_date, "时间：" + DateUtil.date2String(new Date()));
        viewHolder.getView(R.id.task_item).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                taskImp.itemClick();
            }
        });

    }

    public interface TaskImp {
        void itemClick();
    }

}
