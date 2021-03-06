package com.ylkj.ems.home.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioGroup;

import com.ylkj.ems.R;
import com.ylkj.ems.base.activity.ActivityCollections;
import com.ylkj.ems.base.activity.BaseMvpActivity;
import com.ylkj.ems.device.fragment.DeviceFragment;
import com.ylkj.ems.home.contract.HomeContract;
import com.ylkj.ems.home.presenter.HomePresenter;
import com.ylkj.ems.login.activity.LoginActivity;
import com.ylkj.ems.mytask.fragment.MyTaskFragment;
import com.ylkj.ems.set.SetFragment;

import butterknife.BindView;
import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class HomeActivity extends BaseMvpActivity<HomeContract.IHomePresenter> implements HomeContract.IHomeView, RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.tabs_rg)
    RadioGroup mRadioGroup;

    FragmentManager fragmentManager;
    Fragment fragment;


    @Override
    protected HomeContract.IHomePresenter createPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.home;
    }

    @Override
    protected boolean isApplyStatusBarTranslucency() {
        return true;
    }

    @Override
    protected boolean isCustomPendingTransition() {
        return true;
    }

    @Override
    protected TransitionMode getCustomPendingTransitionType() {
        return TransitionMode.FADE;
    }

    @Override
    protected void initViewsAndEvents() {
        ActivityCollections.getInstance().clearToTop();
        Bundle bundle = new Bundle();
        bundle.putInt("taskType", 0);
        fragmentManager = getSupportFragmentManager();
        MyTaskFragment taskFragment = MyTaskFragment.newInstance(bundle);
        addFragment(R.id.tab_content, taskFragment, "tag_mytask");
        mRadioGroup.setOnCheckedChangeListener(this);
    }

    @OnClick({R.id.loginout, R.id.home})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginout:
                showSweetDialogConfirm("确认退出当前用户吗？", new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        go(LoginActivity.class);
                    }
                });
                break;
            case R.id.home:

                break;
            default:
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            showSweetDialogConfirm("确认退出应用吗？", new SweetAlertDialog.OnSweetClickListener() {
                @Override
                public void onClick(SweetAlertDialog sweetAlertDialog) {
                    sweetAlertDialog.dismiss();
                    finish();
                }
            });
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.tab_rb_e:
                //我的任务
                fragment = fragmentManager.findFragmentById(R.id.tab_content);
                if (fragment instanceof MyTaskFragment) {
                    MyTaskFragment myTaskFragment = (MyTaskFragment) fragment;
                    myTaskFragment.changTaskType(0);
                } else {
                    MyTaskFragment myTaskFragment = (MyTaskFragment) fragmentManager.findFragmentByTag("tag_mytask");
                    if (myTaskFragment == null) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("taskType", 0);
                        changeFragment(R.id.tab_content, MyTaskFragment.newInstance(bundle), "tag_mytask");
                    } else {
                        myTaskFragment.changTaskType(0);
                        changeFragment(R.id.tab_content, myTaskFragment, "tag_mytask");
                    }
                }

                break;
            case R.id.tab_rb_a:
                //资产标贴
                fragment = fragmentManager.findFragmentById(R.id.tab_content);
                if (fragment instanceof MyTaskFragment) {
                    MyTaskFragment myTaskFragment = (MyTaskFragment) fragment;
                    myTaskFragment.changTaskType(1);
                } else {
                    MyTaskFragment myTaskFragment = (MyTaskFragment) fragmentManager.findFragmentByTag("tag_mytask");
                    if (myTaskFragment == null) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("taskType", 1);
                        changeFragment(R.id.tab_content, MyTaskFragment.newInstance(bundle), "tag_mytask");
                    } else {
                        myTaskFragment.changTaskType(1);
                        changeFragment(R.id.tab_content, myTaskFragment, "tag_mytask");
                    }
                }
                break;
            case R.id.tab_rb_H:
                //标签更换
                fragment = fragmentManager.findFragmentById(R.id.tab_content);
                if (fragment instanceof MyTaskFragment) {
                    MyTaskFragment myTaskFragment = (MyTaskFragment) fragment;
                    myTaskFragment.changTaskType(2);
                } else {
                    MyTaskFragment myTaskFragment = (MyTaskFragment) fragmentManager.findFragmentByTag("tag_mytask");
                    if (myTaskFragment == null) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("taskType", 2);
                        changeFragment(R.id.tab_content,  MyTaskFragment.newInstance(bundle), "tag_mytask");
                    } else {
                        myTaskFragment.changTaskType(2);
                        changeFragment(R.id.tab_content, myTaskFragment, "tag_mytask");
                    }
                }
                break;
            case R.id.tab_rb_b:
                //资产异动
                fragment = fragmentManager.findFragmentById(R.id.tab_content);
                if (fragment instanceof MyTaskFragment) {
                    MyTaskFragment myTaskFragment = (MyTaskFragment) fragment;
                    myTaskFragment.changTaskType(3);
                } else {
                    MyTaskFragment myTaskFragment = (MyTaskFragment) fragmentManager.findFragmentByTag("tag_mytask");
                    if (myTaskFragment == null) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("taskType", 3);
                        changeFragment(R.id.tab_content, MyTaskFragment.newInstance(bundle), "tag_mytask");
                    } else {
                        changeFragment(R.id.tab_content, myTaskFragment, "tag_mytask");
                    }
                }
                break;
            case R.id.tab_rb_d:
                //资产盘点
                fragment = fragmentManager.findFragmentById(R.id.tab_content);
                if (fragment instanceof MyTaskFragment) {
                    MyTaskFragment myTaskFragment = (MyTaskFragment) fragment;
                    myTaskFragment.changTaskType(4);
                } else {
                    MyTaskFragment myTaskFragment = (MyTaskFragment) fragmentManager.findFragmentByTag("tag_mytask");
                    if (myTaskFragment == null) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("taskType", 4);
                        changeFragment(R.id.tab_content, MyTaskFragment.newInstance(bundle), "tag_mytask");
                    } else {
                        myTaskFragment.changTaskType(4);
                        changeFragment(R.id.tab_content, myTaskFragment, "tag_mytask");
                    }
                }
                break;
            case R.id.tab_rb_c:
                //资产报废
                fragment = fragmentManager.findFragmentById(R.id.tab_content);
                if (fragment instanceof MyTaskFragment) {
                    MyTaskFragment myTaskFragment = (MyTaskFragment) fragment;
                    myTaskFragment.changTaskType(5);
                } else {
                    MyTaskFragment myTaskFragment = (MyTaskFragment) fragmentManager.findFragmentByTag("tag_mytask");
                    if (myTaskFragment == null) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("taskType", 5);
                        changeFragment(R.id.tab_content, MyTaskFragment.newInstance(bundle), "tag_mytask");
                    } else {
                        myTaskFragment.changTaskType(5);
                        changeFragment(R.id.tab_content, myTaskFragment, "tag_mytask");
                    }
                }
                break;
            case R.id.tab_rb_i:
                //设备查询
                if (fragmentManager.findFragmentByTag("tag_device") != null) {
                    changeFragment(R.id.tab_content, fragmentManager.findFragmentByTag("tag_device"), "tag_device");
                } else {
                    changeFragment(R.id.tab_content, DeviceFragment.newInstance(null), "tag_device");
                }

                break;
            case R.id.tab_rb_h:
                //数据中心
                disMissProgess();
                break;
            case R.id.tab_rb_j:
                //管理中心
                if (fragmentManager.findFragmentByTag("tag_set") != null) {
                    changeFragment(R.id.tab_content, fragmentManager.findFragmentByTag("tag_set"), "tag_set");
                } else {
                    changeFragment(R.id.tab_content, SetFragment.newInstance(null), "tag_set");
                }

                break;
            case R.id.tab_rb_g:
                //辅助工具

                break;
            default:
                break;
        }
    }


}
