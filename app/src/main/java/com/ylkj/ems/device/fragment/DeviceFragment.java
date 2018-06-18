package com.ylkj.ems.device.fragment;

import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.ylkj.ems.R;
import com.ylkj.ems.base.fragment.BaseMvpFragment;
import com.ylkj.ems.base.util.BaseUtil;
import com.ylkj.ems.device.activity.AddDeviceActivity;
import com.ylkj.ems.device.contract.DeviceContract;
import com.ylkj.ems.device.persenter.DevicePresenter;
import com.ylkj.ems.view.adapter.BottomAdapter;

import java.util.ArrayList;

import butterknife.OnClick;

public class DeviceFragment extends BaseMvpFragment<DeviceContract.IDevicePresenter> implements DeviceContract.IDeviceView {

    public static DeviceFragment newInstance(Bundle bundle) {
        DeviceFragment fragment = new DeviceFragment();
        //fragment保存参数，传入一个Bundle对象
        fragment.setArguments(bundle);
        return fragment;
    }

    BottomSheetDialog dialog;

    @Override
    protected DeviceContract.IDevicePresenter createPresenter() {
        return new DevicePresenter();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_device;
    }

    @Override
    public void onCreateView(Bundle savedInstanceState) {

    }

    @Override
    public void initView() {

    }

    @OnClick({R.id.btn_add, R.id.deviceclass})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                go(AddDeviceActivity.class);

                break;
            case R.id.deviceclass:
                dialog = new BottomSheetDialog(mContext);
                View view = LayoutInflater.from(mContext).inflate(R.layout.dialog_bottom,null);
                RecyclerView recyclerView = view.findViewById(R.id.dialog_recycler);
                final ArrayList<String> list= new ArrayList<String>();
                for (int i=0;i<30;i++){
                    list.add("kaiqiang1"+i);
                    list.add("kaiqiang2"+i);
                    list.add("kaiqiang3"+i);
                }
                BottomAdapter adapter = new BottomAdapter(mContext, R.layout.dialog_item, list, new BottomAdapter.Impl() {
                    @Override
                    public void itemClick(int position) {
                        if (dialog!=null) {
                            BaseUtil.showToast(list.get(position));
                            dialog.dismiss();
                        }
                    }
                });
                recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
                recyclerView.setAdapter(adapter);
                dialog.setContentView(view);
                dialog.show();


                break;
            default:
                break;
        }

    }


}
