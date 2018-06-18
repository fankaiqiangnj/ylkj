package com.ylkj.ems.property.activity;

import android.os.Bundle;
import android.view.View;

import com.ylkj.ems.R;
import com.ylkj.ems.base.activity.BaseMvpActivity;
import com.ylkj.ems.property.contract.CheckPropertyContract;
import com.ylkj.ems.property.presenter.CheckPropertyPresenter;

import butterknife.OnClick;

/**
 * @author kail
 */
public class CheckPropertyActivity extends BaseMvpActivity<CheckPropertyContract.ICheckPropertyPresenter> implements CheckPropertyContract.ICheckPropertyView{
    @Override
    protected CheckPropertyContract.ICheckPropertyPresenter createPresenter() {
        return new CheckPropertyPresenter();
    }

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_checkproperty;
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

    @OnClick({R.id.btnAddDevice})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnAddDevice:
                go(UnusualPropertyActivity.class);

                break;
            default:
                break;
        }

    }
}
