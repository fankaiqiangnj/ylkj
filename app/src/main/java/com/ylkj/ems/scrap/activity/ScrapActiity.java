package com.ylkj.ems.scrap.activity;

import android.os.Bundle;
import android.view.View;

import com.ylkj.ems.R;
import com.ylkj.ems.base.activity.BaseMvpActivity;
import com.ylkj.ems.home.activity.HomeActivity;
import com.ylkj.ems.login.activity.LoginActivity;
import com.ylkj.ems.scrap.contract.SrapContract;
import com.ylkj.ems.scrap.persenter.SrapPersenter;

import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class ScrapActiity extends BaseMvpActivity<SrapContract.ISrapPresenter> implements SrapContract.ISrapView{
    @Override
    protected SrapContract.ISrapPresenter createPresenter() {
        return new SrapPersenter();
    }

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_scrap;
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

    }

    @OnClick({R.id.loginout,R.id.home})
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
                showSweetDialogConfirm("确认回到首页吗？", new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        go(HomeActivity.class);
                    }
                });

                break;
            default:
                break;
        }
    }
}
