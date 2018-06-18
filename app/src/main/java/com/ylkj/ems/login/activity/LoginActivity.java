package com.ylkj.ems.login.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.ylkj.ems.R;
import com.ylkj.ems.base.activity.ActivityCollections;
import com.ylkj.ems.base.activity.BaseMvpActivity;
import com.ylkj.ems.base.util.BaseUtil;
import com.ylkj.ems.home.activity.HomeActivity;
import com.ylkj.ems.login.contract.LoginContract;
import com.ylkj.ems.login.presenter.LoginPresenter;
import com.ylkj.ems.util.EditDialog;

import butterknife.OnClick;

public class LoginActivity extends BaseMvpActivity<LoginContract.ILoginPresenter> implements LoginContract.ILoginView {
    private boolean isCanLogin = false;

    @Override
    protected LoginContract.ILoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.login;
    }


    @Override
    protected void getBundleExtras(Bundle extras) {
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
        if (Build.VERSION.SDK_INT >= 23) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)
                    != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                    != PackageManager.PERMISSION_GRANTED) {
                isCanLogin =false;
                //申请WRITE_EXTERNAL_STORAGE权限
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_PHONE_STATE, Manifest.permission.CAMERA}, 1);
            }else {
                isCanLogin =true;
            }
        }else {
            isCanLogin =true;
        }

    }

    @OnClick({R.id.loginsubmit, R.id.btn_set})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginsubmit:
                if (isCanLogin) {
                    goThenKill(HomeActivity.class);
                }else {
                    BaseUtil.showToast("请重启并同意所有权限");
                }
                break;
            case R.id.btn_set:
                EditDialog dialog = new EditDialog(this, new EditDialog.CallBack() {
                    @Override
                    public void dialogCarllBack(String s) {
                    }
                });
                dialog.show();
                break;
            default:
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        doNext(requestCode, grantResults);
    }

    private void doNext(int requestCode, int[] grantResults) {
        if (requestCode == 1) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED || grantResults[1] == PackageManager.PERMISSION_GRANTED || grantResults[2] == PackageManager.PERMISSION_GRANTED) {
                isCanLogin = true;
            } else {
                isCanLogin = false;
            }
        }
    }
}
