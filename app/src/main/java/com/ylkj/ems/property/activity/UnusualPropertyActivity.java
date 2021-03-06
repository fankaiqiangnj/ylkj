package com.ylkj.ems.property.activity;

import android.os.Bundle;

import com.ylkj.ems.R;
import com.ylkj.ems.base.activity.BaseMvpActivity;
import com.ylkj.ems.property.contract.UnusualPropertyContract;
import com.ylkj.ems.property.presenter.UnusualPropertyPresenter;

public class UnusualPropertyActivity extends BaseMvpActivity<UnusualPropertyContract.IUnusualPropertyPresenter> implements UnusualPropertyContract.IUnusualPropertyView{
    @Override
    protected UnusualPropertyContract.IUnusualPropertyPresenter createPresenter() {
        return new UnusualPropertyPresenter();
    }

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_unusualproperty;
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
}
