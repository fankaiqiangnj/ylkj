package com.ylkj.ems.mytask.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ylkj.ems.R;
import com.ylkj.ems.base.fragment.BaseMvpFragment;
import com.ylkj.ems.changeLabel.activity.ChangeLableActivity;
import com.ylkj.ems.device.activity.DeviceActivity;
import com.ylkj.ems.differencetask.activity.DifferencetaskActivity;
import com.ylkj.ems.label.activity.LabelActivity;
import com.ylkj.ems.mytask.adapter.MyTaskAdapter;
import com.ylkj.ems.mytask.contract.MyTasContract;
import com.ylkj.ems.mytask.pressenter.MyTaskPressenter;
import com.ylkj.ems.property.activity.CheckPropertyActivity;
import com.ylkj.ems.scrap.activity.ScrapActiity;

import java.util.ArrayList;

import butterknife.BindView;

public class MyTaskFragment extends BaseMvpFragment<MyTasContract.ITaskPresenter> implements MyTasContract.ITaskView, RadioGroup.OnCheckedChangeListener,MyTaskAdapter.TaskImp {
    @BindView(R.id.recycler_mytask)
    RecyclerView mTaskRecycler;
    @BindView(R.id.radiogroup_task)
    RadioGroup mRadioGroup;
    @BindView(R.id.radio_unfinshtask)
    RadioButton mRadioUnFinsh;

    private int taskType = 0;
    private MyTaskAdapter taskAdapter;
    private ArrayList<String> unFinshList = new ArrayList<>();
    private ArrayList<String> FinshList = new ArrayList<>();
    private ArrayList<String> list = new ArrayList<>();

    public static MyTaskFragment newInstance(Bundle bundle) {
        MyTaskFragment fragment = new MyTaskFragment();
        //fragment保存参数，传入一个Bundle对象
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected MyTasContract.ITaskPresenter createPresenter() {
        return new MyTaskPressenter();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_mytask;
    }

    @Override
    public void onCreateView(Bundle savedInstanceState) {
        if (getArguments() != null) {
            taskType = getArguments().getInt("taskType");
        }
        list.add("0");
        mTaskRecycler.setLayoutManager(new LinearLayoutManager(mContext));
        taskAdapter = new MyTaskAdapter(mContext, R.layout.item_mytask, list,this);
        mTaskRecycler.setAdapter(taskAdapter);
    }

    @Override
    public void initView() {
        mRadioGroup.setOnCheckedChangeListener(this);

    }

    public void changTaskType(int type) {
        taskType = type;
        mRadioUnFinsh.setChecked(true);
        list.clear();
        unFinshList.clear();
        for (int i = 0; i < type+1; i++) {
            list.add(i + "");
        }
        unFinshList.addAll(list);
        taskAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.radio_unfinshtask:
                list.clear();
                list.addAll(unFinshList);
                taskAdapter.notifyDataSetChanged();
                break;
            case R.id.radio_finshtask:
                list.clear();
                list.addAll(FinshList);
                taskAdapter.notifyDataSetChanged();
                break;
            default:
                break;
        }
    }

    @Override
    public void itemClick() {
        switch (taskType){
            case 0:

                break;
            case 1:
                go(LabelActivity.class);

                break;
            case 2:
                go(ChangeLableActivity.class);
                break;
            case 3:
                go(DifferencetaskActivity.class);

                break;
            case 4:
                go(CheckPropertyActivity.class);

                break;
            case 5:
                go(ScrapActiity.class);

                break;
            case 6:
                go(DeviceActivity.class);

                break;
            case 7:

                break;
            case 8:

                break;
            case 9:

                break;
            default:
                break;
        }
    }
}
